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
import java.util.function.BiConsumer;
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
        // 声明函数对象 consumer
        //Consumer<StringBuilder> consumer = new Consumer<StringBuilder>() {
        //            @Override
        //            public void accept(StringBuilder str) {
        //                str.append("大SB");
        //            }
        //        };
        // 调用Consumer.accept()方法接收参数
        StringBuilder sb = new StringBuilder("sb字符串后面将会跟随####");
        Consumer<StringBuilder> consumer = (str) -> str.append("123");
        consumer.accept(sb);
        System.out.println(sb.toString());

        //相当于是 arg参数是accept(参数) 的参数传递过来的
        Consumer<Integer> a = arg -> System.out.println(arg.compareTo(123));
        a.accept(1111);
        System.out.println("----------------------------------");

        Function<String, Integer> stringFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return "123".equals(s) ? 1 : 0;
            }
        };
        System.out.println(stringFunction.apply("123333"));

        System.out.println("-----------------------------------------");

        BiConsumer<String, Integer> integerBiConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s + ":" + integer);
            }
        };
        integerBiConsumer.accept("Ceshi", 123);//输出Ceshi:123 说明执行了accept方法一次


        BiConsumer<String, Integer> testIntegerBiConsumer = integerBiConsumer.andThen(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("123" + integer);
            }
        });
        /*
        *     default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
                Objects.requireNonNull(after);

                return (l, r) -> {
                    accept(l, r);
                    after.accept(l, r);
                };
            }
        * */
        //说明先执行accept()方法,之后会执行andThen方法里面的accept方法
        testIntegerBiConsumer.accept("666", 666);//输出666:666 /n 123666
        integerBiConsumer.accept("Ceshi", 123);//输出Ceshi:123 说明执行了accept方法一次

        System.out.println("-----------------------------------------");


        BiConsumer<String, Function<String, Integer>> biConsumer = new BiConsumer<String, Function<String, Integer>>() {
            @Override
            public void accept(String s, Function<String, Integer> stringIntegerFunction) {

            }
        };

        biConsumer.accept("123", stringFunction);


    }

/*    // 参数是 BiConsumer(AbstractProductServiceRequest) 返回Function<ProductServiceQueryRequest, ProductServiceQueryResponse> 参数是ProductServiceQueryRequest 返回ProductServiceQueryResponse
    public BiConsumer<AbstractProductServiceRequest, Function<ProductServiceQueryRequest, ProductServiceQueryResponse>> operateConsumer(){
        switch (serviceOperationEnum) {
            case OPEN:
                return openConsumer();
            case CLOSE:
                return closeConsumer();
            default:
                throw new RuntimeException("not support OperationType");
        }
    }*/


    /*

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