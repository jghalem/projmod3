package entidade;

public class Funcionario {

	private String nome;
	private String rg;
	private String cpf;
	private String contato;
	private boolean cargo;
	private String update;
	
	
	public Funcionario() {
		
	}


	public Funcionario(String nome, String rg, String cpf, String contato, boolean cargo, String update) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.contato = contato;
		this.cargo = cargo;
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


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	public boolean isCargo() {
		return cargo;
	}


	public void setCargo(boolean cargo) {
		this.cargo = cargo;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "Funcionario nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", contato=" + contato + ", cargo="
				+ cargo + "";
	}


	


	
	
	
	
	
}
