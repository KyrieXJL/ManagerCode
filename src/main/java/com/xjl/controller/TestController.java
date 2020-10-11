package com.xjl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xjl
 * @date 2020/6/2
 *
 * */
@Controller
public class TestController {
    @RequestMapping(value = "/test",  method = RequestMethod.GET)
    public String index(){
        System.out.println("This is TestController!!!");
        return "main";
    }
}
