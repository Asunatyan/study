package org.geekbang.time.commonmistakes.redundantcode.reflection.myright;

import lombok.Data;

import java.math.BigDecimal;

@BankAPI(url = "/bank/pay", desc = "支付接口")
@Data
public class PayAPI extends AbstractAPI {
    @BankAPIField(order = 1, type = BankAPIFieldTypeEnum.N, length = 20)
    private long userId;
    @BankAPIField(order = 2, type = BankAPIFieldTypeEnum.M, length = 10)
    private BigDecimal amount;
}
