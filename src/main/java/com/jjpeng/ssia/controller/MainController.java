package com.jjpeng.ssia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author JJPeng
 * @date 2022/7/20 23:10
 */
@Controller
public class MainController {

    @GetMapping("main")
    public String main() {
        return "main.html";
    }
}
