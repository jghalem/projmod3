package entradaDados;

import java.util.Scanner;

public class EntradaDadosReserva {
	
	private static Scanner s;
	
	public static Integer capturarNumero() {
		s = new Scanner(System.in);
		try {
			System.out.println("Digite o numero do quarto:");
			int n = s.nextInt();
			return n;
		} catch (Exception e) {
			System.out.println("Erro: Digite apenas valores numéricos!");
			return capturarNumero();
		}
	}
	
	public static Integer capturarAndar() {
		s = new Scanner(System.in);
		try {
			System.out.println("Digite o andar do quarto:");
			int n = s.nextInt();
			return n;
		} catch (Exception e) {
			System.out.println("Erro: Digite apenas valores numéricos!");
			return capturarAndar();
		}
	}
	
}
