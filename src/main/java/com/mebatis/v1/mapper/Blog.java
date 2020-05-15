package com.mebatis.v1.mapper;

import java.io.Serializable;

//表对应的实体对象
public class Blog implements Serializable{
	
	private static final long serialVersionUID = 4382321230395711680L;
	
	private Integer bid; // 主键
	private String name; // 文章标题
	private Integer authorId; // 文章作者ID

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
