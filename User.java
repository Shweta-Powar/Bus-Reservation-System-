package miniproject.model;

public class User {
	public int uid;
	public String  name, contact, email,password,role;
	public User() {
		
	}
	public User(int uid, String name, String contact, String email, String password,String role) {
		super();
		this.uid = uid;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password=password;
		this.role = role;
	}
	
	
	public int getId() {
		return uid;
	}


	public void setId(int uid) {
		this.uid = uid;
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

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid +  ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ",password=" +password + " ,role=" + role + "]";
	}
	
	
}