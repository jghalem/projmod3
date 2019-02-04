package entidade;

public class Cliente {

	private String nome;
	private String rg;
	private String cpf;
	private String telefone;
	private String update;

	public Cliente() {

	}

	public Cliente(String nome, String rg, String cpf, String telefone, String update) {

		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.update = update;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "Cliente: nome:" + nome + ", rg=" + rg + ", cpf=" + cpf + ", telefone=" + telefone + "";
	}

}
