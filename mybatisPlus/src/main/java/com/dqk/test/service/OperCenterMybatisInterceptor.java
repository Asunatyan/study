/*
package com.dqk.test.service;

import com.dqk.test.mybatis.MybatisInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "select", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
@Component
public class OperCenterMybatisInterceptor extends MybatisInterceptor implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public BigInteger getOperId() {
        return BigInteger.ZERO;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        OperCenterMybatisInterceptor.applicationContext = applicationContext;
    }


}
*/
