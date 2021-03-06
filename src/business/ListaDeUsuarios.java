package business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.rowset.spi.TransactionalWriter;

public class ListaDeUsuarios {
	private Map<String, Usuario> lista_usuarios;
	
	public ListaDeUsuarios() {
		lista_usuarios = new HashMap<>();		
	}
	
	public void addUsuario(Usuario value){
		System.out.println(value.getNum_socio());
		if(value.getNome().isEmpty()){
			throw new IllegalArgumentException("N�o h� um nome: " + value.getNome());
		}else if(value.getCpf().isEmpty()){
			throw new IllegalArgumentException("N�o h� um cpf: " + value.getCpf());
		}else if(value.getIdade().toString().isEmpty() || value.getIdade() == 0){
			throw new IllegalArgumentException("N�o h� uma idade: " + value.getIdade());
		}else if((!value.getGenero().equals(Genero.FEMININO)  && !value.getGenero().equals(Genero.MASCULINO)) || value.getGenero().equals(null)){
			throw new NullPointerException("N�o h� um genero: " + value.getGenero());
		}else if((!value.getSocio().equals(Socio.SIM) && !value.getSocio().equals(Socio.NAO)) || value.getSocio().equals(null)){
			throw new NullPointerException("N�o h� uma defini��o de associa��o: " + value.getSocio());
		}else if(value.getSocio().equals(Socio.SIM)){
			if(value.getNum_socio().toString().isEmpty() || value.getNum_socio() == 0){
				throw new IllegalArgumentException("N�o � um numero de s�cio valido: " + value.getNum_socio());
			}else{
				if(verificaSeCpfExiste(value.getCpf())){
					throw new IllegalArgumentException("CPF j� cadastrado: " + value.getCpf());
				}else if(verificaSeSocioExiste(value.getNum_socio())){
					throw new IllegalArgumentException("Numero do socio j� cadastrado: " + value.getNum_socio());	
				}else{
					lista_usuarios.put(value.getCpf(), value);
				}
			}
		}else{
			if(value.getSocio().equals(Socio.NAO)){
				if(!value.getNum_socio().toString().isEmpty() && !value.getNum_socio().equals(0)){
					throw new IllegalArgumentException("N�o � um numero de s�cio valido: " + value.getNum_socio());
				}else if(verificaSeCpfExiste(value.getCpf())) {
					throw new IllegalArgumentException("CPF j� cadastrado: " + value.getCpf());
				}else{
					lista_usuarios.put(value.getCpf(), value);
				}
			}
		}
							
	}	
	
	
	public Map getTodosUsuarios(){
		System.out.println(lista_usuarios);
		return lista_usuarios;
	}	
	
	public String getUsuarioPorCpf(String cpf){
		System.out.println(cpf);
		if(lista_usuarios.containsKey(cpf)){
			return lista_usuarios.get(cpf).toString();
		}else{
			throw new IllegalArgumentException("N�o h� usuario com esse cpf: " + cpf);			
		}	
	}
	
	public Integer getNumeroDePessoas(){
		int cont = 0;
		for (String key : lista_usuarios.keySet()) {            
			cont++;			
		}
		return cont;
	}	
	
	public Integer getNumeroNaoSocios(){		
		return (getNumeroDePessoas()-getSocios());
	}	
	
	public double getQuantidadeMasculino(){
		int quantidade_masculinos = 0;
		int quantidade_total = 0;
		
		for (String key : lista_usuarios.keySet()) {
            if(lista_usuarios.get(key).getGenero() == Genero.MASCULINO){
            	quantidade_masculinos++;
            }
			quantidade_total++;			
		}
		
		if(quantidade_masculinos == 0){
			return 0;
		}else{
			return ((quantidade_masculinos*100)/quantidade_total);
		}	
	}
	
	public double getQuantidadeFeminino(){		
		int quantidade_femininos = 0;
		int quantidade_total = 0;
		
		for (String key : lista_usuarios.keySet()) {
            if(lista_usuarios.get(key).getGenero() == Genero.FEMININO){
            	quantidade_femininos++;
            }
			quantidade_total++;			
		}		
		if(quantidade_femininos == 0){
			return 0;
		}else{
			return ((quantidade_femininos*100)/quantidade_total);
		}	
	}
	
	public Integer getSocios(){
		int numero_socios = 0;
		for (String key : lista_usuarios.keySet()) {
			if(lista_usuarios.get(key).getSocio() == Socio.SIM){
				numero_socios++;
			}
		}
		return numero_socios;			
	}
	
	public boolean verificaSeSocioExiste(int num_socio){
		for (String key : lista_usuarios.keySet()) {
			if(lista_usuarios.get(key).getNum_socio() == num_socio){
				return true;
			}
		}		
		return false;
	}
	
	public boolean verificaSeCpfExiste(String cpf){
		if(lista_usuarios.containsKey(cpf)){
			return true;
		}else{
			return false;
		}
	}
	
	public void saiUsuario(String cpf){	
		if(verificaSeCpfExiste(cpf) == true){
			lista_usuarios.remove(cpf);				
		}else{
			throw new IllegalArgumentException("Usu�rio com este cpf n�o est� no restaurante: " + cpf);
		}
	}
	
	public void saiTodosOsUsuarios(){
		lista_usuarios.clear();
	}
}
