package miniproject.service;

import java.sql.SQLException;

import miniproject.model.BusBooking;

public interface BusBookingInterface {
	void addBooking(BusBooking book) throws SQLException;
	int updateBooking(BusBooking book , int bid,String property) throws SQLException;
	int deleteBooking(int bid) throws SQLException;
	BusBooking findBookingByBid(int bid) throws SQLException;
	void displayBookingDetails() throws SQLException;
	void findBookingByStatus(String status) throws SQLException;
	public void findTicketByBid(int bid) throws SQLException;
}
