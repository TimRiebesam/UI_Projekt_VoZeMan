/*
 * Die Klasse dient zum ANlegen von Dozenten, um diese später der ComboBox im Menü Dozenten hinzuzufügen
 * HAT NOCH KEINE FUNKTION
 */
package application.Model;

public class Lecturer {

	//Attribute
	

	private String name;
	private String lastname;
	private String titel;
	private String eMail;
	
	
	//Constructor
	public Lecturer() {
		
	}
	
	public Lecturer (String pName, String pLastname, String pTitel, String pEMail) {
		name = pName;
		lastname = pLastname;
		titel = pTitel;
		eMail = pEMail;
	}
	
	
	//getter and setter Methods

	public void setName(String pName) {
		this.name = pName;
	}
	
	public void setLastname(String pLastname) {
		this.lastname = pLastname;		
	}
	
	public void setTitel(String pTitel) {
		this.titel = pTitel;
	}
	
	public void setEMail(String pEmail) {
		this.eMail = pEmail;	
		
	}
	

	
	public String getName() {
		return this.name;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public String getTitel() {
		return this.titel;
	}
	
	public String getEmail() {
		return this.eMail;
	}



	

	
	
	
	
	
	
	
	
	
	
	
}
