package com.forezp.servicefeign.clients;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//name和value是一样的意思
//url的优先级大于value
@FeignClient(value = "service-hi"/*,url = "http://localhost:8762"*/ /*,fallbackFactory = HystrixClientFallbackFactory.class*/)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);


/*    @Component
    public static class HystrixClientFallbackFactory implements FallbackFactory<HystrixClient> {
        @Override
        public HystrixClient create(Throwable cause) {
            return new HystrixClient() {
                @Override
                public Hello iFailSometimes() {
                    return new Hello("fallback; reason was: " + cause.getMessage());
                }
            };
        }
    }*/

}

