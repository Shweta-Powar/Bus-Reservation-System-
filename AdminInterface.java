package miniproject.service;

import java.sql.SQLException;

import miniproject.model.Admin;


public interface AdminInterface {
	void addAdmin(Admin admin) throws SQLException;
	int updateAdmin(Admin admin , int aid,String property) throws SQLException;
	int deleteAdmin(int aid) throws SQLException;
	Admin findAdminById(int aid) throws SQLException;
	void displayAdminDetails() throws SQLException;
	String emailValidation(String email);
	String phoneNoValidation(String contact);
	public  boolean isPasswordValid(String password)	;
		
}

