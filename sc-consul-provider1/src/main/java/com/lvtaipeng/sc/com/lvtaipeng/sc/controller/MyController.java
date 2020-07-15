package com.lvtaipeng.sc.com.lvtaipeng.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("test")
    public String tes(){
        return " 测试一";
    }
}
