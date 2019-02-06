package execucao;

import java.util.Scanner;

public class ExecutaGeral extends ExecutaLogin {

	public static void main(String[] args) throws Exception {
		principal();
	}

	static void principal() throws Exception {

		Scanner s = new Scanner(System.in);

		System.out.println("\n-- Acesso Recepção --\nComo deseja acessar?\n1 - Gerente | 2 - Funcionario");
		String tlogin = s.nextLine();
		tlogin.toLowerCase();

		switch (tlogin) {
		case "1":
			if (ExecutaLogin.fazerLoginGerente()) {
				principalGerente();
			} else {
				System.out.println("Verifique o tipo de login e tente novamente!");
				fazerLoginFuncionario();
			}
			break;

		case "2":
			if (ExecutaLogin.fazerLoginFuncionario()) {
				principalFuncionario();
			} else {
				System.out.println("Verifique o tipo de login e tente novamente!");
				fazerLoginFuncionario();
			}
			break;
		default:
			System.out.println("Escolha uma opção!");
			principal();
			break;
		}
	}

	public static void principalGerente() throws Exception {

		System.out.println(
				"-- Menu Gerente --\nDigite a opção desejada: \n1- Quarto | 2- Cliente | 3- Reserva | 4- Funcionario | 5- Acesso | 6- Logout");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "1":
			ExecutaQuarto.testeMetodos();
			break;
		case "2":
			ExecutaCliente.testeMetodos();
			;
			break;
		case "3":
			ExecutaReserva.testeMetodos();
			break;
		case "4":
			ExecutaFuncionario.testeMetodos();
			break;
		case "5":
			testeMetodos();
			break;
		case "6":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Deslogado!");
			principal();
			break;
		default:
			System.out.println("Escolha uma das opções!\n");
			principal();
			break;
		}

	}

	public static void principalFuncionario() throws Exception {

		System.out.println(
				"-- Menu Recepção --\nDigite a operação desejada:\n1- Quarto | 2- Cliente | 3- Reserva | 4- Logout");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "1":
			ExecutaQuarto.testeMetodos();
			break;
		case "2":
			ExecutaCliente.testeMetodos();
			;
			break;
		case "3":
			ExecutaReserva.testeMetodos();
			break;
		case "4":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Deslogado!");
			principal();
			break;
		default:
			System.out.println("Escolha uma das opções!\n");
			principal();
			break;
		}

	}
}
