package com.mebatis.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class GPConfiguration {
	
	//为了简化配置文件采用properties形式     
    public static final ResourceBundle sqlMappings = ResourceBundle.getBundle("v1sql");

//    static{
//        sqlMappings = ResourceBundle.getBundle("v1sql");
//    }

    //jdk动态代理返回代理对象
    @SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> clazz, GPSqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new GPMapperProxy(sqlSession));
    }


}
