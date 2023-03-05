package miniproject.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import miniproject.DatabaseConnection;
import miniproject.model.Admin;


public class AdminImpl implements AdminInterface {
	
	static Scanner sc=new Scanner(System.in);
     Connection connection=null;
	PreparedStatement pstatement=null;
	public AdminImpl()
	{
		connection=DatabaseConnection.getCustConnection();
	}
	

 //adding new user
public void addAdmin(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
		
		pstatement=connection.prepareStatement("insert into admin values(?,?,?,?,?)");
		pstatement.setInt(1, admin.getId());
		pstatement.setString(2, admin.getName());
		pstatement.setString(3, admin.getContact());
		pstatement.setString(4, admin.getEmail());
		pstatement.setString(5, admin.getPassword());
		//pstatement.setString(6, admin.getRole());
		
		int res=pstatement.executeUpdate();
		if(res==1)
		{
			System.out.println("Admin details inserted successfully");
		}
	}

//    get user method takes id as param
 //display user details
public void displayAdminDetails() throws SQLException {
	pstatement=connection.prepareStatement("select * from admin");
	ResultSet res1=pstatement.executeQuery();
        while (res1.next()) {
                int id=res1.getInt("aid");
            	String name=res1.getString("name");
                String contact=res1.getString("contact");
                String email=res1.getString("email");
                String password=res1.getString("password");
                //String role=res1.getString("role");
                Admin admin=new Admin(id,name,contact,email,password);
            	System.out.println(admin);
               }
}

//    updates the user password,name and returns userId
   // @Override
    public int updateAdmin(Admin admin, int aid,String property) throws SQLException {
    	Admin admin1=findAdminById(aid);
	if(property.equals("name"))
		admin1.setName(admin.getName());
	if(property.equals("password"))
		admin1.setPassword(admin.getPassword());
	
		pstatement=connection.prepareStatement("update admin set name=?,password=? where aid=? ");
		pstatement.setString(1,admin1.getName());
		pstatement.setString(2, admin1.getPassword());
		pstatement.setInt(3,aid);
		int r=pstatement.executeUpdate();
		return r;
	}
    public Admin findAdminById(int id) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from admin where aid=?");
		pstatement.setInt(1,id);
		ResultSet rs=pstatement.executeQuery();
		rs.next();
		Admin admin=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		return admin;
	}
    
	public int deleteAdmin(int aid) throws SQLException {

		pstatement=connection.prepareStatement("delete from admin where aid=?");
		pstatement.setInt(1,aid);
        int rs=pstatement.executeUpdate();	
		return 0;
	}
//method for password validation
	public  boolean isPasswordValid(String password) {
		 boolean pass = false;
	    // Password length must be between 8 and 20 characters
	    if (password.length() <= 8 || password.length() >= 10) {
	      pass=false; 
	    }else {
	    	pass=true; 
	    }
			return pass;
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