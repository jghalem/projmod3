package entidade;

public class Cliente {

	private Integer codigo;
	private String nome;
	private String email;
	private String sexo;

	public Cliente() {
	}

	public Cliente(Integer codigo, String nome, String email, String sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Info Cliente:" + "\n cod= " + codigo + "\n nome= " + nome + "\n email= " + email + "\n sexo= " + sexo;
	}

}
