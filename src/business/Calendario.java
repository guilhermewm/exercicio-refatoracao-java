package business;

import java.util.Calendar;

public class Calendario {
	private Calendar calendario;
	
	public Calendario(){
		this.calendario = Calendar.getInstance();
		calendario.set(2017, 04, 11);
	}
	

	public String getCalendario(){
		return Integer.toString(calendario.get(Calendar.DAY_OF_MONTH)) + "/" + Integer.toString(calendario.get(Calendar.MONTH)) + "/" + Integer.toString(calendario.get(Calendar.YEAR));
	}
	
	public void proximoDia(){
		calendario.add(Calendar.DATE, 1);
	}
	
	
}

