package com.jjpeng.ssia.service;

import com.jjpeng.ssia.model.Document;
import com.jjpeng.ssia.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author JJPeng
 * @date 2022/7/28 21:01
 */
@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    //在获取到对象后再验证授权
    @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    public Document getDocument(String code) {
        return documentRepository.findDocument(code);
    }
}
