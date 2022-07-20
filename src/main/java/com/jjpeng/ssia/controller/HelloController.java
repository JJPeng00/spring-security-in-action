package com.jjpeng.ssia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JJPeng
 * @date 2022/7/18 20:14
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "get hello!";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "post hello";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }

    //默认可以直接访问此端点
    @GetMapping("/hola")
    public String hola() {
        return "Hola!";
    }


}
