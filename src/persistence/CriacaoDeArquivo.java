package persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import business.Genero;
import business.Socio;
import business.Usuario;

public class CriacaoDeArquivo {
	Integer count;
	private Map<String, Usuario> lista_usuarios_arquivo;
	
	public CriacaoDeArquivo(){
		this.count = 0;
		lista_usuarios_arquivo = new HashMap<>();		
	}
	
	public void addUsuario(Usuario value){
		lista_usuarios_arquivo.put(value.getCpf(), value);							
	}
	
	public void criaArquivo() throws IOException{
	    FileWriter arq = new FileWriter("dados_usuarios/dia" + Integer.toString(count) + ".txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf("+--Dia "+ count + "--+%n");	    
	    gravarArq.printf(lista_usuarios_arquivo.toString());
	    gravarArq.close();	
	    lista_usuarios_arquivo.clear();
	    count++;
	}
	
	
}
