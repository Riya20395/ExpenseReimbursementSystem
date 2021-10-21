package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.User;

public interface UserDao {

	void createUser(User u) throws SQLException;

	void updateUser(User u);

	void deleteUser(User u);

	List<User> getAllUsers();

	User getUserByuserName(String userName);
}
