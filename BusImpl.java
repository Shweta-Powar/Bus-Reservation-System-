package miniproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import miniproject.DatabaseConnection;
import miniproject.model.Bus;
import miniproject.model.User;

public class BusImpl implements BusInterface{
	Connection connection=null;
	PreparedStatement pstatement=null;
	public BusImpl()
	{
		connection=DatabaseConnection.getCustConnection();
	}
	
	public void addBus(Bus bus) throws SQLException {
		pstatement=connection.prepareStatement("insert into Buslist values(?,?,?,?,?,?,?,?)");
		pstatement.setInt(1, bus.getId());
		pstatement.setString(2, bus.getBusname());
		pstatement.setInt(3,bus.getPrice());
		pstatement.setInt(4,bus.getTotalseats());
		pstatement.setString(5, bus.getBustype());
        pstatement.setString(6, bus.getLocations());
		pstatement.setString(7, bus.getMtime());
		pstatement.setString(8,bus.getNtime());
		int res=pstatement.executeUpdate();
		if(res==1)
		{
			System.out.println("*********************************");
			System.out.println("Bus details inserted successfully");
			System.out.println("**********************************");
		}
	}	
		
public int deleteBus(int id) throws SQLException {
		pstatement=connection.prepareStatement("delete from Buslist where id=?");
		pstatement.setInt(1,id);
        int rs=pstatement.executeUpdate();	
		return 0;
	}

	public Bus findBusById(int id) throws SQLException {
		pstatement=connection.prepareStatement("select *from Buslist where id=?");
		pstatement.setInt(1,id);
		ResultSet rs=pstatement.executeQuery();
		rs.next();
		Bus bus=new Bus(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
		return bus;
	
	}

	public void displayBusDetails() throws SQLException {
		pstatement=connection.prepareStatement("select * from Buslist");
		ResultSet res1=pstatement.executeQuery();
	        while (res1.next()) {
	                int id=res1.getInt("id");
	                String busname=res1.getString("busname");
	            	int price=res1.getInt("ticket_price");
	            	int totalseats=res1.getInt("totalseats");
	                String bustype=res1.getString("bustype");
	                String locations=res1.getString("Routes");
	                String mtime=res1.getString("mtime");
	                String ntime=res1.getString("ntime");
	                
	            	Bus bus=new Bus(id,busname,price,totalseats,bustype,locations,mtime,ntime);
                    System.out.println(bus);
//	            	System.out.println("BusId= "+id);
//	            	System.out.println("Bus Name= "+busname);
//	            	System.out.println("Ticket Price/seat= "+price);
//	            	System.out.println("Total Seats of Bus= "+totalseats);
//	            	System.out.println("Type of Bus= "+bustype);
//	            	System.out.println("Route= "+locations);
//	            	System.out.println("Morning Time= "+mtime);
//	            	System.out.println("Night Time= "+ntime);
	               }
		}

	public int updateBus(Bus bus, int id, String property) throws SQLException {
		// TODO Auto-generated method stub
		Bus bus1=findBusById(id);
		if(property.equals("busname"))
			bus1.setBusname(bus.getBusname());
		if(property.equals("routes"))
			bus1.setLocations(bus.getLocations());
		
			pstatement=connection.prepareStatement("update users set busname=?,routes=? where id=? ");
			pstatement.setString(1,bus1.getBusname());
			pstatement.setString(2, bus1.getLocations());
			pstatement.setInt(3,id);
			int r=pstatement.executeUpdate();
			return r;
		
	}

}