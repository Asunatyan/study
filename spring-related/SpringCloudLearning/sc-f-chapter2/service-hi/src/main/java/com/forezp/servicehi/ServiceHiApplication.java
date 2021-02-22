package com.forezp.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*
@EnableEurekaClient
@EnableDiscoveryClient 两者的区别
早期
EnableEurekaClient包含@EnableDiscoveryClient注解,两者没有区别
后期
EnableEurekaClient没有包含@EnableDiscoveryClient注解 @EnableEurekaClient没有任何用处
我对以上内容的理解：
1. EnableDiscoveryClient注解现在是可选项了(你用不用这个注解，是不会影响服务注册发现功能的)；
2. 只要依赖了以spring-cloud-starter-netflix为前缀的库(例如spring-cloud-starter-netflix-eureka-client)，就启用了服务注册发现功能；
3. 使用配置项spring.cloud.service-registry.auto-registration.enabled=false即可禁止服务注册发现功能；
从官方博客上看来EnableDiscoveryClient注解已经不会影响服务注册发现功能了；


https://blog.csdn.net/boling_cavalry/article/details/82668480
*/
//@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceHiApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
    
}



