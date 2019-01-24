package entidades;

public class Funcionario {

	private Integer codigo;
	private String nome;
	private String email;
	private Integer contato;
	private String cargo;
	
	
	public Funcionario() {
		
	}


	public Funcionario(Integer codigo, String nome, String email, Integer contato, String cargo) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.contato = contato;
		this.cargo = cargo;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", contato=" + contato
				+ ", cargo=" + cargo + "]";
	}
	
	
	
	
}
