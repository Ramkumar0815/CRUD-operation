package org.jsp.usermvcapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository

public class UserDao {

	@Autowired
	private EntityManager manager;

	public User saveUser(User users)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(users);
		transaction.begin();
		transaction.commit();
		return users;
	}
	
	public User updateUser(User users)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(users);
		transaction.begin();
		transaction.commit();
		return users;
	}
	
	public User fetchByid(int id)
	{
		return manager.find(User.class, id);
	}
	public boolean deleteUser(int id)
	{
		User u=manager.find(User.class,id);
		if(u!=null)
		{
			EntityTransaction t=manager.getTransaction();
			manager.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
	
}