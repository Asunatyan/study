package com.example.designpatterns.part01.common.pro.plus;


import com.example.designpatterns.part01.common.MetricsStorage;
import com.example.designpatterns.part01.common.RedisMetricsStorage;
import com.example.designpatterns.part01.common.pro.Aggregator;
import com.example.designpatterns.part01.common.pro.ConsoleViewer;
import com.example.designpatterns.part01.common.pro.StatViewer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsoleReporter extends ScheduledReporter {
    private ScheduledExecutorService executor;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    } // 兼顾灵活性和代码的可测试性，这个构造函数继续保留

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    } // 省略其他代码...


    public static void main(String[] args) {
        /*Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("b111", "2");
        map.computeIfAbsent("c", s -> "222");
        map.computeIfPresent("b111", (s, s2) -> s + s2);

        System.out.println(map);*/


        // 创建字符串对象
        StringBuilder sb = new StringBuilder("sb字符串后面将会跟随####");
        // 声明函数对象 consumer
        //Consumer<StringBuilder> consumer = new Consumer<StringBuilder>() {
        //            @Override
        //            public void accept(StringBuilder str) {
        //                str.append("大SB");
        //            }
        //        };
        Consumer<StringBuilder> consumer = (str) -> str.append("123");
        // 调用Consumer.accept()方法接收参数
        consumer.accept(sb);
        System.out.println(sb.toString());

        //相当于是 arg参数是accept(参数) 的参数传递过来的
        Consumer<Integer> a = arg -> System.out.println(arg.compareTo(123));
        a.accept(1111);


    }

    /*public BiConsumer<AbstractProductServiceRequest, Function<ProductServiceQueryRequest, ProductServiceQueryResponse>> operateConsumer(){
        switch (serviceOperationEnum) {
            case OPEN:
                return openConsumer();
            case CLOSE:
                return closeConsumer();
            default:
                throw new RuntimeException("not support OperationType");
        }
    }

    public class ShapeFactory {
        final static Map<String, Supplier<Shape>> map = new HashMap<>();
        static {
            map.put("CIRCLE", Circle::new);
            map.put("RECTANGLE", Rectangle::new);
        }
        public Shape getShape(String shapeType){
            Supplier<Shape> shape = map.get(shapeType.toUpperCase());
            if(shape != null) {
                return shape.get();
            }
            throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
        }
    }*/
}