package entidade;

import java.sql.Date;

public class Reserva {

	private int numeroReserva;
	private int cpf;
	private int numeroQuarto;
	private int andarQuarto;
	private Date checkIn;
	private Date checkOut;

	public Reserva() {
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getAndarQuarto() {
		return andarQuarto;
	}

	public void setAndarQuarto(int andarQuarto) {
		this.andarQuarto = andarQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Info Reserva\n Numero: " + numeroReserva + "\n CPF Cliente: " + cpf + "\n Numero do Quarto: "
				+ numeroQuarto + "\n Check-In: " + checkIn + "\n Check-Out: + checkOut";
	}

}
