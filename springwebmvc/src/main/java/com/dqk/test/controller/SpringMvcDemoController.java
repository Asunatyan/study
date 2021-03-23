package com.dqk.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * date: 2021/3/23 10:29
 *
 * @author dqk
 */

@Controller
@RequestMapping("test")
public class SpringMvcDemoController {

    @RequestMapping(value = "helloMvc", method = RequestMethod.GET)
    public String test() {
        return "index";
    }
}
