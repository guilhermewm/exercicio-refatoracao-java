package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.Genero;
import Classes.ListaDeUsuarios;
import Classes.Socio;
import Classes.Usuario;

public class TesteClasseListaDeUsuarios {
	private ListaDeUsuarios lista;
	private Usuario usuario_completo;
	
	private Usuario usuario_sem_nome;
	private Usuario usuario_sem_cpf;
	private Usuario usuario_sem_idade;	
	private Usuario usuario_socio_sem_numero;
	
	private Usuario usuario_com_cpf_x_nao_socios;
	private Usuario usuario_com_cpf_x_tambem_nao_socios;
	
	private Usuario usuario_com_numero_socio_x;
	private Usuario usuario_com_numero_socio_x_tambem;
	
	@Before
	public void setUp() throws Exception{
		lista = new ListaDeUsuarios();
		usuario_completo = new Usuario("João", "10578467845", 22, Genero.MASCULINO, Socio.NAO, 0);
		usuario_sem_cpf = new Usuario("Maria", "", 20, Genero.FEMININO, Socio.NAO, 0);
		usuario_sem_idade = new Usuario("Fernando", "01257896354", 0, Genero.MASCULINO, Socio.SIM, 1);
		usuario_socio_sem_numero = new Usuario("Bruna", "97563214587", 19, Genero.MASCULINO, Socio.SIM, 0);
		usuario_sem_nome = new Usuario("", "12345678514", 19, Genero.FEMININO, Socio.SIM, 10);
		
		usuario_com_cpf_x_nao_socios = new Usuario("Maria", "12345678514", 19, Genero.FEMININO, Socio.NAO, 0);
		usuario_com_cpf_x_tambem_nao_socios = new Usuario("Fernanda", "12345678514", 20, Genero.FEMININO, Socio.NAO, 0);
		
		usuario_com_numero_socio_x = new Usuario("Maria", "4653131355", 19, Genero.FEMININO, Socio.SIM, 10);
		usuario_com_numero_socio_x_tambem = new Usuario("Fernanda", "1234478514", 20, Genero.FEMININO, Socio.SIM, 10);
		
	}
	
	@Test
	public void testaSeUmUsuarioEAdicionado() {
		lista.addUsuario(usuario_completo);
		String expected = lista.getUsuarioPorCpf(usuario_completo.getCpf());
		assertEquals(expected, usuario_completo.toString());
	}
	
	@Test 
	public void testaSeUmUsuarioSemNomeEAdicionado() {		
		try{
			lista.addUsuario(usuario_sem_nome);
			assertTrue("Devia ter lançado exception",false);
		}catch(Exception e){
	        assertTrue("Nao disparou uma IllegalArgumentException",e instanceof IllegalArgumentException); 
	    }
	}
	
	@Test 
	public void testaSeUmUsuarioSemCpfEAdicionado() {		
		try{
			lista.addUsuario(usuario_sem_cpf);
			assertTrue("Devia ter lançado exception",false);
		}catch(Exception e){
	        assertTrue("Nao disparou uma IllegalArgumentException",e instanceof IllegalArgumentException); 
	    }
	}

	@Test 
	public void testaSeUmUsuarioSemIdadeEAdicionado() {		
		try{
			lista.addUsuario(usuario_sem_idade);
			assertTrue("Devia ter lançado exception",false);
		}catch(Exception e){
	        assertTrue("Nao disparou uma IllegalArgumentException",e instanceof IllegalArgumentException); 
	    }
	}
	
	@Test 
	public void testaSeUmUsuarioSocioESemNumeroEAdicionado() {		
		try{
			lista.addUsuario(usuario_socio_sem_numero);
			assertTrue("Devia ter lançado exception",false);
		}catch(Exception e){
	        assertTrue("Nao disparou uma IllegalArgumentException",e instanceof IllegalArgumentException); 
	    }
	}
	
	@Test 
	public void testaSeUmUsuarioNaoSocioEComCpfJaCadastradoEAdicionado() {		
		try{
			lista.addUsuario(usuario_com_cpf_x_nao_socios);
			lista.addUsuario(usuario_com_cpf_x_tambem_nao_socios);			
			assertTrue("Devia ter lançado exception",false);
		}catch(Exception e){
	        assertTrue("Nao disparou uma IllegalArgumentException",e instanceof IllegalArgumentException); 
	    }
	}
	
	@Test 
	public void testaSeUmUsuarioSocioENumeroDesocioJaCadastradoEAdicionado() {		
		try{
			lista.addUsuario(usuario_com_numero_socio_x);
			lista.addUsuario(usuario_com_numero_socio_x_tambem);			
			assertTrue("Devia ter lançado exception",false);
		}catch(Exception e){
	        assertTrue("Nao disparou uma IllegalArgumentException",e instanceof IllegalArgumentException); 
	    }
	}
	
	
}
