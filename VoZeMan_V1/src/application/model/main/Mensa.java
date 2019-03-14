package application.model.main;

import javafx.scene.image.Image;

public class Mensa {

	Image planForToday;
	Image planForTomorrow;
	Image planForCurrentWeek;
	
	public Image getPlanForToday() {
		return planForToday;
	}
	public void setPlanForToday(Image planForToday) {
		this.planForToday = planForToday;
	}
	public Image getPlanForTomorrow() {
		return planForTomorrow;
	}
	public void setPlanForTomorrow(Image planForTomorrow) {
		this.planForTomorrow = planForTomorrow;
	}
	public Image getPlanForCurrentWeek() {
		return planForCurrentWeek;
	}
	public void setPlanForCurrentWeek(Image planForCurrentWeek) {
		this.planForCurrentWeek = planForCurrentWeek;
	}
	
}
