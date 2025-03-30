package com.zyu.expulsion.submit.form.service;


import com.zyu.expulsion.submit.form.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    public List<User> findAllUsers();

    public User getUser(String userName);

    public void saveUser(User user) throws SQLException;

    public void updateUser(User user);

    public void deleteUser(String userName);
}

