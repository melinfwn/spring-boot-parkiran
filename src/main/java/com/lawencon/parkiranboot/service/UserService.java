package com.lawencon.parkiranboot.service;

import java.util.List;

import com.lawencon.parkiranboot.model.UserLogin;

public interface UserService {

	abstract List<UserLogin> findByUsernamePassword(String username, String password);
}
