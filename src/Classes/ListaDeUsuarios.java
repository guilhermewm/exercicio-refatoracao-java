package Classes;

import java.util.HashMap;
import java.util.Map;

public class ListaDeUsuarios {
	private Map<Integer, Usuario> lista_usuarios;
	private int contador;
	
	public ListaDeUsuarios() {
		lista_usuarios = new HashMap<>();
		this.contador = 0;
	}
	
	public void addUsuario(Usuario value){
		lista_usuarios.put(contador, value);		
		contador++;		
	}	
	
	
	public Map getTodosUsuarios(){
		return lista_usuarios;
	}	
	
	public String getUsuarioPorCpf(String cpf){
		String usuario_com_cpf = "";
		for(int i = 0; lista_usuarios.size() > i; i++){
			if(lista_usuarios.get(i).getCpf() == cpf){
				usuario_com_cpf = lista_usuarios.get(i).toString();
			}
		}
		if(usuario_com_cpf == ""){
			return "Não há usuário com esse CPF";
		}
		return usuario_com_cpf;
	}
	
	public Integer getNumeroDePessoas(){
		int cont = 0;		
		for(int i = 0; lista_usuarios.size() > i; i++){
			cont++;
		}
		return cont;
	}	
	
	public double getQuantidadeMasculino(){
		int quantidade_masculinos = 0;
		int quantidade_total = 0;
		for(int i = 0; lista_usuarios.size() > i; i++){				
			if(lista_usuarios.get(i).getGenero() == Genero.MASCULINO){
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
		for(int i = 0; lista_usuarios.size() > i; i++){			
			if(lista_usuarios.get(i).getGenero() == Genero.FEMININO){
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
		for(int i = 0; lista_usuarios.size() > i; i++){
			if(lista_usuarios.get(i).getNum_socio() != 0){
				numero_socios++;
			}
		}		
		return numero_socios;
	}
	
	public boolean verificaSeSocioExiste(int num_socio){
		for(int i = 0; lista_usuarios.size() > i; i++){
			if(lista_usuarios.get(i).getNum_socio() == num_socio){
				return true;
			}
		}
		return false;
	}
	
	public void saiUsuario(String cpf){
		for(int i = 0; lista_usuarios.size() > i; i++){
			if(lista_usuarios.get(i).getCpf() == cpf){
				lista_usuarios.remove(i);
			}
		}		
	}
}
