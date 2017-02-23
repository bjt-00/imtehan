package com.bitguiders.imtehan.service;

import java.util.List;

import com.bitguiders.imtehan.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(String id);
	public User getUserById(String id,String password);
	public boolean isValid(User user);
}
