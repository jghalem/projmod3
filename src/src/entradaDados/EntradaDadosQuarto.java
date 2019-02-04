package entradaDados;

import java.util.Scanner;
import validacao.ValidacaoQuarto;

public class EntradaDadosQuarto {

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
		try {
			s = new Scanner(System.in);
			System.out.println("Digite a disponibilidade do quarto: (S / N)");
			String n = s.nextLine();
			n.toLowerCase();
			String s = "s";
			if (n.equals(s)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro!" + e.getLocalizedMessage());
			e.printStackTrace();
			return capturarDisponibilidade();
		}
	}

}
