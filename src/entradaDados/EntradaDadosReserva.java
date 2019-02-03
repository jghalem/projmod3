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
			System.out.println("Digite apenas valores numéricos!");
			return capturarNumero();
		}
	}

	public static Integer capturarAndar() {
		try {
			s = new Scanner(System.in);
			System.out.println("Digite o andar do quarto:");
			int n = s.nextInt();
			if (ValidacaoQuarto.validarAndar(n)) {
				return n;
			} else {
				System.out.println("Digite apenas valores numéricos!");
				return capturarAndar();
			}
		} catch (Exception e) {
			System.out.println("Erro!" + e.getLocalizedMessage());
			e.printStackTrace();
			return capturarAndar();
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