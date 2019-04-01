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
		lecturerList.add(new Lecturer("Sara Brockmans", "KA, Erzbergerstraﬂe 121, Raum C549", "Prof. Dr.", "sara.brockmans@dhbw-karlsruhe.de", "+49 721 9735-988", "Programmieren 1", "application/img/lecturer.png"));
		lecturerList.add(new Lecturer("Dietmar Ratz", "KA, Erzbergerstraﬂe 121, Raum C566", "Prof. Dr.", "dietmar.ratz@dhbw-karlsruhe.de", "+49 721 9735-954", "Studiengangsleitung Wirtschaftinformatik", "application/img/lecturer.png"));
		lecturerList.add(new Lecturer("Nikolai Preiﬂ", "STU, Roteb¸hlplatz 41, Raum 2.07", "Prof. Dr.", "nikolai.preiss@dhbw-stuttgart.de", "+49 711 1849-4550", "Datenbankentwurf/technik", "application/img/lecturer.png"));
	}
	
}
