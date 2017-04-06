package business;

public class Usuario {
	private String nome;
	private String cpf;
	private Integer idade;
	private Genero genero;
	private Socio socio;
	private Integer num_socio;

	

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", genero=" + genero + ", socio=" + socio
				+ ", num_socio=" + num_socio + "]";
	}

	public Usuario(String nome, String cpf, Integer idade, Genero genero, Socio socio, Integer num_socio) {
		System.out.println(socio + "  " + genero);
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.genero = genero;
		this.socio = socio;
		if(socio.equals(Socio.SIM)){
			this.num_socio = num_socio;
		}else{
			this.num_socio = 0;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public Integer getNum_socio() {
		return num_socio;
	}

	public void setNum_socio(int num_socio) {
		this.num_socio = num_socio;
	}
	
	
	
	
	
	
}
