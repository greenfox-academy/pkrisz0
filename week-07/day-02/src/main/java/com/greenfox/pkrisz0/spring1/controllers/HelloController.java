package com.greenfox.pkrisz0.spring1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping(value="/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }
}
