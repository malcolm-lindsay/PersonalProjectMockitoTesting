package com.qa.persistence.repository;

public interface UserRepository {

	String getAllUsers();

	String addUser(String user);

	String updateUser(Long id, String User);

	String deleteUser(Long userID);

}