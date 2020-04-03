package com.lawencon.parkiranboot.repo.jpa.userlogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiranboot.model.UserLogin;

@Repository
public class UserLoginJPAImpl implements UserLoginJPA {

	@Autowired
	private UserLoginRepo userRepo;

	@Override
	public List<UserLogin> findByUsernamePassword(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}

}
