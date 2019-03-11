package application.Model.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExamlpeDataService {
	
	private NotesService notesService = HandleServicesService.getNotesService();
	
	public void addExampleDataToApplication() throws ParseException {
		notesService.addNoteOnlyText(
				"VS Selbststudium JPA", 
				"Verteilte Systeme Selbststudium JPA bis 01.03.2019.", 
				new SimpleDateFormat("dd.MM.yyyy hh:mm").parse("18.02.2019 10:13")
				);
		
		notesService.addNoteOnlyText(
				"VS Lernkontrolle Grundlagen", 
				"Verteilte Systeme Lernkontrolle Grundlagen bis 28.02.2019.", 
				new SimpleDateFormat("dd.MM.yyyy hh:mm").parse("18.02.2019 10:15")
				);
		
		notesService.addNoteOnlyText(
				"UI Prototype bis 12.03.19", 
				"", 
				new SimpleDateFormat("dd.MM.yyyy hh:mm").parse("22.02.2019 14:43")
				);
		
		HandleServicesService.getSettingsService().setRaplaUrl("https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=brockmans&file=WWI17B1");
			
		}
	
}
