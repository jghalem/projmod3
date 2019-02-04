package execucao;

import java.util.Scanner;

public class ExecutaGeral extends ExecutaLogin {

	public static void main(String[] args) throws Exception {

		principal();

	}

	static void principal() throws Exception {

		Scanner s = new Scanner(System.in);

		System.out.println("Digite o tipo de login: \nGerente - Funcionario");
		String tlogin = s.nextLine();
		tlogin.toLowerCase();

		switch (tlogin) {
		case "gerente":
			if (fazerLoginGerente()) {
				System.out.println("Digite a opção desejada: \nQuarto - Funcionario - Cliente - Reserva - Login");
				String op = s.nextLine();
				op.toLowerCase();

				switch (op) {
				case "quarto":
					ExecutaQuarto.testeMetodos();
					break;
				case "funcionario":
					ExecutaFuncionario.testeMetodos();
					break;
				case "cliente":
					ExecutaCliente.testeMetodos();;
					break;
				case "reserva":
					ExecutaReserva.testeMetodos();
					break;
				case "login":
					testeMetodos();
					break;
				default:
					System.out.println("Escolha uma das opções!\n");
					principal();
					break;
				}
			} else {
				System.out.println("Verifique o tipo de login e tente novamente!");
				fazerLoginGerente();
			}
			break;
		case "funcionario":
			if (fazerLoginFuncionario()) {
				System.out.println("Digite a operação desejada:\n Quarto - Cliente - Reserva");
				String op = s.nextLine();
				op.toLowerCase();

				switch (op) {
				case "quarto":
					ExecutaQuarto.testeMetodos();
					break;
				case "cliente":
					ExecutaCliente.testeMetodos();;
					break;
				case "reserva":
					ExecutaReserva.testeMetodos();
					break;
				default:
					System.out.println("Escolha uma das opções!\n");
					principal();
					break;
				}

			} else {
				System.out.println("Verifique o tipo de login e tente novamente!");
				fazerLoginFuncionario();
			}

			break;
		default:
			break;
		}

	}
}
