package com.ssofficial.springsecurityclass.service;

import com.ssofficial.springsecurityclass.entity.User;
import com.ssofficial.springsecurityclass.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
