package com.qa.service.business;

public interface UserService {

	String getAllUsers();

	String addUser(String user);

	String updateUser(Long userID, String user);

	String deleteUser(Long userID);

}