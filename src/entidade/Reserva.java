package entidade;

import java.sql.Date;

public class Reserva {

	private int numeroReserva;
	private int idCliente;
	private int numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	public Reserva() {
	}

	public Reserva(int numeroReserva, int idCliente, int numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroReserva = numeroReserva;
		this.idCliente = idCliente;
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
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
		return "Info Reserva\n Numero: " + numeroReserva + "\n ID Cliente: " + idCliente + "\n Numero do Quarto: "
				+ numeroQuarto + "\n Check-In: " + checkIn + "\n Check-Out: + checkOut";
	}

}
