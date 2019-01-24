package entradaDados;

import java.util.Scanner;
import validacao.validacaoCliente;


public class entradaDadosCliente {

	

		private validacaoCliente validacao;

		public entradaDadosCliente() {
			validacao = new validacaoCliente();
		}

		
		
		public String capturarcpf() {

			System.out.println("informe o cpf ");
			Scanner ler = new Scanner(System.in);
			String cpf = ler.nextLine();
			if (validacao.verificarcpf(cpf)) {
				return cpf;
			} else {
				System.out.println("erro! cpf invalido");
				return capturarcpf();
			}
		}
		
		public String capturarNome() {

			System.out.println("informe o nome ");
			Scanner ler1 = new Scanner(System.in);
			String nome = ler1.nextLine();
			if (validacao.verificarNome(nome)) {
				return nome;
			} else {
				System.out.println("erro! nome invalido");
				return capturarNome();
			}
		}
		
		public String capturarEmail() {

			System.out.println("informe o seu email ");
			Scanner ler2 = new Scanner(System.in);
			String email = ler2.nextLine();
			if (validacao.verificarEmail(email)) {
				return email;
			} else {
				System.out.println("erro!email invalido");
				return capturarEmail();
			}
		}
	
		
	
		public String capturarContato() {

			System.out.println("informe o seu salario");
			Scanner ler3 = new Scanner(System.in);
			String Contato = ler3.nextLine();
			if (validacao.verificarContato(Contato)) {
				return Contato;
			} else {
				System.out.println("erro! contato invalido ");
				return capturarContato();
			}
		}
	    


	}


