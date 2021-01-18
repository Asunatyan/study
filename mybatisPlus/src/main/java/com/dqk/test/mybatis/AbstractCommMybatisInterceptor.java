package com.dqk.test.mybatis;

import com.dqk.test.generator.BaseDto;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractCommMybatisInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(AbstractCommMybatisInterceptor.class);

    public abstract void doMap(Map tmp, String sqlStrUpperCaseTrim);

    public abstract void doBaseDto(BaseDto tmp, String sqlStrUpperCaseTrim);

    private void doList(List tmpList, String sqlStrUpperCaseTrim) {
        Object data0 = tmpList.get(0);
        if (data0 != null) {
            if (data0 instanceof Map) {
                for (Object obj : tmpList) {
                    Map tmp = (Map) obj;
                    doMap(tmp, sqlStrUpperCaseTrim);
                }
            } else if (data0 instanceof BaseDto) {
                for (Object obj : tmpList) {
                    BaseDto tmp = (BaseDto) obj;
                    doBaseDto(tmp, sqlStrUpperCaseTrim);
                }
            }
        }
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // invocation.getMethod().getName();
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
            if (parameter != null) {
                BoundSql boundSql = mappedStatement.getBoundSql(parameter);
                String sqlStrUpperCaseTrim = boundSql.getSql().trim().toUpperCase();
                if (parameter instanceof Map) {
                    Map tmp = (Map) parameter;
                    doMap(tmp, sqlStrUpperCaseTrim);
                    Object listBatis = null;
                    if (tmp.containsKey("list")) {
                        listBatis = tmp.get("list");
                    }
//					try {
//					} catch (Exception e) {
//						logger.info("[intercept].[tmp.get(\"list\")].cause exception,msg is{},sql is:{}",e.getMessage(),sqlStrUpperCaseTrim);
//					}
                    if (listBatis != null && listBatis instanceof List) {
                        List tmpList = (List) listBatis;
                        doList(tmpList, sqlStrUpperCaseTrim);
                    }
                } else if (parameter instanceof BaseDto) {
                    BaseDto tmp = (BaseDto) parameter;
                    doBaseDto(tmp, sqlStrUpperCaseTrim);
                } else if (parameter instanceof List) {
                    List tmpList = (List) parameter;
                    doList(tmpList, sqlStrUpperCaseTrim);
                }
            }

        }
        //
        String sqlId = mappedStatement.getId();
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Configuration configuration = mappedStatement.getConfiguration();
        if (logger.isDebugEnabled()) {
            logger.debug(sqlId + "\r\n" + showSql(configuration, boundSql));
        }
        long start = System.currentTimeMillis();
        Object returnValue = null;
        returnValue = invocation.proceed();
        if (logger.isDebugEnabled()) {
            long end = System.currentTimeMillis();
            long time = (end - start);
            if (time > 1) {
                // String sql = getSql(configuration, boundSql, sqlId, time);
                logger.debug(sqlId + ":" + time + "ms");
            }
        }
        return returnValue;
    }


    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }

        }
        return value;
    }

    public static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));

            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    }
                }
            }
        }
        return sql;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

}
