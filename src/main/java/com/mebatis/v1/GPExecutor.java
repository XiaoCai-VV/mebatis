package com.mebatis.v1;


import java.sql.*;

import com.mebatis.v1.mapper.Blog;

//执行器  负责执行具体的sql
public class GPExecutor {
	
    @SuppressWarnings("unchecked")
	public <T> T query(String sql, Object paramater) {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8&useSSL=false&useInformationSchema=true&serverTimezone=Asia/Shanghai", "mybatis", "mybatis");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, paramater));
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) blog;
    }
}
