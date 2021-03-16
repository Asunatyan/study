package com.example.designpatterns.part07.chain.demo1;

/**
 * Description:
 * date: 2021/3/15 17:51
 *
 * @author dqk
 */
public class HandlerB extends Handler {
  @Override
  public void handle() {
    boolean handled = false;
    //...
    if (!handled && successor != null) {
      successor.handle();
    }
  }
}
