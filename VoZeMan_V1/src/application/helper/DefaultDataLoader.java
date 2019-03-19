package application.helper;

public class DefaultDataLoader {
	
	public static void loadDefaultData() {
		ModelHandler.getSettings().setDualisUrl("https://dualis.dhbw.de");
		ModelHandler.getSettings().setMoodleUrl("https://moodle.dhbw.de/my/");
		ModelHandler.getSettings().setRaplaUrl("https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=brockmans&file=WWI17B1");
		
		
	}
	
}
