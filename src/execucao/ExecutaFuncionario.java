package execucao;

import java.util.Scanner;
import java.util.List;

import entidade.Funcionario;
import entradaDados.entradaDadosFuncionario;
import persistencia.funcionarioDAO;

public class ExecutaFuncionario {

	public static void testeMetodos() {
		Funcionario c = new Funcionario();
		entradaDadosFuncionario ec = new entradaDadosFuncionario();

		funcionarioDAO cd = new funcionarioDAO();

		System.out.println("informe 1 - para cadastro / 2 - para excluir/ 3 - para atualizar/ 4 - para visualizar");
		Scanner ler = new Scanner(System.in);
		String opcao = ler.nextLine();

		switch (opcao) {
		case "1":
			c.setNome(ec.capturarnome());
			c.setCpf(entradaDadosFuncionario.capturarcpf());
			c.setRg(ec.capturarrg());
			c.setContato(ec.capturarcontato());
			c.setCargo(ec.capturarCargo());

			try {
				cd.inserir(c);
				System.out.println("empregado agora está gravado...");
				ExecutaGeral.principal();
			} catch (Exception e) {
				System.out.println("erro" + e.getMessage());
				e.printStackTrace();// imprime linha onde está o erro

			}
			break;

		case "2":
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o cpf do empregado que deseja exluir:");
				String vis = s.nextLine();

				List<Funcionario> funcionarios = cd.buscarFuncionario();
				System.out.println("empregado cadastrado: ");
				System.out.println(cd.buscarFuncionarioEspecifico(vis));

				System.out.println("insira o cpf para confirmar exclusão");
				cd.excluir(entradaDadosFuncionario.capturarcpf());
				System.out.println("empregado excluído");
				ExecutaGeral.principal();
			} catch (Exception e) {
				System.out.println("erro" + e.getMessage());
				e.printStackTrace(); // imprime linha onde está o erro
			}
			break;

		case "3":
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o cpf do empregado que deseja alterar:");
				String vis = s.nextLine();

				List<Funcionario> funcionarios = cd.buscarFuncionarioEspecifico(vis);
				for (Funcionario fun : funcionarios) {
					System.out.println(fun.toString());
				}

				c.setUpdate(vis);
				c.setNome(ec.capturarnome());
				c.setRg(ec.capturarrg());
				c.setCpf(entradaDadosFuncionario.capturarcpf());
				c.setContato(ec.capturarcontato());
				c.setCargo(ec.capturarCargo());
				System.out.println(cd.buscarFuncionarioEspecifico(vis));
				System.out.println(c);
				System.out.println(cd.atualizar(c));

				ExecutaGeral.principal();

			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
			break;

		case "4":
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Deseja visualizar todos os funcionarios? (Digite '0')");
				Integer vis = s.nextInt();
				if (vis == 0) {
					List<Funcionario> funcionarios = cd.buscarFuncionario();
					System.out.println("Funcionarios:\n");
					for (Funcionario fun : funcionarios) {
						System.out.println(fun);
					}
					ExecutaGeral.principal();
				}

				else {

					List<Funcionario> funcionarios = cd.visuFuncionario(vis);
					for (Funcionario fun : funcionarios) {
						System.out.println(fun);
					}
					ExecutaGeral.principal();
				}
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		default:
			System.out.println("Digite uma das quatro opções!");
			ExecutaFuncionario.testeMetodos();
		}
	}
}
