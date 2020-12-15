package com.github.laba.ioc.frame.controller;

import com.github.laba.ioc.core.annotation.Controller;

@Controller
public class TestAopController {
    public int say(){
        System.out.println("我是controller的本地方法");
        return 1/0;
    }


}