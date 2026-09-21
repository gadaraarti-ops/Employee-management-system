package com.yessinfotech.service;

import com.yessinfotech.entity.User;

public interface UserService {

    User registerUser(User user);

    User login(String username, String password);

}