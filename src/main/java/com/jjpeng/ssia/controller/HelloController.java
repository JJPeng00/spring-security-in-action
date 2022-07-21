package com.jjpeng.ssia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JJPeng
 * @date 2022/7/18 20:14
 */
@RestController
public class HelloController {

    @PostMapping("/hello")
    public String postHello() {
        return "post hello";
    }

    @PostMapping("/ciao")
    public String ciao() {
        return "Post Ciao!";
    }
}
