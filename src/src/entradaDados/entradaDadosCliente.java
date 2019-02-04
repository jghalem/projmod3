package entradaDados;

import java.util.Scanner;
import validacao.validacaoCliente;


public class entradaDadosCliente {

	

		private static validacaoCliente validacao;

		public entradaDadosCliente() {
			validacao = new validacaoCliente();
		}

		
		
		public String capturarnome() {

			System.out.println("informe o nome ");
			Scanner ler = new Scanner(System.in);
			String nome = ler.nextLine();
			if (validacao.verificarnome(nome)) {
				return nome;
			} else {
				System.out.println("erro! nome invalido");
				return capturarnome();

			}
		}
		
		public String capturarrg() {

			System.out.println("informe o rg ");
			Scanner ler1 = new Scanner(System.in);
			String rg = ler1.nextLine();
			if (validacao.verificarrg(rg)) {
				return rg;
			} else {
				System.out.println("erro! rg invalido");
				return capturarrg();
			}
			
		}
		
		public static String capturarcpf() {

			System.out.println("informe o cpf ");
			Scanner ler2 = new Scanner(System.in);
			String cpf = ler2.nextLine();
			if (validacao.verificarcpf(cpf)) {
				return cpf;
			} else {
				System.out.println("erro!cpf invalido");
				return capturarcpf();
			}
		}
	
		
	
		public String capturartelefone() {

			System.out.println("informe o telefone");
			Scanner ler3 = new Scanner(System.in);
			String telefone = ler3.nextLine();
			if (validacao.verificartelefone(telefone)) {
				return telefone;
			} else {
				System.out.println("erro! telefone invalido ");
				return capturartelefone();
			}
		}
	 


	}


