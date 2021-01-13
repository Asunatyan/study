package com.dqk.oauth2.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
/*
RBAC(Role-Based Access Control),也就是所谓的**“基于角色的访问控制权限”**
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
/*org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint.authorize*/
    /*http://localhost:8080/oauth/authorize?client_id=client&response_type=code*/

    //连接数据源
    @Bean
    @Primary//覆盖掉spring的默认配置数据源
    @ConfigurationProperties(prefix = "spring.datasource")//指定配置
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    //从数据库存入token
    @Bean
    public TokenStore tokenStore(){
        /*org.springframework.security.oauth2.provider.token.store.JdbcTokenStore.storeAccessToken*/
        return new JdbcTokenStore(dataSource());

    }

    //客户端信息
    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource());
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //客户端配置
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /* auth.inMemoryAuthentication()
                //创建两个用户
                //.withUser("admin").password("123456").roles("ADMIN")
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("test").password(passwordEncoder().encode("123456")).roles("TEST");*/
        clients.withClientDetails(jdbcClientDetailsService());
    }

    //token配置
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());
    }
}
