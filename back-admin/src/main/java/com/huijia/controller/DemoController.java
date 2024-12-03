package com.huijia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huijia
 * @date 2024/12/2 18:38
 */
@RestController()
@RequestMapping("/test")
public class DemoController {



    @GetMapping("/hello")
    public String test() {

        return "hello world,";
    }
}
