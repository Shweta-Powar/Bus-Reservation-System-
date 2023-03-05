package miniproject.service;

import java.sql.SQLException;

import miniproject.model.Bus;


public interface BusInterface {
	void addBus(Bus bus) throws SQLException;
	int updateBus(Bus bus, int id,String property) throws SQLException;
	int deleteBus(int id) throws SQLException;
	Bus findBusById(int id) throws SQLException;
	void displayBusDetails() throws SQLException;
	
}
