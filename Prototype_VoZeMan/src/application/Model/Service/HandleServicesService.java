package application.Model.Service;

public class HandleServicesService {
	
	private static MenuService menuService = new MenuService();
	private static NotesService notesService = new NotesService();
	private static StageResizeService stageResizeService = new StageResizeService();
	private static RaplaService raplaService = new RaplaService();
	private static RoomesService roomesService = new RoomesService();
	private static MensaService mensaService = new MensaService();
	private static LecturererService lecturererService = new LecturererService();
	private static SettingsService settingsService = new SettingsService();
	private static ExamlpeDataService examlpeDataService = new ExamlpeDataService();
	
	public static MenuService getMenuService() {
		return menuService;
	}
	public static NotesService getNotesService() {
		return notesService;
	}
	public static StageResizeService getStageResizeService() {
		return stageResizeService;
	}
	public static RaplaService getRaplaService() {
		return raplaService;
	}
	public static RoomesService getRoomesService() {
		return roomesService;
	}
	public static MensaService getMensaService() {
		return mensaService;
	}
	public static LecturererService getLecturererService() {
		return lecturererService;
	}
	public static SettingsService getSettingsService() {
		return settingsService;
	}
	public static ExamlpeDataService getExamlpeDataService() {
		return examlpeDataService;
	}

}
