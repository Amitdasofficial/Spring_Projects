package org.jsp.usermvcdemo.dao;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.jsp.usermvcdemo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private EntityManager manager;
	
	public User saveUser(User user)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}
	
	
	public User updateUser(User user)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(user);
		transaction.begin();
		transaction.commit();
		return user;
	}
	
	
	public boolean deleteById(int id)
	{
		User user=findUserById(id);
		EntityTransaction transaction=manager.getTransaction();
		if(user!=null)
		{
			manager.remove(user);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
	
	public User findUserById(int id) {
		return manager.find(User.class, id);
	}
	
	public User verifyUser(int id, String password)
	{
		Query q=manager.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public User verifyUser(String email, String password)
	{
		Query q=manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public User verifyUser(long phone, String password)
	{
		Query q=manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
