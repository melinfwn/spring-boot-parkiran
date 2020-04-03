package com.lawencon.parkiranboot.repo.hibernate.userlogin;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.parkiranboot.model.UserLogin;
import com.lawencon.parkiranboot.repo.hibernate.BaseHibernate;

@Repository("user_repo_hibernate")
public class UserHibernateImpl extends BaseHibernate implements UserHibernate {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLogin> findByUsernamePassword(String username, String password) {
		Query q = em.createQuery(" from UserLogin where username = :idParam and password = :idParam2");
		q.setParameter("idParam", username);
		q.setParameter("idParam2", password);
		return q.getResultList();
	}

}
