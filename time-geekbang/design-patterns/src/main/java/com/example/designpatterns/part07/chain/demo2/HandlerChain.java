package com.example.designpatterns.part07.chain.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * date: 2021/3/15 18:02
 *
 * @author dqk
 */
public class HandlerChain {
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}
