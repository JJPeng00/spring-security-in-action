package com.jjpeng.ssia.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author JJPeng
 * @date 2022/7/27 22:37
 */
@Service
public class NameService {

    //拥有写权限的用户才能调用此方法
    @PreAuthorize("hasAuthority('write')")
    public String getName() {
        return "Fantastico";
    }
}
