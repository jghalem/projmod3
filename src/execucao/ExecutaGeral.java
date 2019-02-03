package execucao;

public class ExecutaGeral extends ExecutaLogin {

	public static void main(String[] args) throws Exception {

		System.out.println("Digite a operação desejada: \nQuarto - Funcionario - Cliente - Reserva - Login");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "quarto":
			if (ld.buscarIsLogado(l.getUsuario())) {
				ExecutaQuarto.testeMetodos();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "funcionario":
			if (ld.buscarIsLogado(l.getUsuario())) {
				//ExecutaFuncionario.testeMetodos();
				;
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "cliente":
			if (ld.buscarIsLogado(l.getUsuario())) {
				//ExecutaCliente.testeMetodos();;
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "reserva":
			if (ld.buscarIsLogado(l.getUsuario())) {
				ExecutaReserva.testeMetodos();;
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		case "login":
			if (ld.buscarIsLogado(l.getUsuario())) {
				testeMetodos();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				fazerLogin();
			}
			break;
		default:
			System.out.println("Escolha uma das quatro opções!\n");
			testeMetodos();
			break;
		}
	}

}
