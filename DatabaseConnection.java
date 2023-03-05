package miniproject;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
public static Connection getCustConnection()
{
	
	
	Connection connection=null;
	try {
		FileReader freader = new FileReader("database.properties");
		Properties properties=new Properties();
		properties.load(freader);
		
		//load driver--mysql
	Class.forName(properties.getProperty("driver"));
	//connect to database
	connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),properties.getProperty("password"));
	return connection;
	}catch(ClassNotFoundException e)
	{
		System.out.println(e.getMessage()+"   "+e.getClass());
		return null;
	}
	catch(SQLException ex)
	{
		System.out.println(ex.getMessage());
		return null;
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
	
}
}
