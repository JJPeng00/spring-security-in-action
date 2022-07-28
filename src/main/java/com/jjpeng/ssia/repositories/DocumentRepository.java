package com.jjpeng.ssia.repositories;

import com.jjpeng.ssia.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author JJPeng
 * @date 2022/7/28 20:33
 */
@Repository
public class DocumentRepository {

    //使用map来模拟数据库
    private Map<String, Document> documents =
            Map.of("abc123", new Document("natalie"),
                    "qwe123", new Document("natalie"),
                    "asd555", new Document("emma"));

    public Document findDocument(String code) {
        return documents.get(code);
    }
}
