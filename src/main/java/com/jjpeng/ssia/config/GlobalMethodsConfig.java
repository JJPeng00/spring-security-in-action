package com.jjpeng.ssia.config;

import com.jjpeng.ssia.evaluator.DocumentsPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author JJPeng
 * @date 2022/7/28 21:19
 */
@Configuration
//允许pre/postauthorization
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalMethodsConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private DocumentsPermissionEvaluator documentsPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        //设置一个SpEL表达式处理器
        expressionHandler.setPermissionEvaluator(documentsPermissionEvaluator);
        return expressionHandler;
    }
}
