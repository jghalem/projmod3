package execucao;

import java.util.List;
import java.util.Scanner;

import entidade.Reserva;
import entradaDados.EntradaDadosReserva;
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
			r.setIdlogin(EntradaDadosReserva.capturarVendedor());
			r.setIdCliente(EntradaDadosReserva.capturarId());
			r.setCheckIn(EntradaDadosReserva.capturarDiaHora());

			if (rd.inserir(r)) {
				System.out.println("Reserva cadastrada com sucesso!");
				ExecutaGeral.principal();

			} else {
				System.out.println("Erro ao cadastrar reserva");
				criarReserva();
			}

		}  catch (Exception inputException) {
			System.out.println("Digite apenas caracteres permitidos!");
			criarReserva();
		}
	}

	public static void visualizarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o número da reserva que deseja visualizar:");
			Integer vis = s.nextInt();
			List<Reserva> reservas = rd.buscarReservaEspecifica(vis);
			for (Reserva res : reservas) {
				System.out.println(res);
			}
			ExecutaGeral.principal();
		} catch (Exception inputException) {
			System.out.println("Digite apenas caracteres permitidos!");
			visualizarReserva();
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
			r.setIdlogin(EntradaDadosReserva.capturarVendedor());
			r.setIdCliente(EntradaDadosReserva.capturarId());
			r.setCheckIn(EntradaDadosReserva.capturarDiaHora());
			r.setUpdate(vis);

			if (rd.atualizarReserva(r)) {
				System.out.println("Reserva atualizada com sucesso!");
				ExecutaGeral.principal();
			} else {
				System.out.println("Erro ao atualizar reserva!");
				atualizarReserva();
			}

		} catch (Exception inputException) {
			System.out.println("Digite apenas caracteres permitidos!");
			atualizarReserva();
		}
	}

	public static void apagarReserva() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o numero do quarto que deseja apagar:");
			Integer vis = s.nextInt();

			if (rd.excluirReserva(vis)) {
				System.out.println("Reserva excluida com sucesso!");
				ExecutaGeral.principal();
			} else {
				System.out.println("Erro ao excluir reserva!");
				apagarReserva();
			}	

		} catch (Exception inputException) {
			System.out.println("Digite apenas números!");
			apagarReserva();
		}
	}
	
	public static void fazerCheckOut() {

		rd = new ReservaDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o numero da reserva para fazer Checkout:");
			Integer vis = s.nextInt();

			if (rd.checkout(vis)) {
				System.out.println("Checkout realizado com sucesso!");
				ExecutaGeral.principal();
			} else {
				System.out.println("Erro ao fazer checkout!");
				fazerCheckOut();
			}	

		} catch (Exception inputException) {
			System.out.println("Digite apenas números!");
			apagarReserva();
		}
	}

	public static void testeMetodos() throws Exception {

		r = new Reserva();
		rd = new ReservaDAO();
		s = new Scanner(System.in);

		System.out.println(
				"-- Reservas --\nDigite a operação desejada:\n1- Criar | 2- Visualizar | 3- Atualizar | 4- Apagar | 5- Checkout");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "1":
			criarReserva();
			break;
		case "2":
			visualizarReserva();
			break;
		case "3":
			atualizarReserva();
			break;
		case "4":
			apagarReserva();
			break;
		case "5":
			fazerCheckOut();
			break;
		default:
			System.out.println("Escolha uma das quatro opções!");
			testeMetodos();
			break;
		}

	}
}
