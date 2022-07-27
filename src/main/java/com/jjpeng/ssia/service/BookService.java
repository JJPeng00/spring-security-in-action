package com.jjpeng.ssia.service;

import com.jjpeng.ssia.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author JJPeng
 * @date 2022/7/27 23:12
 */
@Service
public class BookService {

    private Map<String, Employee> map = Map.of(
            "emma", new Employee("Emma Thompson",List.of("Karamazov Brothers"), List.of("accountant", "reader")),
            "natalie", new Employee("Natalie Parker", List.of("Beautiful Paris"), List.of("researcher")));

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name) {
        return map.get(name);
    }

}
