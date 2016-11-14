/**
 * 
 */
package edu.prabin.demo.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.prabin.demo.domain.User;

/**
 * @author prabinadhikari
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	@Inject
	SessionFactory sessionFactory;

	/**
	 * 
	 */
	public UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(User user) {
		Session session = getSession();
		session.save(user);
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = getSession();
		List<User> users = session.createQuery("from SampleTable").list();
		session.close();
		return users;

	}

	@Override
	public void update(User user) {
		Session session = getSession();
		session.update(user);
		session.flush();
		session.clear();
	}

	@Override
	public void delete(Integer userId) {
		Session session = getSession();
		User user = (User) session.get(User.class, userId);
		if (user != null) {
			session.delete(user);
			session.flush();
		}
		session.clear();
	}

	@Override
	public User getUser(Integer userId) {
		Session session = getSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
