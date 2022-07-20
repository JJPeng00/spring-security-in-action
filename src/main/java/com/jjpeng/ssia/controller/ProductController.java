package com.jjpeng.ssia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @author JJPeng
 * @date 2022/7/18 23:49
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger =  Logger.getLogger(ProductController.class.getName());

    @PostMapping("/add")
    public String add(@RequestParam String name) {
        logger.info("Adding product " + name);
        return "main.html";
    }
}
