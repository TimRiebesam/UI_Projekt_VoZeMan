package application.content.lecturer;

public class Lecturer {

	private String name;
	private String address;
	private String title;
	private String email;
	
	
	public Lecturer() {
		
	}
	
	public Lecturer(String name, String address, String title, String email) {
		super();
		this.name = name;
		this.address = address;
		this.title = title;
		this.email = email;
	}
	
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
	
	public String toString() {
		
		return "Titel: " + this.getTitle() + "\n" +
				"Name: " + this.getName()+ "\n" +
				"E-Mail: " + this.getEmail()+ "\n" +
				"Adresse: " + this.getAddress();
	}


	
}
