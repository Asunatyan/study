package com.example.designpatterns.part07.chain.demo1;

/**
 * Description:
 * date: 2021/3/15 17:51
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
