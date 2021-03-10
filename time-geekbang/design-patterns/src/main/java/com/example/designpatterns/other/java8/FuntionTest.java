package com.example.designpatterns.other.java8;

import java.util.function.Function;

/**
 * Description:
 * date: 2021/3/10 10:32
 *
 * @author dqk
 */
public class FuntionTest {
    public static void main(String[] args) {
        System.out.println("-------------Function---------------------");
        Function<String, Boolean> stringFunction = "123"::equals;
        System.out.println(stringFunction.apply("123333"));


        /* andThen(Function<? super R,? extends V> after)返回一个组合函数，首先将该函数应用于其输入，然后将 after函数应用于结果。
        stringFunction.compose()*/

        Function<String, String> stringFunction1 = stringFunction.andThen(o -> {
            if (o) {
                System.out.println("yes");
            }
            return "null";
        });

        System.out.println(stringFunction1.apply("123"));


    }
}
