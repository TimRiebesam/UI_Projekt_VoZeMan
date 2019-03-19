package application.helper;

import application.content.lecturer.Lecturer;
import application.content.lecturer.LecturerList;

public class DefaultDataLoader {
	
	public static void loadDefaultData() {
		ModelHandler.getSettings().setDualisUrl("https://dualis.dhbw.de");
		ModelHandler.getSettings().setMoodleUrl("https://moodle.dhbw.de/my/");
		ModelHandler.getSettings().setRaplaUrl("https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=brockmans&file=WWI17B1");
		
		//Anweisungen um Dozenten zu erzeugen
		LecturerList lecturerList = ModelHandler.getLecturerList();
		lecturerList.add(new Lecturer("nicolas", "bahnhof3", "Professor", "djdj@djd.de"));
		lecturerList.add(new Lecturer("tim", "tivoli", "doktor", "tim@ruebi.de"));
		lecturerList.add(new Lecturer("hrhr", "ebertstr", "doktor", "ehehe@hoho.de"));
	

		
		
		
	}
	
}
