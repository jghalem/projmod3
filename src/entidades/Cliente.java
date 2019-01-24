package entidades;

public class Cliente {

	private Integer cpf;
	private String nome;
	private String email;
	private Integer contato;
	
	
	public Cliente() {
		
	}


	public Cliente(Integer cpf, String nome, String email, Integer contato) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.contato = contato;
	}


	public Integer getCpf() {
		return cpf;
	}


	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getContato() {
		return contato;
	}


	public void setContato(Integer contato) {
		this.contato = contato;
	}


	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", contato=" + contato + "]";
	}


	
	
	
	
}
