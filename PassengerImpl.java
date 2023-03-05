package miniproject.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import miniproject.DatabaseConnection;
import miniproject.model.Passenger;


public class PassengerImpl implements PassengerInterface {
	
	static Scanner sc=new Scanner(System.in);
     Connection connection=null;
	PreparedStatement pstatement=null;
	public PassengerImpl()
	{
		connection=DatabaseConnection.getCustConnection();
	}
		
 //adding new pass
public void addPassenger(Passenger passenger) throws SQLException {
		// TODO Auto-generated method stub
		
		pstatement=connection.prepareStatement("insert into passenger values(?,?,?,?,?)");
		pstatement.setInt(1, passenger.getId());
		pstatement.setString(2, passenger.getName());
		pstatement.setString(3, passenger.getContact());
		pstatement.setString(4, passenger.getEmail());
		pstatement.setString(5, passenger.getPassword());
		int res=pstatement.executeUpdate();
		if(res==1)
		{
			System.out.println("Passenger details inserted successfully");
		}
	}

//    get user method takes id as param
 //display user details
public void displayPassengerDetails() throws SQLException {
	pstatement=connection.prepareStatement("select * from passenger");
	ResultSet res1=pstatement.executeQuery();
        while (res1.next()) {
                int id=res1.getInt("pid");
            	String name=res1.getString("name");
                String contact=res1.getString("contact");
                String email=res1.getString("emailId");
                String password=res1.getString("password");
                
                Passenger passenger=new Passenger(id,name,contact,email,password);
            	System.out.println(passenger);
               }
}

//    updates the user password,name and returns userId
   // @Override
    public int updatePassenger(Passenger passenger, int pid,String property) throws SQLException {
    	Passenger pass1=findPassengerById(pid);
	if(property.equals("name"))
		pass1.setName(passenger.getName());
	if(property.equals("password"))
		pass1.setPassword(passenger.getPassword());
	
		pstatement=connection.prepareStatement("update passenger set name=?,password=? where pid=? ");
		pstatement.setString(1,pass1.getName());
		pstatement.setString(2, pass1.getPassword());
		pstatement.setInt(3,pid);
		int r=pstatement.executeUpdate();
		return r;
	}
    public Passenger findPassengerById(int pid) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from passenger where pid=?");
		pstatement.setInt(1,pid);
		ResultSet rs=pstatement.executeQuery();
		rs.next();
		Passenger passenger=new Passenger(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		return passenger;
	}
    
	public int deletePassenger(int pid) throws SQLException {

		pstatement=connection.prepareStatement("delete from passenger where pid=?");
		pstatement.setInt(1,pid);
		int rs=pstatement.executeUpdate();	
		return 0;
	
	}
	 public void findDetailsById(int pid) throws SQLException {
			// TODO Auto-generated method stub
			pstatement=connection.prepareStatement("select *from passenger where pid=?");
			pstatement.setInt(1,pid);
			ResultSet rs=pstatement.executeQuery();
			rs.next();
			Passenger passenger=new Passenger(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		System.out.println(passenger); 
		}
	    
	//method for email validation
		public  String emailValidation(String str) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		boolean result;
		if (str == null) {
		result = false;
		} else {
		result = pattern.matcher(str).matches();
		}
		if (result == true) {
		return str;
		} else
		return "Invalid";
		}
		//method for phone number validation
		public  String phoneNoValidation(String str) {
		String regex ="(0/9)?[6-9][0-9]{9}";
		Pattern pattern = Pattern.compile(regex);
		boolean result;
		if (str == null) {
		result = false;
		} else {
		result = pattern.matcher(str).matches();
		}
		if (result == true) {
		return str;
		} else
		return "Invalid";
		}
		
		
	
}