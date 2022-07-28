package com.jjpeng.ssia.controller;

import com.jjpeng.ssia.model.Document;
import com.jjpeng.ssia.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JJPeng
 * @date 2022/7/28 21:24
 */
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents/{code}")
    public Document getDetails(@PathVariable String code) {
        return documentService.getDocument(code);
    }
}
