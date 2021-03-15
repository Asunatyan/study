package com.example.designpatterns.part07.observer.eventBus;

import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus {
  public AsyncEventBus(Executor executor) {
    super(executor);
  }
}