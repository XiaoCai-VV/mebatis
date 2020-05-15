package com.mebatis.v1;

//对外的api
public class GPSqlSession {
    private GPConfiguration configuration;

    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor){
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object paramater){
        // 根据statementId拿到SQL
        String sql = GPConfiguration.sqlMappings.getString(statementId);
        if(null != sql && !"".equals(sql)){
            return executor.query(sql, paramater );
        }
        return null;
    }

    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz, this);
    }

}
