/**
 * 
 */
package edu.prabin.demo.repository;

import java.util.List;

import edu.prabin.demo.domain.User;

/**
 * @author prabinadhikari
 *
 */
public interface UserRepository {
	public void save(User user);

	public List<User> getUsers();

	public void update(User id);

	public void delete(Integer user);

	public User getUser(Integer id);
}
