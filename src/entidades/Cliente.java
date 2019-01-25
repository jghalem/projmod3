package entidades;

public class Cliente {

	private String nome;
	private Integer rg;
	private Integer cpf;
	private Integer telefone;
	private Integer numeroReserva;
	
	public Cliente() {
		
	}


	public Cliente(String nome, Integer rg, Integer cpf, Integer telefone, Integer numeroReserva ) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.numeroReserva = numeroReserva;
	}


	public String getnome() {
		return nome;
	}


	public void setnome(String nome) {
		this.nome = nome;
	}


	public Integer getrg() {
		return rg;
	}


	public void setrg(Integer rg) {
		this.rg = rg;
	}


	public Integer getcpf() {
		return cpf;
	}


	public void setcpf(Integer cpf) {
		this.cpf = cpf;
	}


	public Integer gettelefone() {
		return telefone;
	}


	public void settelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Integer getnumeroReserva(){
		return numeroReserva;
	}
	
	public void setnumeroReserva(Integer numeroReserva)
	    this.numeroReserva = numeroReserva;
    }

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", telefone=" + telefone + ","
				+ "numeroReserva=" + numeroReserva + "]";
	}


	
	
	
	
}
