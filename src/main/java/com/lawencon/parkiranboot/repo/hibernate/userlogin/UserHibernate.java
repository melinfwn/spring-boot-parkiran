package com.lawencon.parkiranboot.repo.hibernate.userlogin;

import java.util.List;

import com.lawencon.parkiranboot.model.UserLogin;

public interface UserHibernate {

	abstract List<UserLogin> findByUsernamePassword(String username, String password);
}
