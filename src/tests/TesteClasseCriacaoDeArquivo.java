package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import business.Calendario;
import business.Genero;
import business.Socio;
import business.Usuario;
import persistence.CriacaoDeArquivo;

public class TesteClasseCriacaoDeArquivo {
	private Usuario usuario_completo;
	private CriacaoDeArquivo arquivo;
	
	@Before
	public void setUp() throws Exception{
		arquivo = new CriacaoDeArquivo();					
		usuario_completo = new Usuario("João", "10578467845", 22, Genero.MASCULINO, Socio.NAO, 0);
	}
	
	
	// Execução correta
	
	@Test
	public void testaSeAdicionaUsuarioNaLista() {
		arquivo.addUsuario(usuario_completo);
		String expected = arquivo.getUsuarioPorCpf(usuario_completo.getCpf());
		assertEquals(expected, usuario_completo.toString());	
	}
	
	@Test 
	public void testaSeCriaArquivo() throws IOException{	
		arquivo.criaArquivo();	
	}

}
