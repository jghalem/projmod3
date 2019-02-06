package entradaDados;

import java.util.Scanner;
import java.time.Instant;

import validacao.ValidacaoQuarto;

public class EntradaDadosReserva {

	private static Scanner s;

	public static Integer capturarNumero() {
		s = new Scanner(System.in);
		System.out.println("Digite o numero do quarto:");
		int n = s.nextInt();
		if (ValidacaoQuarto.validarQuarto(n)) {
			return n;
		} else {
			System.out.println("Digite apenas números!");
			return capturarNumero();
		}
	}

	public static Integer capturarVendedor() {
		try {
			s = new Scanner(System.in);
			System.out.println("Digite o id do login:");
			int n = s.nextInt();
			return n;

		} catch (Exception e) {
			System.out.println("Digite apenas números!");
			return capturarVendedor();
		}
	}

	public static Integer capturarId() {
		try {
			s = new Scanner(System.in);
			System.out.println("Digite o id do cliente:");
			int n = s.nextInt();
			return n;
		} catch (Exception e) {
			System.out.println("Digite apenas números!");
			return capturarId();
		}

	}

	public static Boolean capturarDisponibilidade() {
		return false;
	}

	public static java.sql.Timestamp capturarDiaHora() {
		Instant instantAgora = Instant.now();
		java.sql.Timestamp timestampAgora = java.sql.Timestamp.from(instantAgora);
		return timestampAgora;
	}

}