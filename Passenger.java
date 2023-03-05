package miniproject.model;

public class Passenger {
	public int pid;
	public String  name, contact, email,password;
	public Passenger() {
		
	}
	public Passenger(int pid, String name, String contact, String email, String password) {
		super();
		this.pid = pid;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password=password;
		
	}
	
	
	public int getId() {
		return pid;
	}


	public void setId(int pid) {
		this.pid = pid;
	}

    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	


	@Override
	public String toString() {
		return "User [pid=" + pid +  ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ",password=" +password + "]";
	}
	
	
}