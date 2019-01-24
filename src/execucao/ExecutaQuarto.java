package execucao;

import entidade.Quarto;
import entradaDados.EntradaDadosQuarto;

public class ExecutaQuarto {	
	
	private static Quarto q;
	
	public static void main(String[] args) {
			q = new Quarto();
			q.setNumeroQuarto(EntradaDadosQuarto.capturarNumero());
			q.setAndarQuarto(EntradaDadosQuarto.capturarAndar());
			q.setDispQuarto(false);
			
			System.out.println(q);
	}
	
}
