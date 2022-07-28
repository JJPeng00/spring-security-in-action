package com.jjpeng.ssia.evaluator;

import com.jjpeng.ssia.model.Document;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author JJPeng
 * @date 2022/7/28 21:10
 */
@Component
public class DocumentsPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        Document document = (Document) target;
        String p = (String) permission;

        //判断是否为管理员，即:ROLE_admin
        boolean isAdmin = authentication.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(p));

        return isAdmin || document.getOwner().equals(authentication.getName());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        //未使用到这种方式，不需要实现什么逻辑
        return false;
    }
}
