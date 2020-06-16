package com.qf.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.util.MyBatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {
    @Test
    public void test_selectAll(){
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        System.out.println(userMapper.findAll());
    }
    @Test
    public void test_findUserByName(){
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        System.out.println(userMapper.findUserByName("lisi"));
    }
    @Test
    public void test_updateUser(){
        User user=new User();
        user.setId(4);
        user.setUsername("虫虫123");
        user.setMail("12344@qq.com");
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        userMapper.updateUser(user);
        MyBatisUtils.commit();
    }
    @Test
    public void test_findAllUserByid(){
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllUserById(list);
        System.out.println(userList);
    }
    @Test
    public void test_findAllUserByidArray(){
        Integer[] array={2,3,4};
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllUserByIdArray(array);
        System.out.println(userList);
    }
    @Test
    public void test_pageHelper(){
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        PageHelper.startPage(1,2);
        List<User> userList=userMapper.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        System.out.println(pageInfo);
    }
    @Test
    public void test_lazyLoad(){
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        //List<User> list = userMapper.findAll();
        int size = userMapper.findAll().size();
    }

}
