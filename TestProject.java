package miniproject;

import java.sql.SQLException;
import java.util.Scanner;
import miniproject.model.Admin;
import miniproject.model.Bus;
import miniproject.model.BusBooking;
import miniproject.model.Passenger;
import miniproject.model.User;
import miniproject.service.AdminImpl;
import miniproject.service.AdminInterface;
import miniproject.service.BusBookingImpl;
import miniproject.service.BusBookingInterface;
import miniproject.service.BusImpl;
import miniproject.service.BusInterface;
import miniproject.service.PassengerImpl;
import miniproject.service.PassengerInterface;
import miniproject.service.UserImpl;
import miniproject.service.UserInterface;

public class TestProject {
static Scanner sc =new Scanner(System.in);	
	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	BusInterface businfo=new BusImpl();
	AdminInterface admininfo=new AdminImpl();
	PassengerInterface passinfo=new PassengerImpl();
	UserInterface userinfo= new UserImpl();	
	BusBookingInterface bookinginfo=new BusBookingImpl();
	String email1=null,password=null,email2=null,passwordl=null;

		char ch5;
		do {
		System.out.println("**************************************************************");
		System.out.println("*-------------* WELCOME TO All INDIA TRANSPORT *--------------*");
		System.out.println("**************************************************************");
		System.out.println("1.Admin");
		System.out.println("2.Passenger");
		System.out.println("3.Exit");
		System.out.println("--------------------------------");
		System.out.println("Enter Your Choice:");
		System.out.println("--------------------------------");

int option = sc.nextInt();
switch (option) {
//--------------------Admin---------------------------
case 1: //Admin
	char ch;
	do{
		System.out.println("=============================");
		System.out.println("***Welcome in Admin page***");
		System.out.println("=============================");
System.out.println("1:Register \n2:Login");

System.out.println("Enter the option:");
int option1=0;
option1=sc.nextInt();// 1 2 
switch(option1)//int
{
case 1: //Register
	System.out.println("Enter EmailId: ");
	email1=sc.next();
	String str=admininfo.emailValidation(email1);
	 while(str=="Invalid") {
	 System.out.println("EmailId is Invalid enter again:");
	 email1=sc.next();
	 str=admininfo.emailValidation(email1);
	 }
	 System.out.println("Enter Password:");
		password=sc.next();
		  boolean pass =admininfo.isPasswordValid(password);
		  if(pass==false) {
		System.out.println("Password must be greater than 8 characters...! Enter Again:");
				 password=sc.next();
		  }else {
				 pass=admininfo.isPasswordValid(password);
				 }
		  System.out.println("*********************");
		  System.out.println("Register Success...!");
		  System.out.println("*********************");
          break;
case 2:   //Login
	System.out.println("Enter Your Login Details EmailId & Password");
	
		email2=sc.next();
		passwordl=sc.next();
		if(email2.equals(email1) && passwordl.equals(password))
		{
		  System.out.println("*********************");
          System.out.println("Login Success...!");
  		  System.out.println("*********************");
  		  System.out.println("What you want to Check...?");
		char ch4;
		do {
			System.out.println("1.Add Admin Details");
			System.out.println("2.Bus Details");
			System.out.println("3.User Details");
			System.out.println("4.Passenger Details");
		    System.out.println("----------------------------");
			int search=sc.nextInt();
			switch(search) {
			case 1://Admin details
			System.out.println("Enter Admin details:");
			System.out.println("Enter AdminId: ");
			int aid=sc.nextInt();
			System.out.println("Enter Admin Name: ");
			String name=sc.next();
			System.out.println("Enter Contact No.: ");
			String contact=sc.next();
			String str1=admininfo.phoneNoValidation(contact);
			 while(str1=="Invalid") {
			 System.out.println("Phone No. is Invalid....! Enter again:");
			 contact=sc.next();
			 str1=admininfo.phoneNoValidation(contact);
			 }
			System.out.println("Enter EmailId: ");
			String emailid=sc.next();
			String str2=admininfo.emailValidation(emailid);
			 while(str2=="Invalid") {
			 System.out.println("EmailId is Invalid enter again:");
			 emailid=sc.next();
			 str=admininfo.emailValidation(emailid);
			 }
			System.out.println("Enter Password: ");
			String password1=sc.next();
			System.out.println("Enter Role");
			String role=sc.next();
			Admin admin = new Admin(aid,name,contact,emailid,password1);
				try {
					admininfo.addAdmin(admin);
				} catch (SQLException e) {
					System.out.println("Adding Admin Details -->"+e.getMessage());
				}
				User user=new User(aid,name,contact,emailid,password1,role);
				userinfo.addUser(user);
				System.out.println("***********************");
				System.out.println("Admin Details Added....");
				System.out.println("***********************");

            break;
			case 2://Admin--Bus Details
				do {
					System.out.println("1.Add Bus Details");
					System.out.println("2.Update Bus Details");
					System.out.println("3.View All Bus Details");
					System.out.println("4.Delete Bus Details");
					System.out.println("----------------------------");
					int search1=sc.nextInt();
					switch(search1) {
				case 1://Add Bus Details
				System.out.println("Enter Bus details:");
				System.out.println("Enter Bus Id: ");
				int id=sc.nextInt();
				System.out.println("Enter Bus Name: ");
				String busname=sc.next();
                System.out.println("Enter Price/seat: ");
				int price=sc.nextInt();
				System.out.println("Enter Total seats of Bus: ");
				int totalseats=sc.nextInt();
				System.out.println("Enter Bus Type: ");
				String bustype=sc.next();
                System.out.println("Enter locations(eg.Pune_Mumbai): ");
				String locations=sc.next();
				System.out.println("Enter Morning Time: ");
				String mtime=sc.next();
				System.out.println("Enter Night Time: ");
				String ntime=sc.next();
				Bus bus = new Bus(id,busname, price,totalseats,bustype,locations, mtime, ntime);
					try {
						businfo.addBus(bus);
					} catch (SQLException e) {
						System.out.println("Adding Bus Details -->"+e.getMessage());
					}
					
				break;
					case 2://update bus details
						System.out.println("Enter the Bus id to update:");
						int busid=sc.nextInt();
						System.out.println("Enter the property you want to change");
						String property=sc.next();
						Bus ubus = new Bus();
						if(property.equals("busname")) {
							System.out.println("Enter the new Bus name");
							ubus.setBusname(sc.next());
						}
						
						if(property.equals("routes")) {
							System.out.println("enter the new locations");
							ubus.setLocations(sc.next());
						}
						try {
							int r=businfo.updateBus(ubus,busid,property);
						if(r==1)
							System.out.println("***********************");
                            System.out.println("Updated successfully");
							System.out.println("***********************");

						} catch (SQLException e) {
							System.out.println("update Bus details -->"+e.getMessage());
						}
						break;
						
					case 3://Display Bus Details
						try {
							businfo.displayBusDetails();
						} catch (SQLException e) {
							System.out.println("Bus Details -->"+e.getMessage());
						}
						break;
					
					case 4://delete bus details
						System.out.println("Enter the Bus id to Delete:");
						int bid2=sc.nextInt();
						try {
							businfo.deleteBus(bid2);
							System.out.println("***********************");
                            System.out.println("Deleted successfully");
							System.out.println("***********************");

                         } catch (SQLException e) {
							System.out.println("Bus Details Deleted -->"+e.getMessage());
						}
						break;
				
				}
					System.out.println("Do you want to continue with Bus Details(Y/N):");
					System.out.println("-----------------------------------------------");
					ch4=sc.next().charAt(0);
					} while (ch4=='y'||ch4=='Y');
			break;
//-----------------------------------------------------------------				
			case 3:// Admin--User Details
				int ch3;
				do {
					System.out.println("1.View All User Details");
					System.out.println("2.Delete User Details");
					System.out.println("-------------------------------");
					int search1=sc.nextInt();
					switch(search1) {
					case 1: //Display User Details
						System.out.println("***********************");
						System.out.println("***All User Details***");
						System.out.println("***********************");

						try {
							userinfo.displayUserDetails();
						} catch (SQLException e) {
							System.out.println("User Details -->"+e.getMessage());
						}
				break;	
					case 2: //delete user details
						System.out.println("Enter the User id to Delete:");
						int uid2=sc.nextInt();
						try {
							userinfo.deleteUser(uid2);
							System.out.println("***********************");

							System.out.println("Deleted successfully");
							System.out.println("***********************");

						} catch (SQLException e) {
							System.out.println("User Deleted -->"+e.getMessage());
						}
						
						break;
					}
			System.out.println("Do you want to continue with User details(Y/N):");
			System.out.println("--------------------------------");
			 ch3=sc.next().charAt(0);
			} while (ch3=='y'||ch3=='Y');
		  break;	
//-----------------------------------------------------------------				
	       case 4: //Admin-- Passsenger Details
	    	    do {
	    		   System.out.println("1.View All Passenger Details");
					System.out.println("2.Check Booking with Payment Status");
					System.out.println("-------------------------------------");
					int search1=sc.nextInt();
					switch(search1) {
					case 1: //View Passenger  details
						System.out.println("*************************");
						System.out.println("**All Passenger Details**");
						System.out.println("*************************");
						try {
							passinfo.displayPassengerDetails();
						} catch (SQLException e) {
							System.out.println("Passenger  Details -->"+e.getMessage());
						}
						break;
										
					case 2://Payment Status

						System.out.println("Which List you want to check(paid/unpaid)");
						System.out.println("------------------------------------------");

						String status=sc.next();
						if(status.equals("paid")) {
						System.out.println("*****************************************");

						System.out.println("List of Booking with Payment Status Paid...");
						System.out.println("*****************************************");

							bookinginfo.findBookingByStatus(status);
						}
						if(status.equals("unpaid"))
						{
							System.out.println("*****************************************");

							System.out.println("List of Booking with Payment Status Unpaid...");
							System.out.println("*****************************************");

							bookinginfo.findBookingByStatus(status);
						}
							
						break;
					}
					System.out.println("Want to continue with Passenger details(Y/N):");
					System.out.println("---------------------------------------------");
					ch4=sc.next().charAt(0);
					} while (ch4=='y'||ch4=='Y');
			break;
			}
				System.out.println("Do you want to continue(Y/N):");
				System.out.println("--------------------------------");
				ch4=sc.next().charAt(0);
				} while (ch4=='y'||ch4=='Y');
		
		}else
			System.out.println("Ooopsss something went wrong Try Again....!");
      break;
}
System.out.println("Do you want to continue as Admin(Y/N)");
System.out.println("--------------------------------------");
ch=sc.next().charAt(0);
}while(ch=='y'||ch=='Y');

//-----------------------------------------------------------------		
//-----------------------------------------------------------------
case 2:	 //Passenger
	System.out.println("==============**===============");
	System.out.println("***Welcome in Passenger page***");
	System.out.println("==============**================");
	String emailId=null,password2=null,emailIdl=null,password3=null;
	char ch1;
	do
	{
	System.out.println("1:Register \n2:login");
	System.out.println("Enter the option");
	int option1=0;
	option1=sc.nextInt();// 1 2 
	switch(option1)//int
	{
	case 1: System.out.println("Enter the emailId:");
			emailId=sc.next();
			String str=passinfo.emailValidation(emailId);
			 while(str=="Invalid") {
			 System.out.println("EmailId is Invalid enter again:");
			 emailId=sc.next();
			 str=passinfo.emailValidation(emailId);
			 }
			 System.out.println("Enter Password:");
			password2=sc.next();
			 boolean pass1 =admininfo.isPasswordValid(password2);
			  if(pass1==false) {
			System.out.println("Password must be greater than 8 characters...! Enter Again:");
					 password2=sc.next();
			  }else {
					 pass1=admininfo.isPasswordValid(password2);
					 }
			  System.out.println("***********************");
			  System.out.println("Register Success...!");
			  System.out.println("***********************");
			break;
	case 2: System.out.println("Enter the Login details:");
	        System.out.println("Enter emailId:");
			emailIdl=sc.next();
			System.out.println("Enter Password:");
			password3=sc.next();
			if(emailIdl.equals(emailId) && password3.equals(password2))
			{
				System.out.println("****************************");
				System.out.println("Congratulations login success");
				System.out.println("*****************************");
				char ch2;
				do {
			System.out.println("1.Add Passenger Details");
			System.out.println("2.View all Bus List");
			System.out.println("3.Bus Booking");
			System.out.println("4.View Ticket Details");
			System.out.println("5.Update Passenger Details");
		    System.out.println("------------------------------");
			int search2=sc.nextInt();
			switch(search2) {
			case 1://new Passenger
				System.out.println("Enter Passenger details");
				System.out.println("------------------------");
				System.out.println("Enter PassengerId: ");
				int id=sc.nextInt();
				System.out.println("Enter Name: ");
				String name=sc.next();
				System.out.println("Enter Contact No.: ");
				String contact=sc.next();
				String str1=passinfo.phoneNoValidation(contact);
				 while(str1=="Invalid") {
				 System.out.println("Phone No. is Invalid....! Enter again:");
				 contact=sc.next();
				 str1=passinfo.phoneNoValidation(contact);
				 }
				System.out.println("Enter EmailId: ");
				String email=sc.next();
				String str2=passinfo.emailValidation(email);
				 while(str2=="Invalid") {
				 System.out.println("EmailId is Invalid enter again:");
				 email=sc.next();
				 str2=passinfo.emailValidation(email);
				 }
				System.out.println("Enter Password: ");
				String password1=sc.next();
				System.out.println("Enter Role");
				String role=sc.next();
				Passenger pass = new Passenger(id,name,contact,email,password1);
					try {
						passinfo.addPassenger(pass);
					} catch (SQLException e) {
						System.out.println("Adding Passenger Details -->"+e.getMessage());
					}
					User user=new User(id,name,contact,email,password1,role);
					userinfo.addUser(user);
				break;
			case 2: //View all Bus List
              System.out.println("*-----*BUS List*-----*");
			  System.out.println("=======================");
				try {
					businfo.displayBusDetails();
				} catch (SQLException e) {
					System.out.println("Bus Details -->"+e.getMessage());
				}
				break;	
//----------------------------------------------------------------------------			
			case 3://Passenger--Booking
				System.out.println("==================================");
				System.out.println("***Welcome in Bus Booking page***");
				System.out.println("===================================");
				char ch4;
				do {
					System.out.println("1.Add Booking Details");
					System.out.println("2.Update Booking Details");
					System.out.println("3.View Booking Details");
		            System.out.println("4.Delete Booking Details");
					System.out.println("----------------------------");
					int search1=sc.nextInt();
					switch(search1) {
					case 1://adding booking details
						System.out.println("Enter Booking details");
						System.out.println("======================");
						System.out.println("Enter PassengerId: ");
						int bid=sc.nextInt();
						System.out.println("Enter Seat No. you want to Book: ");
						int seatNo=sc.nextInt();
						System.out.println("Enter how many seats you want to book: ");
						int bseats=sc.nextInt();
						System.out.println("Enter Location(eg.From Pune_mumbai): ");
						String desc=sc.next();
						System.out.println("Enter Your Payment Status: ");
						String pstatus=sc.next();
						System.out.println("Enter Booking Date: ");
						String bdate=sc.next();
						BusBooking booking = new BusBooking(bid,seatNo,bseats,desc,pstatus,bdate);
							try {
								bookinginfo.addBooking(booking);
							} catch (SQLException e) {
								System.out.println("Adding Booking -->"+e.getMessage());
							}
                    break;
					case 2://update booikng
						System.out.println("Enter the Passenger id to update:");
						int bookid=sc.nextInt();
						System.out.println("enter the property you want to change");
						String property=sc.next();
						BusBooking book = new BusBooking();
						if(property.equals("details")) {
							System.out.println("enter the new locations");
							book.setDesc(sc.next());
						}
						if(property.equals("bdate"))
						{
							System.out.println("enter the new Booking Date");
							book.setBdate(sc.next());
						}
						try {
							int r=bookinginfo.updateBooking(book,bookid,property);
						if(r==1)
							System.out.println("***********************");
							System.out.println("Updated successfuly");
							System.out.println("***********************");
						} catch (SQLException e) {
							System.out.println("update Booking details -->"+e.getMessage());
						}
				    break;
					case 3://View Booking details
						try {
							bookinginfo.displayBookingDetails();
							} catch (SQLException e) {
							System.out.println("Booking Details -->"+e.getMessage());
						}
					 break;
					case 4://delete booking details
						System.out.println("Enter the Passenger id to Delete:");
						int bid1=sc.nextInt();
						try {
							bookinginfo.deleteBooking(bid1);
							System.out.println("***********************");
							System.out.println("Deleted successfully");
							System.out.println("***********************");
						} catch (SQLException e) {
							System.out.println("Booking details Deleted -->"+e.getMessage());
						}
						 break;
					}
					System.out.println("Do you want to continue Booking details(Y/N):");
					System.out.println("--------------------------------");
					ch4=sc.next().charAt(0);
					} while (ch4=='y'||ch4=='Y');
			break;
//-------------------------------------------------------------------				
			case 4:// Passenger--view ticket
				System.out.println("Enter Your Passenger id:");
				int pid1=sc.nextInt();
				System.out.println("*****Your Ticket Details*****");
				System.out.println("==============================");
				try {
					passinfo.findDetailsById(pid1);
					bookinginfo.findTicketByBid(pid1);
					
				} catch (SQLException e) {
					System.out.println("Ticket Details -->"+e.getMessage());
				}
				break;
			case 5://update Passenger details
				System.out.println("Enter the Passenger id to update:");
				int pid=sc.nextInt();
				System.out.println("Enter the property you want to update");
				String property=sc.next();
				Passenger pass2 = new Passenger();
				if(property.equals("name")) {
					System.out.println("enter the new Name");
					pass2.setName(sc.next());
				}
				if(property.equals("password"))
				{
					System.out.println("enter the new password");
					pass2.setPassword(sc.next());
				}
				try {
					int r=passinfo.updatePassenger(pass2,pid,property);
				if(r==1)
					System.out.println("************************************");
					System.out.println("Passenger details Updated successfuly");
					System.out.println("*************************************");
				} catch (SQLException e) {
					System.out.println("update Passenger details -->"+e.getMessage());
				}
				
				break;
			}
			System.out.println("Do you want to continue with Passenger details(Y/N):");
			System.out.println("-----------------------------------------------------");
			ch2=sc.next().charAt(0);
			} while (ch2=='y'||ch2=='Y');
			}else
				System.out.println("Ooopsss something went wrong...Try again...!");
	break;
	}
	System.out.println("Do you want to continue as Passenger(Y/N):");
	System.out.println("------------------------------------------");
	ch1=sc.next().charAt(0);
	} while (ch1=='y'||ch1=='Y');
//------------------------------------------------------------------	
	case 3://Main---Exit
	System.out.println("***********************");
	System.out.println("Exited Successfully");
	System.out.println("***********************");
			System.exit(0);
	break;
	default:System.out.println("Enter Valid Option");
	break;
	}
	System.out.println("--------------------------------");
	System.out.println("Press (y/Y) to continue with the Booking site");
	ch5=sc.next().charAt(0);
	} while (ch5=='y'||ch5=='Y');
		
}		
}		
		




