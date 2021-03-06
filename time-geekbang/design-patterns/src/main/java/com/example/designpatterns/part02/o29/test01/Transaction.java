/*
package com.example.designpatterns.part02.o29.test01;

import javax.transaction.InvalidTransactionException;

public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

    // ...get() methods...

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }

    */
/**
     * 单元测试主要是测试程序员自己编写的代码逻辑的正确性，并非是端到端的集成测试，它不需要测试所依赖的外部系统（分布式锁、Wallet RPC 服务）的逻辑正确性
     * <p>
     * <p>
     * execute() 函数的执行依赖两个外部的服务，一个是 RedisDistributedLock，一个 WalletRpcService。这就导致上面的单元测试代码存在下面几个问题。
     * 如果要让这个单元测试能够运行，我们需要搭建 Redis 服务和 Wallet RPC 服务。搭建和维护的成本比较高。我们还需要保证将伪造的 transaction 数据发送给 Wallet RPC 服务之后，能够正确返回我们期望的结果，
     * 然而 Wallet RPC 服务有可能是第三方（另一个团队开发维护的）的服务，并不是我们可控的。换句话说，并不是我们想让它返回什么数据就返回什么。
     * Transaction 的执行跟 Redis、RPC 服务通信，需要走网络，耗时可能会比较长，对单元测试本身的执行性能也会有影响。网络的中断、超时、Redis、RPC 服务的不可用，都会影响单元测试的执行。
     *
     * @return
     * @throws InvalidTransactionException
     *//*

    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null || (sellerId == null || amount < 0.0) {//参数校验
            throw new InvalidTransactionException(...);
        }
        if (status == STATUS.EXECUTED) return true; //交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
        boolean isLocked = false;
        try {
            //单例相当于一个全局变量，我们无法 mock（无法继承和重写方法），也无法通过依赖注入的方式来替换。
            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(id);//获取锁
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED) return true; // double check    ??????
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > 14) {//天){//判断校验是否过期
                this.status = STATUS.EXPIRED;
                return false;
            }
            // 应该通过依赖注入而不是new出来
            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);//转钱操作
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;//不再重复执行转钱逻辑，返回 true。
                return true;
            } else {
                this.status = STATUS.FAILED;//交易失败
                return false;
            }
        } finally {
            if (isLocked) {
                RedisDistributedLock.getSingletonIntance().unlockTransction(id);//解锁
            }
        }
    }

    private class WalletRpcService {
        public String moveMoney(String id, Long buyerId, Long sellerId, Double amount) {
            return null;
        }
    }

    private static class IdGenerator {

        public static String generateTransactionId() {
            return null;
        }
    }

    enum STATUS {
        TO_BE_EXECUTD, FAILED, EXPIRED, EXECUTED

    }

    private static class RedisDistributedLock {
        public static Object getSingletonIntance() {
            return null;
        }
    }


}*/
