package execucao;

import java.util.Scanner;
import java.util.List;
import entidade.Cliente;
import entradaDados.entradaDadosCliente;
import persistencia.clienteDAO;

public class executaCliente {
	public static void main(String[] args) {

			
				Cliente c = new Cliente();
				entradaDadosCliente ec = new entradaDadosCliente();
				
				clienteDAO cd = new clienteDAO();
				
				System.out.println("informe: 1 - para cadastro / 2 - para excluir/ 3 - para atualizar/ 4 - para visualizar");
				//Integer opcao = entradaDadosCliente.capturarcpf();
				Scanner ler = new Scanner(System.in);
				String opcao = ler.nextLine();
				
					
				
				switch(opcao){
				case "1":
					c.setNome(ec.capturarnome());
					c.setCpf(entradaDadosCliente.capturarcpf());
					c.setRg(ec.capturarrg());
					c.setTelefone(ec.capturartelefone());
					
					
					try{
						cd.inserir(c);
						System.out.println("cliente gravado...");
					}catch(Exception e){
						System.out.println("erro" +e.getMessage());
						e.printStackTrace();// imprime linha onde está o erro
					
					}
					break;
				
				case "2":
					try{
						//antes de excluir, vamos listar...
						entradaDadosCliente ecccc = new entradaDadosCliente();
						Scanner s = new Scanner(System.in);
						System.out.println("Digite o cpf do cliente que deseja exluir:");
						String vis = s.nextLine();
						
						List<Cliente> Clientes = cd.buscarCliente();
						System.out.println("cliente cadastrado: ");
							System.out.println(cd.buscarClienteEspecifico(vis));
						
					
					System.out.println("insira o cpf para confirmar exclusão");
					cd.excluir(entradaDadosCliente.capturarcpf());
					System.out.println("cliente excluído");
					}catch(Exception e){
						System.out.println("erro" +e.getMessage());
						e.printStackTrace(); //imprime linha onde está o erro
					}
					break;
					
				case "3":
					try {
						entradaDadosCliente ecc = new entradaDadosCliente();
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
				
						
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}
				break;
				
				case "4":
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
						}
						
						else {
							
							List<Cliente> clientes = cd.visuCliente(vis);
							for (Cliente cli : clientes) {
								System.out.println(cli);
							}
						}
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}
				
				default:
					System.out.println("Digite uma das quatro opções!");
					
				}

				
				
				/* c.setCodigo(ec.capturarCodigo());
				c.setNome(ec.capturarnome());
				c.setCpf(entradaDadosCliente.capturarcpf());
				c.setRg(ec.capturarrg());
				c.setTelefone(ec.capturartelefone());*/
			
				/*try {
					cd.inserir(c);
					System.out.println("gravado com sucesso");
				} catch (Exception e) {
					System.out.println("erro ao gravar");
					// TODO: handle exception
				}*/
			}

}
