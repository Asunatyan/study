package com.dqk.test.mybatis;

import com.dqk.test.generator.BaseDto;

import java.math.BigInteger;
import java.util.Map;
import java.util.Properties;

public class MybatisInterceptor extends AbstractCommMybatisInterceptor {
    protected Properties properties;// 注意不要使用private

    @Override
    public void setProperties(Properties properties0) {
        this.properties = properties0;
    }

    public BigInteger getOperId(){
        return BigInteger.ZERO;
    }

    @Override
    public void doMap(Map tmp, String sqlStrUpperCaseTrim) {
        if (sqlStrUpperCaseTrim.startsWith("INSERT") && tmp.containsKey(BaseDto.sys0AddUser)) {
            if (tmp.get(BaseDto.sys0AddUser) == null) {
                tmp.put(BaseDto.sys0AddUser, getOperId());// 新增
            }
        } else if (sqlStrUpperCaseTrim.startsWith("UPDATE")) {
            if (tmp.containsKey(BaseDto.sys0DelState) && BaseDto.DeleteMark.yishanchu.compareTo((Integer) tmp.get(BaseDto.sys0DelState)) == 0 && tmp.containsKey(BaseDto.sys0DelUser)) {
                if (tmp.get(BaseDto.sys0DelUser) == null) {
                    tmp.put(BaseDto.sys0DelUser, getOperId());// 删除
                }
            } else if (tmp.containsKey(BaseDto.sys0UpdUser)) {
                if (tmp.get(BaseDto.sys0UpdUser) == null) {
                    tmp.put(BaseDto.sys0UpdUser, getOperId());// 更新
                }
            }
        }
    }

    @Override
    public void doBaseDto(BaseDto tmp, String sqlStrUpperCaseTrim) {
        if (sqlStrUpperCaseTrim.startsWith("INSERT")) {
            if (tmp.getS0AddUsr() == null) {
                tmp.setS0AddUsr(getOperId());// 新增
            }
        } else if (sqlStrUpperCaseTrim.startsWith("UPDATE")) {
            if (tmp.getS0DelMark() != null && BaseDto.DeleteMark.yishanchu.compareTo(tmp.getS0DelMark()) == 0) {
                if (tmp.getS0DelUsr() == null) {
                    tmp.setS0DelUsr(getOperId());// 删除
                }
            } else if (tmp.getS0UpdUsr() == null) {
                tmp.setS0UpdUsr(getOperId());// 更新
            }
        }
    }

}
