package org.geekbang.time.commonmistakes.redundantcode.reflection.myright;

import lombok.Data;

@BankAPI(url = "/bank/createUser", desc = "创建用户接口")
@Data
public class CreateUserAPI extends AbstractAPI {
    @BankAPIField(order = 1, type = BankAPIFieldTypeEnum.S, length = 10)
    private String name;
    @BankAPIField(order = 2, type = BankAPIFieldTypeEnum.S, length = 18)
    private String identity;
    @BankAPIField(order = 4, type = BankAPIFieldTypeEnum.S, length = 11)
    private String mobile;
    @BankAPIField(order = 3, type = BankAPIFieldTypeEnum.N, length = 5)
    private int age;
}
