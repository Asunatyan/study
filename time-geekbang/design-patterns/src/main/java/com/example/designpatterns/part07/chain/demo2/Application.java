package com.example.designpatterns.part07.chain.demo2;

/**
 * Description:
 * date: 2021/3/15 18:02
 *
 * @author dqk
 */ // 使用举例
public class Application {
  public static void main(String[] args) {
    HandlerChain chain = new HandlerChain();
    chain.addHandler(new HandlerA());
    chain.addHandler(new HandlerB());
    chain.handle();
  }
}
