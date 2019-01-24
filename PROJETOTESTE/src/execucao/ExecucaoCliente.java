package execucao;

import java.util.List;

import entidade.Cliente;
import entradaDados.EntradaDadosCliente;
import persistencia.ClienteDAO;

public class ExecucaoCliente {

	public static void main(String[] args) {

		Cliente c = new Cliente();
		EntradaDadosCliente ec = new EntradaDadosCliente();

		ClienteDAO cd = new ClienteDAO();

		System.out.println("Informe 1 - Cadastro ou 2 - Exclusão");
		Integer opcao = EntradaDadosCliente.capturarCodigo();

		switch (opcao) {
		case 1:
			c.setNome(ec.capturarNome());
			c.setSexo(ec.capturarSexo());
			c.setEmail(ec.capturarEmail());
			try {
				cd.inserir(c);
				System.out.println("Cliente gravado!");
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				List<Cliente> clientes = cd.buscarCliente();
				System.out.println("Clientes:\n");
				for(Cliente cli: clientes){
					System.out.println(cli);
				}
				System.out.println("Informe o cod do cliente a ser excluido");
				cd.excluirCliente(EntradaDadosCliente.capturarCodigo());
				System.out.println("Cliente excluido!");

			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		default:
			break;
		}

	}

}
