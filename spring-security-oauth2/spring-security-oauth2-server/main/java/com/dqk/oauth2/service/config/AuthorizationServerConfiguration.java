package com.dqk.oauth2.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()//客户端信息放入内存
                .withClient("client")//clientId
                //.secret("secret")//secret
                .secret(bCryptPasswordEncoder.encode("secret"))//secret
                .authorizedGrantTypes("authorization_code")//授权类型(4种的一种
                .scopes("app")//授权的范围,就是能获取到的权限
                .redirectUris("http://www.baidu.com");//授权码发送的回调地址
    }
}
