package Classes;

public class Usuario {
	private String nome;
	private String cpf;
	private Integer idade;
	private String genero;
	private Integer num_socio;
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", genero=" + genero + ", num_socio="
				+ num_socio + "]";
	}

	public Usuario(String nome, String cpf, Integer idade, String genero, Integer num_socio) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.genero = genero;
		if(num_socio != 0){
			this.num_socio = num_socio;
		}else{
			num_socio = 0;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getNum_socio() {
		return num_socio;
	}

	public void setNum_socio(int num_socio) {
		this.num_socio = num_socio;
	}
	
	
	
	
	
}
