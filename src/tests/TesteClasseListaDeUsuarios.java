package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Genero;
import business.ListaDeUsuarios;
import business.Socio;
import business.Usuario;

public class TesteClasseListaDeUsuarios {
	private ListaDeUsuarios lista;
	private Usuario usuario_completo;
	
	private Usuario usuario_sem_nome;
	private Usuario usuario_sem_cpf;
	private Usuario usuario_sem_idade;	
	private Usuario usuario_socio_sem_numero;
	private Usuario usuario_sem_genero;
	
	private Usuario usuario_com_cpf_x_nao_socio;
	private Usuario usuario_com_cpf_x_tambem_nao_socio;
	
	private Usuario usuario_com_cpf_x_socio;
	private Usuario usuario_com_cpf_x_tambem_socio;
	
	private Usuario usuario_com_numero_socio_x;
	private Usuario usuario_com_numero_socio_x_tambem;
	
	private Usuario usuario_sem_associacao;
	

	@Before
	public void setUp() throws Exception{
		lista = new ListaDeUsuarios();
		usuario_completo = new Usuario("João", "10578467845", 22, Genero.MASCULINO, Socio.NAO, 0);
		usuario_sem_cpf = new Usuario("Maria", "", 20, Genero.FEMININO, Socio.NAO, 0);
		usuario_sem_idade = new Usuario("Fernando", "01257896354", 0, Genero.MASCULINO, Socio.SIM, 1);
		usuario_socio_sem_numero = new Usuario("Bruna", "97563214587", 19, Genero.MASCULINO, Socio.SIM, 0);
		usuario_sem_nome = new Usuario("", "12345678514", 19, Genero.FEMININO, Socio.SIM, 10);
		
		//usuario_sem_associacao = new Usuario("Joãoa", "asfafs", 22, Genero.MASCULINO, null, 0);
		
		usuario_sem_genero = new Usuario("Sem genero", "fsafasffsa", 19, null, Socio.SIM, 10);
		
		usuario_com_cpf_x_nao_socio = new Usuario("Maria", "12345678514", 19, Genero.FEMININO, Socio.NAO, 0);
		usuario_com_cpf_x_tambem_nao_socio = new Usuario("Fernanda", "12345678514", 20, Genero.FEMININO, Socio.NAO, 0);
		
		usuario_com_numero_socio_x = new Usuario("Maria", "4653131355", 19, Genero.FEMININO, Socio.SIM, 10);
		usuario_com_numero_socio_x_tambem = new Usuario("Fernanda", "1234478514", 20, Genero.FEMININO, Socio.SIM, 10);
		
		usuario_com_cpf_x_socio = new Usuario("Maria", "59874632875", 19, Genero.FEMININO, Socio.SIM, 10);
		usuario_com_cpf_x_tambem_socio = new Usuario("Fernanda", "59874632875", 20, Genero.FEMININO, Socio.SIM, 9);
				
	}
	
	
	// Execução correta
	
	@Test
	public void testaSeUmUsuarioEAdicionado() {
		lista.addUsuario(usuario_completo);
		String expected = lista.getUsuarioPorCpf(usuario_completo.getCpf());
		assertEquals(expected, usuario_completo.toString());
	}
	
	@Test
	public void testaSeRetornaUmUsuarioComCpfValido(){
		lista.addUsuario(usuario_completo);
		String expected = lista.getUsuarioPorCpf(usuario_completo.getCpf());
		assertEquals(expected, usuario_completo.toString());
	}
	
	@Test
	public void testaSeRetornaONumeroDePessoas(){
		lista.addUsuario(usuario_completo);
		int actual = lista.getNumeroDePessoas();
		assertEquals(1, actual);
	}
	
	@Test
	public void testaSeRetornaONumeroDeNaoSocios(){
		lista.addUsuario(usuario_completo);
		lista.addUsuario(usuario_com_cpf_x_nao_socio);
		lista.addUsuario(usuario_com_numero_socio_x);
		
		int actual = lista.getNumeroNaoSocios();
		assertEquals(2, actual);
	}
	
	@Test
	public void testaSeRetornaONumeroDePessoasDeSexoMasculinoQuandoForMaiorQueZero(){
		lista.addUsuario(usuario_completo);
		lista.addUsuario(usuario_com_cpf_x_nao_socio);
		lista.addUsuario(usuario_com_numero_socio_x);
		double actual = lista.getQuantidadeMasculino();
		assertEquals(33.0, actual, 0.00);
	}
	
	@Test
	public void testaSeRetornaONumeroDePessoasDeSexoMasculinoQuandoForZero(){	
		lista.addUsuario(usuario_com_cpf_x_nao_socio);
		double actual = lista.getQuantidadeMasculino();
		assertEquals(0.0, actual, 0.00);
	}
	
	@Test
	public void testaSeRetornaONumeroDePessoasDeSexoFemininoQuandoForMaiorQueZero(){
		lista.addUsuario(usuario_completo);
		lista.addUsuario(usuario_com_cpf_x_nao_socio);
		lista.addUsuario(usuario_com_numero_socio_x);
		double actual = lista.getQuantidadeFeminino();
		assertEquals(66.0, actual, 0.00);
	}
	
	@Test
	public void testaSeRetornaONumeroDePessoasDeSexoFemininoQuandoForZero(){	
		lista.addUsuario(usuario_completo);
		double actual = lista.getQuantidadeFeminino();
		assertEquals(0.0, actual, 0.00);
	}
	
	@Test
	public void testaSeRetornaONumeroDeSocios(){	
		lista.addUsuario(usuario_completo);
		lista.addUsuario(usuario_com_cpf_x_socio);
		int actual = lista.getSocios();
		assertEquals(1, actual);
	}
	
	@Test
	public void testaSeSocioDeDeterminadoIdExiste(){			
		lista.addUsuario(usuario_com_cpf_x_socio);		
		boolean actual = lista.verificaSeSocioExiste(usuario_com_cpf_x_socio.getNum_socio());
		assertEquals(true, actual);
	}
	
	@Test
	public void testaSeSocioDeDeterminadoIdNaoExiste(){			
		lista.addUsuario(usuario_com_cpf_x_socio);		
		boolean actual = lista.verificaSeSocioExiste(4587);
		assertEquals(false, actual);
	}
	
	@Test
	public void testaSeSocioDeDeterminadoCpfExiste(){			
		lista.addUsuario(usuario_com_cpf_x_socio);		
		boolean actual = lista.verificaSeCpfExiste(usuario_com_cpf_x_socio.getCpf());
		assertEquals(true, actual);
	}
	
	@Test
	public void testaSeSocioDeDeterminadoCpfNaoExiste(){			
		lista.addUsuario(usuario_com_cpf_x_socio);		
		boolean actual = lista.verificaSeCpfExiste("215411");
		assertEquals(false, actual);
	}
	
	@Test
	public void testaSeSocioSaiDoEstabelecimento(){			
		lista.addUsuario(usuario_com_cpf_x_socio);	
		lista.saiUsuario(usuario_com_cpf_x_socio.getCpf());	
		int actual = lista.getNumeroDePessoas();
		assertEquals(0, actual);
	}
	
	
	
	
	
	
	
	// Erros
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioSemNomeEAdicionado() {	
		lista.addUsuario(usuario_sem_nome);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioSemCpfEAdicionado() {	
		lista.addUsuario(usuario_sem_cpf);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioSemIdadeEAdicionado() {		
		lista.addUsuario(usuario_sem_idade);
	}
	
	@Test (expected = NullPointerException.class)
	public void testaSeUmUsuarioSemGeneroEAdicionado() {		
		lista.addUsuario(usuario_sem_genero);
	}	
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioSocioESemNumeroEAdicionado() {		
		lista.addUsuario(usuario_socio_sem_numero);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioNaoSocioEComCpfJaCadastradoEAdicionado() {		
		lista.addUsuario(usuario_com_cpf_x_nao_socio);
		lista.addUsuario(usuario_com_cpf_x_tambem_nao_socio);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioSocioENumeroDesocioJaCadastradoEAdicionado() {		
		lista.addUsuario(usuario_com_numero_socio_x);
		lista.addUsuario(usuario_com_numero_socio_x_tambem);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeUmUsuarioSocioEComCpfJaCadastradoEAdicionado() {			
		lista.addUsuario(usuario_com_cpf_x_socio);
		lista.addUsuario(usuario_com_cpf_x_tambem_socio);
	}
	
	@Test (expected = NullPointerException.class)
	public void testaSeUmUsuarioSemAssociacaoEAdicionado() {			
		lista.addUsuario(usuario_sem_associacao);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSeRetornaUmUsuarioComCpfValidoSemEstarCadastrado(){
		lista.addUsuario(usuario_completo);
		lista.getUsuarioPorCpf("123654789");		
	}
	
	
	
}
