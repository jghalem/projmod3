package entidade;

public class Login /* extends Cliente */ {

	private String usuario;
	private String senha;
	private boolean isGerente;
	private int idfuncionario;
	private boolean isLogado;
	private String update;

	public Login() {
	}	

	public Login(String usuario, String senha, boolean isGerente, int idfuncionario) {
		this.usuario = usuario;
		this.senha = senha;
		this.isGerente = isGerente;
		this.idfuncionario = idfuncionario;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isGerente() {
		return isGerente;
	}

	public void setGerente(boolean isGerente) {
		this.isGerente = isGerente;
	}

	public int getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	@Override
	public String toString() {
		String disponivel;
		if (isGerente) {
			disponivel = "Sim";
		} else {
			disponivel = "N�o";
		}

		String logado;
		if (isLogado) {
			logado = "Sim";
		} else {
			logado = "N�o";
		}

		return "Contas Funcion�rios:\n Usuario: " + usuario + "\n Senha: " + senha + "\n Gerente? " + disponivel
				+ " Logado? " + logado;
	}

}
