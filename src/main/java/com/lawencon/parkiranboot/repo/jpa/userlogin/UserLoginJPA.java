package com.lawencon.parkiranboot.repo.jpa.userlogin;

import java.util.List;

import com.lawencon.parkiranboot.model.UserLogin;

public interface UserLoginJPA {

	abstract List<UserLogin> findByUsernamePassword(String username, String password);
}
