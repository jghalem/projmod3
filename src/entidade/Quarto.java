package entidade;

public class Quarto {

	private int andarQuarto;
	private int numeroQuarto;
	private boolean dispQuarto;

	public Quarto() {
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

	@Override
	public String toString() {
		String disponivel;
		if (dispQuarto){
			disponivel = "Sim";
		} else {
			disponivel = "Não";
		}
		return "Info Quarto\n Andar: " + andarQuarto + "\n Número: " + numeroQuarto + "\n Disponivel? " + disponivel;
	}

}
