package com.example.demo.加餐;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Test02 {

    private String toStringTest02(String a) {
        return a.toString();
    }

    public static void main(String[] args) {

/*        String o = (String) Optional.of("A")//返回一个指定非null值的Optional。

                .orElse("666");//return value != null ? value : other;

        // 如果存在该值，返回值， 否则触发 other，并返回 other 调用的结果
        String o1 = (String) Optional.of("A")
                .orElseGet(() -> "C");//return value != null ? value : other.get();

        log.info(o, o1);

        Object o2 = Optional.ofNullable(null)//如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
                .orElseGet(() -> "C");
        Object o3 = Optional.ofNullable(null).orElse("66");
        Optional<Object> o4 = Optional.ofNullable(null);//如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
        */



    }
}
