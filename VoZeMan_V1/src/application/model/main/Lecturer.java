package application.model.main;

public class Lecturer {

	private String name;
	private String address;
	private String title;
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Lecturer(String name, String address, String title, String email) {
		super();
		this.name = name;
		this.address = address;
		this.title = title;
		this.email = email;
	}
	
}
