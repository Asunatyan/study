package com.example.demo.o1;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


@Slf4j
@RestController
@Controller
public class Demo1to1 {


    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);


    @GetMapping("wrong")
    public Map<String, String> wrong(@RequestParam("userId") Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);  //多线程会有问题，因为tomcat是使用线程池的
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after = Thread.currentThread().getName() + ":" + currentUser.get();

        //汇总输出两次查询结果
        Map<String, String> result = new HashMap<>();
        result.put("before", before);
        result.put("after", after);
        return result;
    }


    //线程个数
    private static int THREAD_COUNT = 10;
    //总元素数量
    private static int ITEM_COUNT = 1000;

    /*

     * */

    //帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
    private ConcurrentHashMap<String, Long> getData(int count) {

        return LongStream
                //LongStream返回有序顺序 LongStream从 startInclusive （含）至 endInclusive通过的递增步长（含） rangeClosed(long startInclusive, long endInclusive)
                .rangeClosed(1, count)
                .boxed()
                //返回一个Stream由该流的盒装到所述的元件，每个的Long
                .collect(
                        Collectors.toConcurrentMap(
                                //keyMapper - 产生密钥的映射函数
                                //valueMapper - 产生值的映射函数
                                //mergeFunction - 一个合并函数，用于解决与相同键相关联的值之间的冲突，提供给 Map.merge(Object, Object, BiFunction)
                                //mapSupplier - 返回一个新的，空的 Map的函数，结果将被插入到该函数中
                                i -> UUID.randomUUID().toString(),//key
                                Function.identity(),//value   t->t
                                (o1, o2) -> o1,
                                ConcurrentHashMap::new
                        )
                );
    }

    @GetMapping("wrongTest")
    public void wrong() throws InterruptedException {
        //初始900个元素
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);//ITEM_COUNT = 1000
        log.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);//THREAD_COUNT = 10
        //使用线程池并发处理逻辑
        //Runnable
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            //查询还需要补充多少个元素
            int gap = ITEM_COUNT - concurrentHashMap.size();
            log.info("gap size:{}", gap);
            //补充元素
            concurrentHashMap.putAll(getData(gap));
        }));
        //等待所有任务完成
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //最后元素个数会是1000吗？
        log.info("finish size:{}", concurrentHashMap.size());

        /*
2021-01-25 16:04:37.877  INFO 8632 --- [nio-8080-exec-4] com.example.demo.o1.lesson1              : init size:900
2021-01-25 16:04:37.880  INFO 8632 --- [Pool-3-worker-9] com.example.demo.o1.lesson1              : gap size:100
2021-01-25 16:04:37.880  INFO 8632 --- [Pool-3-worker-4] com.example.demo.o1.lesson1              : gap size:100
2021-01-25 16:04:37.880  INFO 8632 --- [Pool-3-worker-6] com.example.demo.o1.lesson1              : gap size:100
2021-01-25 16:04:37.881  INFO 8632 --- [ool-3-worker-11] com.example.demo.o1.lesson1              : gap size:88
2021-01-25 16:04:37.881  INFO 8632 --- [Pool-3-worker-4] com.example.demo.o1.lesson1              : gap size:0
2021-01-25 16:04:37.882  INFO 8632 --- [ool-3-worker-15] com.example.demo.o1.lesson1              : gap size:0
2021-01-25 16:04:37.882  INFO 8632 --- [ool-3-worker-15] com.example.demo.o1.lesson1              : gap size:-100
2021-01-25 16:04:37.882  INFO 8632 --- [Pool-3-worker-4] com.example.demo.o1.lesson1              : gap size:-108
2021-01-25 16:04:37.882  INFO 8632 --- [Pool-3-worker-2] com.example.demo.o1.lesson1              : gap size:-188
2021-01-25 16:04:37.882  INFO 8632 --- [Pool-3-worker-6] com.example.demo.o1.lesson1              : gap size:-100
2021-01-25 16:04:37.886  INFO 8632 --- [nio-8080-exec-4] com.example.demo.o1.lesson1              : finish size:1288
          * */
    }


    @GetMapping("right")
    public String right() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);
        log.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            //下面的这段复合逻辑需要锁一下这个ConcurrentHashMap
            synchronized (concurrentHashMap) {
                int gap = ITEM_COUNT - concurrentHashMap.size();
                log.info("gap size:{}", gap);
                concurrentHashMap.putAll(getData(gap));
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);


        log.info("finish size:{}", concurrentHashMap.size());
        return "OK";
    }
}
