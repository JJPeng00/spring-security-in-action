package com.jjpeng.ssia.controller;

import com.jjpeng.ssia.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JJPeng
 * @date 2022/7/18 20:14
 */
@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    @GetMapping("/hello")
    public String getHello() {
        return "hello " + nameService.getName();
    }

    @PostMapping("/hello")
    public String postHello() {
        return "post hello";
    }

    @PostMapping("/ciao")
    public String ciao() {
        return "Post Ciao!";
    }
}
