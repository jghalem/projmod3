package execucao;

import java.util.Scanner;
import java.util.List;
import entidade.Cliente;
import entradaDados.entradaDadosCliente;
import persistencia.clienteDAO;

public class ExecutaCliente {

	public static void testeMetodos() {
		Cliente c = new Cliente();
		entradaDadosCliente ec = new entradaDadosCliente();

		clienteDAO cd = new clienteDAO();

		System.out.println(
				"-- Cliente --\nDigite o que deseja fazer:\n1- Criar | 2- Visualizar | 3- Atualizar | 4- Apagar");
		Scanner ler = new Scanner(System.in);
		String opcao = ler.nextLine();

		switch (opcao) {
		case "1":
			c.setNome(ec.capturarnome());
			c.setCpf(entradaDadosCliente.capturarcpf());
			c.setRg(ec.capturarrg());
			c.setTelefone(ec.capturartelefone());

			try {
				cd.inserir(c);
				System.out.println("cliente gravado...");
				ExecutaGeral.principal();
			} catch (Exception e) {
				System.out.println("erro" + e.getMessage());
				e.printStackTrace();// imprime linha onde está o erro
			}
			break;

		case "4":
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o cpf do cliente que deseja exluir:");
				String vis = s.nextLine();

				System.out.println("cliente cadastrado: ");
				System.out.println(cd.buscarClienteEspecifico(vis));

				System.out.println("Insira novamente o cpf para confirmar exclusão");
				cd.excluir(entradaDadosCliente.capturarcpf());
				System.out.println("cliente excluído");
				ExecutaGeral.principal();
			} catch (Exception e) {
				System.out.println("erro" + e.getMessage());
				e.printStackTrace(); // imprime linha onde está o erro
			}
			break;

		case "3":
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o cpf do cliente que deseja alterar:");
				String vis = s.nextLine();

				List<Cliente> Clientes = cd.buscarClienteEspecifico(vis);
				for (Cliente cli : Clientes) {
					System.out.println(cli.toString());
				}

				c.setUpdate(vis);
				c.setNome(ec.capturarnome());
				c.setRg(ec.capturarrg());
				c.setCpf(entradaDadosCliente.capturarcpf());
				c.setTelefone(ec.capturartelefone());
				System.out.println(cd.buscarClienteEspecifico(vis));
				System.out.println(c);
				System.out.println(cd.atualizar(c));
				ExecutaGeral.principal();

			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
			break;

		case "2":
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Deseja visualizar todos os clientes? (Digite '0')");
				Integer vis = s.nextInt();
				if (vis == 0) {
					List<Cliente> clientes = cd.buscarCliente();
					System.out.println("Clientes:\n");
					for (Cliente cli : clientes) {
						System.out.println(cli);
					}
					ExecutaGeral.principal();
				}

				else {

					List<Cliente> clientes = cd.visuCliente(vis);
					for (Cliente cli : clientes) {
						System.out.println(cli);
					}
					ExecutaGeral.principal();
				}
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}

		default:
			System.out.println("Digite uma das quatro opções!");
			ExecutaCliente.testeMetodos();
		}
	}

}
