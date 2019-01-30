package execucao;

import java.sql.Date;

import entidade.Quarto;
import entidade.Reserva;
//import entidade.Cliente;
import entradaDados.EntradaDadosQuarto;
import entradaDados.EntradaDadosReserva;

public class ExecutaReserva {

	private static Reserva r;
	private static Quarto q;
	
	public String fazerCheckIn() {
			r = new Reserva();
			r.setNumeroQuarto(EntradaDadosQuarto.capturarNumero());
			r.setAndarQuarto(EntradaDadosQuarto.capturarAndar());
			q.setDispQuarto(false);
			
			System.out.println(q);
			return null;
			//TODO: corrigir metodo
	}
}
