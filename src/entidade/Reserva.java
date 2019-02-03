package entidade;

import java.sql.Timestamp;

public class Reserva {

	private int numeroReserva;
	private int cpf;
	private int numeroQuarto;
	private int andarQuarto;
	private Timestamp checkIn;
	private Timestamp checkOut;

	public Reserva() {
	}

	public Reserva(int numeroReserva, int cpf, int numeroQuarto, int andarQuarto, Timestamp checkIn) {
		this.numeroReserva = numeroReserva;
		this.cpf = cpf;
		this.numeroQuarto = numeroQuarto;
		this.andarQuarto = andarQuarto;
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

	public Timestamp getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Info Reserva\n Numero: " + numeroReserva + "\n CPF Cliente: " + cpf + "\n Numero do Quarto: "
				+ numeroQuarto + "\n Check-In: " + checkIn + "\n Check-Out: + checkOut";
	}

}
