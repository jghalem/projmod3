package execucao;

import java.util.List;
import java.util.Scanner;

import entidade.Quarto;
import entradaDados.EntradaDadosQuarto;
import persistencia.QuartoDAO;

public class ExecutaQuarto {

	private static Quarto q;
	private static QuartoDAO qd;
	private static Scanner s;

	public static void main(String[] args) {
		q = new Quarto();
		qd = new QuartoDAO();
		s = new Scanner(System.in);

		System.out.println("Digite a operação desejada: \nCriar - Visualizar - Atualizar - Apagar");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "criar":
			criarQuarto();
			break;
		case "visualizar":
			visualizarQuarto();
			break;
		case "atualizar":
			atualizarQuarto();
			break;
		case "apagar":
			apagarQuarto();
			break;
		default:
			System.out.println("Escolha uma das quatro opções!");
			break;
		}
	}

	public static void criarQuarto() {
		try {
			q.setNumeroQuarto(EntradaDadosQuarto.capturarNumero());
			q.setAndarQuarto(EntradaDadosQuarto.capturarAndar());
			q.setDispQuarto(EntradaDadosQuarto.capturarDisponibilidade());

			if (qd.inserir(q)) {
				System.out.println("Quarto Gravado!");
				System.out.println(q);
			} else {
				System.out.println("Erro ao gravar quarto!");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void visualizarQuarto() {
		try {
			System.out.println("Deseja visualizar os quartos de que andar? (Digite '0' para todos)");
			Integer vis = s.nextInt();
			if (vis == 0) {
				List<Quarto> quartos = qd.buscarQuarto();
				System.out.println("Quartos:\n");
				for (Quarto qua : quartos) {
					System.out.println(qua);
				}
			} else {
				List<Quarto> quartos = qd.buscarAndarEspecifico(vis);
				for (Quarto qua : quartos) {
					System.out.println(qua);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void atualizarQuarto() {
		try {
			System.out.println("Digite o numero do quarto que deseja alterar:");
			Integer vis = s.nextInt();

			List<Quarto> quartos = qd.buscarQuartoEspecifico(vis);
			for (Quarto qua : quartos) {
				System.out.println(qua);
			}

			q.setNumeroQuarto(EntradaDadosQuarto.capturarNumero());
			q.setAndarQuarto(EntradaDadosQuarto.capturarAndar());
			q.setDispQuarto(EntradaDadosQuarto.capturarDisponibilidade());
			q.setUpdate(vis);
			System.out.println(qd.atualizarQuarto(q));

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void apagarQuarto() {
		try {
			System.out.println("Digite o numero do quarto que deseja apagar:");
			Integer vis = s.nextInt();

			System.out.println(qd.excluirQuarto(vis));

		} catch (Exception inputException) {
			System.out.println("Digite apenas números!");
		}
	}
}
