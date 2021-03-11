package com.example.designpatterns.part06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 * date: 2021/3/11 9:56
 *
 * @author dqk
 */
public class DemoProxy {

    private Demo demo;

    private DemoProxy() {
        demo = new Demo();
    }

    private Object createProxy(Object proxiedObject) {
        Class[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private static class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理方法之前");
            Object result = method.invoke(proxiedObject, args);
            System.out.println("代理方法之后");
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            System.out.println(apiName);
            return result;

        }
    }

    public static void main(String[] args) {
        //jdk代理模式必须实现相同的接口
        DemoProxy proxy = new DemoProxy();
        IDemo userController = (IDemo) proxy.createProxy(new Demo());
        userController.demoTest();
    }
}