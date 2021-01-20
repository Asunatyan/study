package com.dqk.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("apicenterDbInfo")
@ConfigurationProperties(prefix="spring.datasource")
public class ApicenterDbInfo {
    /** 逻辑删除的数据库名称*/
    private String deleteDatabaseName;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeleteDatabaseName() {
        return deleteDatabaseName;
    }

    public void setDeleteDatabaseName(String deleteDatabaseName) {
        this.deleteDatabaseName = deleteDatabaseName;
    }
}
