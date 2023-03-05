package miniproject.service;

import java.sql.SQLException;


import miniproject.model.User;

public interface UserInterface {
	void addUser(User user) throws SQLException;
	int updateUser(User user , int uid,String property) throws SQLException;
	public int deleteUser(int uid) throws SQLException;
	User findUserById(int uid) throws SQLException;
	void displayUserDetails() throws SQLException;
	
}
