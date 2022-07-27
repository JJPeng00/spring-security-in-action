package com.jjpeng.ssia.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author JJPeng
 * @date 2022/7/27 22:37
 */
@Service
public class NameService {

    Map<String, List<String>> map = Map.of(
            "natalie", List.of("Energico", "Perfecto"),
            "emma", List.of("Fantastico")
    );

    //方法的参数必须等于当前认证用户的用户名才能调用此方法
    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretNames(String name) {
        return map.get(name);
    }

    //拥有写权限的用户才能调用此方法
    @PreAuthorize("hasAuthority('write')")
    public String getName() {
        return "Fantastico";
    }
}
