package entidade;

public class Quarto {

	private int andarQuarto;
	private int numeroQuarto;
	private boolean dispQuarto;
	private int update;

	public Quarto() {
	}

	public Quarto(int andarQuarto, int numeroQuarto, boolean dispQuarto, int update) {
		this.andarQuarto = andarQuarto;
		this.numeroQuarto = numeroQuarto;
		this.dispQuarto = dispQuarto;
	}

	public int getAndarQuarto() {
		return andarQuarto;
	}

	public void setAndarQuarto(int andarQuarto) {
		this.andarQuarto = andarQuarto;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public boolean isDispQuarto() {
		return dispQuarto;
	}

	public void setDispQuarto(boolean dispQuarto) {
		this.dispQuarto = dispQuarto;
	}

	public int getUpdate() {
		return update;
	}

	public void setUpdate(int update) {
		this.update = update;
	}

	@Override
	public String toString() {
		String disponivel;
		if (dispQuarto){
			disponivel = "Disponível";
		} else {
			disponivel = "Indisponível";
		}
		return " N° Quarto" + numeroQuarto + ", " + andarQuarto + "° Andar, " + disponivel;
	}

}
