package execucao;

import java.util.List;
import java.util.Scanner;

import entidade.Login;
import entidade.Quarto;
import entidade.Reserva;
//import entidade.Cliente;
import entradaDados.EntradaDadosReserva;
import persistencia.LoginDAO;
import persistencia.ReservaDAO;

public class ExecutaReserva {

	private static Quarto q;
	private static Reserva r;
	private static ReservaDAO rd;
	private static Scanner s;
	private static LoginDAO ld;
	private static Login l;

	public static void criarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			r.setNumeroQuarto(EntradaDadosReserva.capturarNumero());
			r.setAndarQuarto(EntradaDadosReserva.capturarAndar());
			q.setDispQuarto(false);
			r.setCheckIn(EntradaDadosReserva.capturarDiaHora());

			// TODO: Terminar executareserva, entradadadosreserva, checar reservadao e
			// corrigir erros do presente arquivo.

			rd.inserir(r);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void visualizarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Deseja visualizar os quartos de que andar? (Digite '0' para todos)");
			Integer vis = s.nextInt();
			if (vis == 0) {
				List<Reserva> reservas = rd.buscarReserva();
				System.out.println("Quartos:\n");
				for (Reserva res : reservas) {
					System.out.println(res);
				}
			} else {
				List<Reserva> reservas = rd.buscarReservaEspecifica(vis);
				for (Reserva res : reservas) {
					System.out.println(res);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void atualizarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o numero da reserva que deseja alterar:");
			Integer vis = s.nextInt();

			List<Reserva> quartos = rd.buscarReservaEspecifica(vis);
			for (Reserva res : quartos) {
				System.out.println(res);
			}

			q.setNumeroQuarto(EntradaDadosReserva.capturarNumero());
			q.setAndarQuarto(EntradaDadosReserva.capturarAndar());
			q.setDispQuarto(EntradaDadosReserva.capturarDisponibilidade());
			q.setUpdate(vis);
			System.out.println(rd.atualizarReserva(r));

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void apagarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o numero do quarto que deseja apagar:");
			Integer vis = s.nextInt();

			rd.excluirReserva(vis);

		} catch (Exception inputException) {
			System.out.println("Digite apenas números!");
		}
	}

	public static void testeMetodos() throws Exception {

		r = new Reserva();
		rd = new ReservaDAO();
		s = new Scanner(System.in);

		System.out.println("Digite a operação desejada: \nCriar - Visualizar - Atualizar - Apagar");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "criar":
			if (ld.buscarIsLogado(l.getUsuario())) {
				criarReserva();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				ExecutaLogin.fazerLogin();
			}
			break;
		case "visualizar":
			if (ld.buscarIsLogado(l.getUsuario())) {
				visualizarReserva();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				ExecutaLogin.fazerLogin();
			}
			break;
		case "atualizar":
			if (ld.buscarIsLogado(l.getUsuario())) {
				atualizarReserva();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				ExecutaLogin.fazerLogin();
			}
			break;
		case "apagar":
			if (ld.buscarIsLogado(l.getUsuario())) {
				apagarReserva();
			} else {
				System.out.println("Faça login para poder acessar as opções!");
				ExecutaLogin.fazerLogin();
			}
			break;
		default:
			System.out.println("Escolha uma das quatro opções!");
			testeMetodos();
			break;
		}

	}
}
