package application.helper;

import application.content.lecturer.LecturerList;
import application.content.mensa.Mensa;
import application.content.notes.NotesList;
import application.content.roomes.Roomes;
import application.content.settings.Settings;
import application.content.weblinks.WebLinks;
import application.menu.Menu;

public class ModelHandler {
	
	private final static Menu MENU = new Menu();
	private final static LecturerList LECTURER_LIST = new LecturerList();
	private final static Mensa MENSA = new Mensa();
	private final static NotesList NOTES_LIST = new NotesList();
	private final static Roomes ROOMES = new Roomes();
	private final static Settings SETTINGS = new Settings();
	private final static WebLinks WEB_LINKS = new WebLinks();
	
	public static Menu getMenu() {
		return MENU;
	}
	public static LecturerList getLecturerList() {
		return LECTURER_LIST;
	}
	public static Mensa getMensa() {
		return MENSA;
	}
	public static NotesList getNotesList() {
		return NOTES_LIST;
	}
	public static Roomes getRoomes() {
		return ROOMES;
	}
	public static Settings getSettings() {
		return SETTINGS;
	}
	public static WebLinks getWebLinks() {
		return WEB_LINKS;
	}
	
}
