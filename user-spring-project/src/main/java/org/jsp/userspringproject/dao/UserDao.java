package org.jsp.userspringproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.jsp.userspringproject.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;

@Repository
public class UserDao {
	@Autowired
	public EntityManager manager;

	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}

	public User updateUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(user);
		transaction.begin();
		transaction.commit();
		return user;
	}

	public User findById(int id) {
		return manager.find(User.class, id);
	}

	public boolean deleteById(int id) {
		User u = findById(id);
		if (u != null) {
			EntityTransaction transaction = manager.getTransaction();
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

	public User verifyUser(int id, String password)
	{
		String jpql = "slect u from User u where u.id=?1 and u.password=?2";
		javax.persistence.Query q = manager.createQuery(jpql);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(long phone, String password) {
		String jpql = "slect u from User u where u.phone=?1 and u.password=?2";
		javax.persistence.Query q = manager.createQuery(jpql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
	public User verifyUser(String email, String password) {
		String jpql = "slect u from User u where u.email=?1 and u.password=?2";
		javax.persistence.Query q = manager.createQuery(jpql);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
	
}
