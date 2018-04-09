package cskaoyan.service;


import cskaoyan.bean.User;

public interface UserService {


    public User findUserByNameAndWord(User user);

    public int addUser(User user);

    public int updateUser(User user);

    public boolean isUserNameValid(String username);
}
