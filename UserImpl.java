package miniproject.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import miniproject.DatabaseConnection;

import miniproject.model.User;

public class UserImpl implements UserInterface {
	
	static Scanner sc=new Scanner(System.in);
     Connection connection=null;
	PreparedStatement pstatement=null;
	public UserImpl()
	{
		connection=DatabaseConnection.getCustConnection();
	}
	

 //adding new user
public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		
		pstatement=connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
		pstatement.setInt(1, user.getId());
		pstatement.setString(2, user.getName());
		pstatement.setString(3, user.getContact());
		pstatement.setString(4, user.getEmail());
		pstatement.setString(5, user.getPassword());
		pstatement.setString(6, user.getRole());
		
		int res=pstatement.executeUpdate();
		if(res==1)
		{
			System.out.println("User details inserted successfully");
		}
	}

//    get user method takes id as param
 //display user details
public void displayUserDetails() throws SQLException {
	pstatement=connection.prepareStatement("select * from users");
	ResultSet res1=pstatement.executeQuery();
        while (res1.next()) {
                int id=res1.getInt("uid");
            	String name=res1.getString("name");
                String contact=res1.getString("contact");
                String email=res1.getString("emailId");
                String password=res1.getString("password");
                String role=res1.getString("role");
            	User user=new User(id,name,contact,email,password,role);
            	System.out.println(user);
               }
}

//    updates the user password,name and returns userId
   // @Override
    public int updateUser(User user, int uid,String property) throws SQLException {
		User user1=findUserById(uid);
	if(property.equals("name"))
		user1.setName(user.getName());
	if(property.equals("password"))
		user1.setPassword(user.getPassword());
	
		pstatement=connection.prepareStatement("update users set name=?,password=? where uid=? ");
		pstatement.setString(1,user1.getName());
		pstatement.setString(2, user1.getPassword());
		pstatement.setInt(3,uid);
		int r=pstatement.executeUpdate();
		return r;
	}
    public User findUserById(int id) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from users where uid=?");
		pstatement.setInt(1,id);
		ResultSet rs=pstatement.executeQuery();
		rs.next();
		User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
		return user;
	}
    
	public int deleteUser(int uid) throws SQLException {

		pstatement=connection.prepareStatement("delete from users where uid=?");
		pstatement.setInt(1,uid);
		int rs=pstatement.executeUpdate();	
		return rs;
	
		
	}

}