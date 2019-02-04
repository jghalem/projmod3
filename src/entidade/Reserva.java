package entidade;

import java.sql.Timestamp;

public class Reserva {

	private int numeroReserva;
	private String cpf;
	private int numeroQuarto;
	private String cpfVendedor;
	private Timestamp checkIn;
	private Timestamp checkOut;
	private int update;

	public Reserva() {
	}

	public Reserva(String cpf, int numeroQuarto, String cpfVendedor, Timestamp checkIn) {
		this.cpf = cpf;
		this.numeroQuarto = numeroQuarto;
		this.cpfVendedor = cpfVendedor;
		this.checkIn = checkIn;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getCpfVendedor() {
		return cpfVendedor;
	}

	public void setCpfVendedor(String cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
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
		return "Reserva [numeroReserva=" + numeroReserva + ", cpf=" + cpf + ", numeroQuarto=" + numeroQuarto
				+ ", cpfVendedor=" + cpfVendedor + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}

}
