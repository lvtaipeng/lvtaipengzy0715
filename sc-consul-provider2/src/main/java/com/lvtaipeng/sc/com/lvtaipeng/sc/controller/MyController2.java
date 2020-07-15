package com.lvtaipeng.sc.com.lvtaipeng.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController2 {
    @RequestMapping("test")
    public String tes2(){
        return "测试二";
    }
}
