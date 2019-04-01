package application.content.lecturer;

public class Lecturer {

	private String name;
	private String address;
	private String title;
	private String email;
	private String phone;
	private String lecture;
	private String pathToImage;
	
	public Lecturer(String name, String address, String title, String email, String phone, String lecture, String pathToImage) {
		super();
		this.name = name;
		this.address = address;
		this.title = title;
		this.email = email;
		this.phone = phone;
		this.lecture = lecture;
		this.pathToImage = pathToImage;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	
	public String getPathToImage() {
		return pathToImage;
	}
	
	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
	}

	@Override
	public String toString() {
		return "Name: " + title + " " + name + "\n" +
				"Vorlesung: " + lecture + "\n" +
				"Standort: " + address + "\n" +
				"Telefon: " + phone + "\n" + 
				"E-Mail: " + email + "\n";
	}
	
}
