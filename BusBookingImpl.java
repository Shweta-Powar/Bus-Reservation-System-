package miniproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import miniproject.DatabaseConnection;
import miniproject.model.BusBooking;

public class BusBookingImpl implements BusBookingInterface{

	Connection connection=null;
	PreparedStatement pstatement=null;
	public BusBookingImpl()
	{
		connection=DatabaseConnection.getCustConnection();
	}
	
 //adding new Booking
public void addBooking(BusBooking book) throws SQLException {
		// TODO Auto-generated method stub
		
		pstatement=connection.prepareStatement("insert into booking values(?,?,?,?,?,?)");
		pstatement.setInt(1, book.getBid());
		pstatement.setInt(2,book.getSeatNo());
		pstatement.setInt(3,book.getBseats());
		pstatement.setString(4, book.getDesc());
		pstatement.setString(5, book.getPstatus());
		pstatement.setString(6, book.getBdate());
		
		int res=pstatement.executeUpdate();
		if(res==1)
		{
			System.out.println("Booking details inserted successfully");
		}
	}

 //display booking details
public void displayBookingDetails() throws SQLException {
	pstatement=connection.prepareStatement("select * from booking");
	ResultSet res1=pstatement.executeQuery();
        while (res1.next()) {
                int bid=res1.getInt("bid");
            	int seatNo=res1.getInt("seatNo");
            	int bseats=res1.getInt("bookedSeats");
                String desc=res1.getString("details");
                String pstatus=res1.getString("PayStatus");
                String bdate=res1.getString("bdate");
                BusBooking book=new BusBooking(bid,seatNo,bseats, desc,pstatus,bdate);
            	System.out.println(book);
               }
}

//    updates the description ,booking date and returns bookingId
   
    public int updateBooking(BusBooking book, int bid,String property) throws SQLException {
    	BusBooking book1=findBookingByBid(bid);
	if(property.equals("details"))
		book1.setDesc(book.getDesc());
	if(property.equals("bdate"))
		book1.setBdate(book.getBdate());
	
		pstatement=connection.prepareStatement("update booking set details=?,bdate=? where bid=? ");
		pstatement.setString(1,book1.getDesc());
		pstatement.setString(2, book1.getBdate());
		pstatement.setInt(3,bid);
		int r=pstatement.executeUpdate();
		return r;
	}
    public BusBooking findBookingByBid(int bid) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from booking where bid=?");
		pstatement.setInt(1,bid);
		ResultSet rs=pstatement.executeQuery();
		rs.next();
		BusBooking book=new BusBooking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
		return book;
		}
    
    public void findBookingByStatus(String status) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from booking where paystatus=?");
		pstatement.setString(1,status);
		ResultSet rs1=pstatement.executeQuery();
		while(rs1.next())
			{
		BusBooking	book=new BusBooking(rs1.getInt(1),rs1.getInt(2),rs1.getInt(3),rs1.getString(4),rs1.getString(5),rs1.getString(6));
		System.out.println(book);	
		}
}
    public void findTicketByBid(int bid) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from booking where bid=?");
		pstatement.setInt(1,bid);
		ResultSet rs=pstatement.executeQuery();
		while(rs.next()) {
		BusBooking book=new BusBooking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
		System.out.println(book);
		}
    }
//	delete the booking using booking id 
	public int deleteBooking(int bid) throws SQLException {
		pstatement=connection.prepareStatement("delete from booking where bid=?");
		pstatement.setInt(1,bid);
		int rs2=pstatement.executeUpdate();	
		return 0;
	}
}