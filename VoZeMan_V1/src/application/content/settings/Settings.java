package application.content.settings;

public class Settings {
	
	private String raplaUrl;
	private String moodleUrl;
	private String dualisUrl;
	private String usernameForMoodleAndDualis;
	private String passwordForMoodleAndDualis;
	
	public String getRaplaUrl() {
		return raplaUrl;
	}
	public void setRaplaUrl(String raplaUrl) {
		this.raplaUrl = raplaUrl;
	}
	public String getMoodleUrl() {
		return moodleUrl;
	}
	public void setMoodleUrl(String moodleUrl) {
		this.moodleUrl = moodleUrl;
	}
	public String getDualisUrl() {
		return dualisUrl;
	}
	public void setDualisUrl(String dualisUrl) {
		this.dualisUrl = dualisUrl;
	}
	public String getUsernameForMoodleAndDualis() {
		return usernameForMoodleAndDualis;
	}
	public void setUsernameForMoodleAndDualis(String username) {
		this.usernameForMoodleAndDualis = username;
	}
	public String getPasswordForMoodleAndDualis() {
		return passwordForMoodleAndDualis;
	}
	public void setPasswordForMoodleAndDualis(String password) {
		this.passwordForMoodleAndDualis = password;
	}
}
