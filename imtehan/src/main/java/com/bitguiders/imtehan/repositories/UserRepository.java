package com.bitguiders.imtehan.repositories;

import java.util.List;

import com.bitguiders.imtehan.model.User;

public interface UserRepository {

	public List<User> getAllUsers();
	public User getUserById(String id);
	public User getUserById(String id,String password);
}
