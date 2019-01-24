package execucao;

import entidade.Quarto;
import entidade.Cliente

import entradaDados.EntradaDadosReserva;

public class ExecutaReserva {	
	
	private static Reserva q;
	
	public static void main(String[] args) {
			q = new Quarto();
			q.setNumeroQuarto(EntradaDadosQuarto.capturarNumero());
			q.setAndarQuarto(EntradaDadosQuarto.capturarAndar());
			q.setDispQuarto(false);
			
			System.out.println(q);
	}
	
}
