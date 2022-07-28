package com.jjpeng.ssia.model;

/**
 * @author JJPeng
 * @date 2022/7/28 20:32
 */
public class Document {

    private String owner;

    public Document(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
