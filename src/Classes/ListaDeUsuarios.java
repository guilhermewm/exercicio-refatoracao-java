package Classes;

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
		
		if(value.getNome().isEmpty()){
			throw new IllegalArgumentException("Não há um nome: " + value.getNome());
		}else if(value.getCpf().isEmpty()){
			throw new IllegalArgumentException("Não há um cpf: " + value.getCpf());
		}else if(value.getIdade().toString().isEmpty() || value.getIdade() == 0){
			throw new IllegalArgumentException("Não há uma idade: " + value.getIdade());
		}else if(!value.getGenero().equals(Genero.FEMININO)  && !value.getGenero().equals(Genero.MASCULINO)){
			throw new IllegalArgumentException("Não há um genero: " + value.getGenero());
		}else if(!value.getSocio().equals(Socio.SIM) && !value.getSocio().equals(Socio.NAO)){
			throw new IllegalArgumentException("Não há uma definição de associação: " + value.getSocio());
		}else if(value.getSocio().equals(Socio.SIM)){
			if(value.getNum_socio().toString().isEmpty() || value.getNum_socio() == 0){
				throw new IllegalArgumentException("Não é um numero de sócio valido: " + value.getNum_socio());
			}else{
				if(verificaSeCpfExiste(value.getCpf())){
					throw new IllegalArgumentException("CPF já cadastrado: " + value.getCpf());
				}else if(verificaSeSocioExiste(value.getNum_socio())){
					throw new IllegalArgumentException("Numero do socio já cadastrado: " + value.getNum_socio());	
				}else{
					lista_usuarios.put(value.getCpf(), value);
				}
			}
		}else{
			if(value.getSocio().equals(Socio.NAO)){
				if(value.getNum_socio().toString().isEmpty() || value.getNum_socio() != 0){
					throw new IllegalArgumentException("Não é um numero de sócio valido: " + value.getNum_socio());
				}else if(verificaSeCpfExiste(value.getCpf())) {
					throw new IllegalArgumentException("CPF já cadastrado: " + value.getCpf());
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
			return "Não há usuario com esse cpf";
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
		lista_usuarios.remove(cpf);	
	}
}
