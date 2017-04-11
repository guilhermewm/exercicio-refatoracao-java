package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Calendario;


public class TesteClasseCalendario {
	private Calendario calendario;
	
	@Before
	public void setUp() throws Exception{
		calendario = new Calendario();					
	}
	
	
	// Execução correta
	
	@Test
	public void testaSeODiaEOEsperado() {
		String actual = calendario.getCalendario();
		assertEquals("11/4/2017", actual);
	}
	
	@Test
	public void testaSePassaParaOProximoDia() {				
		calendario.proximoDia();
		String actual = calendario.getCalendario();
		assertEquals("12/4/2017", actual);
	}
	
	
	
	
	
}
