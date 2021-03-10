package com.example.designpatterns.other.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Description:
 * date: 2021/3/10 10:23
 *
 * @author dqk
 */
public class BiConsumerTest {

    public static void main(String[] args) {
        System.out.println("---------------Consumer--------------------------");
        // 调用Consumer.accept()方法接收参数
        StringBuilder sb = new StringBuilder("sb字符串后面将会跟随####");
        //相当于是 arg参数是accept(参数) 的参数传递过来的
        Consumer<StringBuilder> consumer = new Consumer<StringBuilder>() {
            @Override
            public void accept(StringBuilder arg) {
                arg.append("123");//相当于 sb.append()
            }
        };
        consumer.accept(sb);
        System.out.println(sb.toString());


        System.out.println("---------------BiConsumer--------------------------");
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

        /*按顺序执行此操作，后跟 after操作
        *     default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
                Objects.requireNonNull(after);
                return (l, r) -> {
                    accept(l, r);
                    after.accept(l, r);
                };
            }
        **/

        //说明先执行accept()方法,之后会执行andThen方法里面的accept方法

        testIntegerBiConsumer.accept("666", 666);//输出666:666 /n 123666
        integerBiConsumer.accept("Ceshi", 123);//输出Ceshi:123 说明执行了accept方法一次

        System.out.println("-----------------------------------------");


        BiConsumer<String, Function<String, Integer>> biConsumer = new BiConsumer<String, Function<String, Integer>>() {
            @Override
            public void accept(String s, Function<String, Integer> stringIntegerFunction) {

            }
        };

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        //BiConsumer<> action  有点类似于匿名内部类,方法里面调用了匿名内部类的某个方法
        BiConsumer<String, String> action = (k, v) -> System.out.println(k+":"+v);
        BiConsumer<String, String> stringStringBiConsumer = action.andThen((k, v) -> System.out.println("hhhhh->"+k+":"+v));
        map.forEach(stringStringBiConsumer);

    }

}
