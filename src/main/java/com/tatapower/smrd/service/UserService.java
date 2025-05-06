package com.tatapower.smrd.service;

import com.tatapower.smrd.dto.UserRequest;
import com.tatapower.smrd.entity.User;

public interface UserService {

    User saveUser(UserRequest user);
}
