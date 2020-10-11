package com.xjl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:xjl
 * @date:2020/6/2 17:50
 */
@Controller
@RequestMapping(value = "/xjl")
public class MainController {
    /**
     * 公司简介 相关页面
     *
     * @return
     */
    @RequestMapping(value = "/About")
    public String About() {
        return "About";
    }

    /**
     * 疫情防控相关页面
     *
     * @return
     */
    @RequestMapping("/coronavirus")
    public String con() {
        return "coronavirus";
    }

}