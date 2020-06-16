package com.qf.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    //1. 读取配置文件 获取SQLSession对象
    //2. 事务的处理
    //3. SqlSession 释放
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> SQL_SESSION_THREAD_LOCAL=new ThreadLocal<>();

    static {

        try {
            InputStream  stream = Resources.getResourceAsStream("mybatis-config.xml");
            factory=new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession =  SQL_SESSION_THREAD_LOCAL.get();
        if(sqlSession == null){
            sqlSession = factory.openSession();
            SQL_SESSION_THREAD_LOCAL.set(sqlSession);
        }
        return sqlSession;
    }


    //释放资源的方法
    public static void close(){
        getSqlSession().close();
        SQL_SESSION_THREAD_LOCAL.remove();
    }

    public static void commit(){
        getSqlSession().commit();
        close();
    }

    public static void rollback(){
        getSqlSession().rollback();
        close();
    }

    public static  <T> T   getMapper(Class<T> t){
        return getSqlSession().getMapper(t);
    }

}
