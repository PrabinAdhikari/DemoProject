package edu.prabin.demo.service;

import java.util.List;

import edu.prabin.demo.domain.User;

/**
 * @author prabinadhikari
 *
 */
public interface UserService {
	public void save(User user);

	public List<User> getUsers();

	public void update(User user);

	public void delete(Integer userId);

	public User getUser(Integer id);
}
