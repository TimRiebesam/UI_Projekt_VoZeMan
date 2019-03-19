package application.content.notes;

import java.util.Date;

public class Note {
	
	private String title;
	private String text;
	private Date timestamp;
	
	public Note(String title, String text, Date date) {
		super();
		this.title = title;
		this.text = text;
		this.timestamp = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
