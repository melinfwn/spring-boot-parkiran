package com.lawencon.parkiranboot.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.parkiranboot.model.UserLogin;
import com.lawencon.parkiranboot.repo.hibernate.BaseHibernate;
import com.lawencon.parkiranboot.repo.hibernate.userlogin.UserHibernateImpl;

@Service
@Transactional
public class UserServiceImpl extends BaseHibernate implements UserService {
	
	@Autowired
	@Qualifier("user_repo_hibernate")
	private UserHibernateImpl userService;

	@Override
	public List<UserLogin> findByUsernamePassword(String username, String password) {
		return userService.findByUsernamePassword(username, password);
	}

}
