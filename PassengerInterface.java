package miniproject.service;

import java.sql.SQLException;

import miniproject.model.Passenger;


public interface PassengerInterface {
	void addPassenger(Passenger passenger) throws SQLException;
	int updatePassenger(Passenger passenger , int pid,String property) throws SQLException;
	int deletePassenger(int pid) throws SQLException;
	Passenger findPassengerById(int pid) throws SQLException;
	void displayPassengerDetails() throws SQLException;
	String phoneNoValidation(String contact);
public String emailValidation(String email);
void findDetailsById(int pid) throws SQLException;		
		
}

