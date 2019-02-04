package execucao;

import java.util.Scanner;

import entidade.Login;
import persistencia.LoginDAO;

public class ExecutaGeral extends ExecutaLogin {

	public static void main(String[] args) throws Exception {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite a operação desejada: \nQuarto - Funcionario - Cliente - Reserva - Login");
		String op = s.nextLine();
		String teste = op.toLowerCase();

		switch (teste) {
		case "quarto":
			if (ld.buscarLogados()) {
				ExecutaQuarto.testeMetodos();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "funcionario":
			if (ld.buscarLogados()) {
				//ExecutaFuncionario.testeMetodos();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "cliente":
			if (ld.buscarLogados()) {
				//ExecutaCliente.testeMetodos();;
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "reserva":
			if (ld.buscarLogados()) {
				ExecutaReserva.testeMetodos();;
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "login":
				testeMetodos();
			break;
		default:
			System.out.println("Escolha uma das quatro opções!\n");
			break;
		}
	}

}
