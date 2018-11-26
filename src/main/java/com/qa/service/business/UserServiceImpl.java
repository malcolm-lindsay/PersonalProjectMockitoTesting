package com.qa.service.business;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.UserDBRepository;

public class UserServiceImpl implements UserService {
	
	@Inject
	UserDBRepository repo;

	@Override
	public String getAllUsers() {
		return repo.getAllUsers();
	}

	@Override
	public String addUser(String user) {
		return repo.addUser(user);
	}
	
	@Override
	public String updateUser(Long userID, String user) {
		return repo.updateUser(userID, user);
	}

	@Override
	public String deleteUser(Long userID) {
		return repo.deleteUser(userID);		
	}
}
