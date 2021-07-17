package org.geekbang.time.commonmistakes.redundantcode.reflection.myright;

import java.math.BigDecimal;
import java.math.RoundingMode;

enum BankAPIFieldTypeEnum {
    S {
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            return String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ', '_');
        }
    },
    N {
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            return String.format("%" + bankAPIField.length() + "s", value.toString()).replace(' ', '0');
        }
    },
    M {
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            if (!(value instanceof BigDecimal))
                throw new RuntimeException(String.format("{} 的 {} 必须是BigDecimal", bankAPIField, value));
            return String.format("%0" + bankAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue());
        }
    },
    Default {
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            return String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ', '_');
        }
    },
    ;


    public abstract String format(Object value, BankAPIField bankAPIField);
}