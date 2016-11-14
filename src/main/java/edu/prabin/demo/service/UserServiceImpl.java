/**
 * 
 */
package edu.prabin.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.prabin.demo.domain.User;
import edu.prabin.demo.repository.UserRepository;

/**
 * @author prabinadhikari
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Inject
	UserRepository userRepository;

	/**
	 * 
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public void delete(Integer userId) {
		userRepository.delete(userId);
	}

	@Override
	public User getUser(Integer id) {
		return userRepository.getUser(id);
	}

}
