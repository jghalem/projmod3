package entidade;

import java.sql.Timestamp;

public class Reserva {

	private int numeroReserva;
	private int idlogin;
	private int numeroQuarto;
	private int idCliente;
	private Timestamp checkIn;
	private Timestamp checkOut;
	private int update;

	public Reserva() {
	}

	public Reserva(int numeroReserva, int idlogin, int numeroQuarto, int idCliente, Timestamp checkIn) {
		this.numeroReserva = numeroReserva;
		this.idlogin = idlogin;
		this.numeroQuarto = numeroQuarto;
		this.idCliente = idCliente;
		this.checkIn = checkIn;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public int getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public int getUpdate() {
		return update;
	}

	public void setUpdate(int update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "Reserva [numeroReserva=" + numeroReserva + ", idlogin=" + idlogin + ", numeroQuarto=" + numeroQuarto
				+ ", idCliente=" + idCliente + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", update=" + update
				+ "]";
	}
}
