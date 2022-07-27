package com.jjpeng.ssia.controller;

import com.jjpeng.ssia.model.Employee;
import com.jjpeng.ssia.service.BookService;
import com.jjpeng.ssia.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JJPeng
 * @date 2022/7/18 20:14
 */
@RestController
public class HelloController {

    @Autowired
    private NameService nameService;
    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String getHello() {
        return "hello " + nameService.getName();
    }

    @GetMapping("/secret/names/{name}")
    public List<String> names(@PathVariable String name) {
        return nameService.getSecretNames(name);
    }

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name) {
        return bookService.getBookDetails(name);
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
