package execucao;

import java.util.List;
import entidades.Cliente;
import 

public class executaCliente {
	public static void main(String[] args) {

			
				Cliente c = new Cliente();
				entradaDadosCliente ec = new entradaDadosCliente();
				
				ClienteDAO cd = new ClienteDAO();
				
				System.out.println("informe 1 - para cadastro / 2 - para excluir");
				Integer opcao = entreDadosCliente.capturarCodigo();
				
				switch(opcao){
				case 1:
					c.setNome(ec.capturarNome());
					c.setSexo(ec.capturarSexo());
					c.setEmail(ec.capturarEmail());
					try{
						cd.inserir(c);
						System.out.println("cliente gravado...");
					}catch(Exception e){
						System.out.println("erro" +e.getMessage());
						e.printStackTrace();// imprime linha onde está o erro
					
					}
					break;
				
				case 2:
					try{
						//antes de excluir, vamos listar...
						List<Cliente> Clientes = cd.buscarCliente();
						System.out.println("clientes cadastrados -----");
						for(Cliente Cli : Clientes){
							System.out.println("cli");
						}
					System.out.println("informe o codigo para exclusão");
					cd.excluir(entreDadosCliente.capturarCodigo());
					System.out.println("cliente excluído");
					}catch(Exception e){
						System.out.println("erro" +e.getMessage());
						e.printStackTrace(); //imprime linha onde está o erro
					}
					}
				

				// c.setCodigo(ec.capturarCodigo());
				c.setNome(ec.capturarNome());
				c.setSexo(ec.capturarSexo());
				c.setEmail(ec.capturarEmail());
				try {
					cd.inserir(c);
					System.out.println("gravado com sucesso");
				} catch (Exception e) {
					System.out.println("erro ao gravar");
					// TODO: handle exception
				}
			}

}
}