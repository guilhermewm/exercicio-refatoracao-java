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
		return "      Nome :" + nome + ", CPF: " + cpf + ", Idade: " + idade + ", Genero: " + genero + ", Socio: " + socio
				+ ", Numero sócio: " + num_socio + "\n";
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



	public String getCpf() {
		return cpf;
	}



	public Integer getIdade() {
		return idade;
	}



	public Genero getGenero() {
		return genero;
	}



	public Socio getSocio() {
		return socio;
	}

	
	
	public Integer getNum_socio() {
		return num_socio;
	}

	
	
	
	
	
	
}
