package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.MyBatisUtils;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public PageInfo getPageInfo(Integer pageNum, Integer pageSize) {
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList=userMapper.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }
}
