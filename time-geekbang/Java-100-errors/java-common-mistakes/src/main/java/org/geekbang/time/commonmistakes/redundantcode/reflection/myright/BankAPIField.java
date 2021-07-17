package org.geekbang.time.commonmistakes.redundantcode.reflection.myright;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {
    int order() default -1;

    int length() default -1;

    BankAPIFieldTypeEnum type() default BankAPIFieldTypeEnum.Default;//修改成枚举
}
