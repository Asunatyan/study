package com.example.demo.o1;

import java.util.*;
import java.util.function.BiFunction;

public class Test01 {

    public static void main(String[] args) {

        //rangeClosed 返回有序顺序 LongStream从 startInclusive （含）至 endInclusive通过的递增步长（含） 1 。
        //System.out.println(Arrays.toString(LongStream.rangeClosed(1, 10).toArray()));

        //.boxed() 返回一个Stream由该流的盒装到所述的元件，每个的Long 。这是一个intermediate operation 。
        //LongStream.rangeClosed(1, 10).boxed().forEach(System.out::println);


        int[] numbers = {1, 10};
        //identity =默认值或初始值      int reduce(int identity, IntBinaryOperator op);
        int sum = Arrays.stream(numbers).reduce(10, Integer::sum);
        int sum2 = Arrays.stream(numbers).reduce(10, (a, b) -> a + b);

        //OptionalInt reduce(IntBinaryOperator op);
        OptionalInt sum3 = Arrays.stream(numbers).reduce((a, b) -> a + b);

        System.out.println("sum : " + sum + "sum2 : " + sum2); //


/**
 * absent
 * 英[ˈæbsənt , æbˈsent]
 * 美[ˈæbsənt , æbˈsent]
 * adj.	缺席; 缺少; 心不在焉的; 不在; 不存在; 出神的;
 *
 *
 present
 英[ˈpreznt , prɪˈzent]
 美[ˈpreznt , prɪˈzent]
 adj.	存在; 出现; 出席; 在场; 当前的; 现存的;

 */
        Map<String, List<String>> map = new HashMap<>();


        map.computeIfAbsent("2", key -> new ArrayList<>());

/*        List<String> apples = map.computeIfPresent("2", new BiFunction<String, List<String>, List<String>>() {
            @Override
            public List<String> apply(String s, List<String> apples) {
                return new ArrayList<String>();
            }
        });*/

        map.computeIfPresent("2", (str, list) -> {
            list.add(str);
            return list;
        });

        System.out.println(map.get(0));

    }
}
