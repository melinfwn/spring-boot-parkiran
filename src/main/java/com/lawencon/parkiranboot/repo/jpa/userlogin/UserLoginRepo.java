package com.lawencon.parkiranboot.repo.jpa.userlogin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.parkiranboot.model.UserLogin;

public interface UserLoginRepo extends JpaRepository<UserLogin, Long> {

	List<UserLogin> findByUsernameAndPassword(String username, String password);
}
