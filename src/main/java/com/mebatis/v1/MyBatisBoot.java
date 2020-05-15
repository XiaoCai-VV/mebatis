package com.mebatis.v1;

import com.mebatis.v1.mapper.BlogMapper;

//测试类
public class MyBatisBoot {
    public static void main(String[] args) {
        GPSqlSession sqlSession = new GPSqlSession(new GPConfiguration(), new GPExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }
}
