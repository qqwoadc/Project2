package com.cskaoyan.service.impl;


import com.cskaoyan.bean.User;
import com.cskaoyan.dao.UserMapper;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("service")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper dao;

    @Override
    public User findUserByNameAndWord(User user) {


        User userByNameAndWord = dao.findUserByNameAndWord(user);
        return userByNameAndWord;
    }

    @Override
    public int addUser(User user) {

        int i = dao.addUser(user);

        return i;
    }

    @Override
    public int updateUser(User user) {

        int i = dao.updateUser(user);
        return i;
    }

    @Override
    public boolean isUserNameValid(String username) {

        User userNameValid = dao.isUserNameValid(username);

//        if user = null,return true,you can use this username
        return userNameValid==null;
    }
}
