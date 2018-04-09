package cskaoyan.dao;


import cskaoyan.bean.User;

public interface UserMapper {


    public User findUserByNameAndWord(User user);

    public int addUser(User user);

    public int updateUser(User user);

    public User isUserNameValid(String username);
}
