package Classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListaDeUsuarios {
	private Map<String, Usuario> lista_usuarios;
	
	public ListaDeUsuarios() {
		lista_usuarios = new HashMap<>();		
	}
	
	public void addUsuario(Usuario value){
		lista_usuarios.put(value.getCpf(), value);						
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
