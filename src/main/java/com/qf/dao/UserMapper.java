package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询所有User
    List<User> findAll();

    //根据名字查询User
    User findUserByName(@Param("userName") String userName);

    //更新信息
    void updateUser(User user);

    //根据id查询多个
    List<User> findAllUserById(List<Integer> idList);

    //根据id查询多个
    List<User> findAllUserByIdArray(Integer[] idArray);

}
