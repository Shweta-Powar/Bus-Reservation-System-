package miniproject.model;

public class Admin {
	public int aid;
	public String name, contact, email,password;
	
public Admin() {
		
	}
	public Admin(int aid, String name, String contact, String email, String password) {
		super();
		this.aid = aid;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password=password;
		//this.role = role;
	}
	
	
	public int getId() {
		return aid;
	}


	public void setId(int uid) {
		this.aid = uid;
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
		return "User [uid=" + aid +  ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ",password=" +password + " ]";
	}
		
	
}