/*
package com.example.designpatterns.part02.o29.test01;

public class TransactionLock {
    public boolean lock(String id) {
        return RedisDistributedLock.getSingletonIntance().lockTransction(id);
    }

    public void unlock() {
        RedisDistributedLock.getSingletonIntance().unlockTransction(id);
    }

    public static void main(String[] args) {

    }

    public static void main(String[] args) {
        TransactionLock mockLock = new TransactionLock() {
            public boolean lock(String id) {//重写类中的方法
                return true;
            }

            public void unlock() {
            }
        };
    }
}*/
