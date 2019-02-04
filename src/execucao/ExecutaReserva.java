package execucao;

import java.util.List;
import java.util.Scanner;

import entidade.Reserva;
import entradaDados.EntradaDadosReserva;
import entradaDados.entradaDadosCliente;
import persistencia.ReservaDAO;

public class ExecutaReserva {

	private static Reserva r;
	private static ReservaDAO rd;
	private static Scanner s;

	public static void criarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);
		r = new Reserva();

		try {
			r.setNumeroQuarto(EntradaDadosReserva.capturarNumero());
			r.setCpfVendedor(EntradaDadosReserva.capturarVendedor());
			r.setCheckIn(EntradaDadosReserva.capturarDiaHora());
			r.setCpf(entradaDadosCliente.capturarcpf());

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

			r.setNumeroQuarto(EntradaDadosReserva.capturarNumero());
			r.setCpfVendedor(EntradaDadosReserva.capturarVendedor());
			r.setCheckIn(EntradaDadosReserva.capturarDiaHora());
			r.setCpf(entradaDadosCliente.capturarcpf());
			r.setUpdate(vis);
			
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
				criarReserva();
			break;
		case "visualizar":
				visualizarReserva();
			break;
		case "atualizar":
				atualizarReserva();
			break;
		case "apagar":
				apagarReserva();
			break;
		default:
			System.out.println("Escolha uma das quatro opções!");
			testeMetodos();
			break;
		}

	}
}
