package entradaDados;

import java.util.Scanner;
import validacao.validacaoCliente;


public class entradaDadosCliente {

	

		private validacaoCliente validacao;

		public entradaDadosCliente() {
			validacao = new validacaoCliente();
		}

		
		
		public String capturarnome() {

			System.out.println("informe o nome ");
			Scanner nome = new Scanner(System.in);
			String nome = ler.nextLine();
			if (validacao.verificarnome(nome)) {
				return nome;
			} else {
				System.out.println("erro! nome invalido");
				return capturarnome();
			}
		}
		
		public Integer capturarrg() {

			System.out.println("informe o rg ");
			Scanner ler1 = new Scanner(System.in);
			Integer rg = ler1.nextLine();
			if (validacao.verificarrg(rg)) {
				return rg;
			} else {
				System.out.println("erro! rg invalido");
				return capturarrg();
			}
		}
		
		public Integer capturarcpf() {

			System.out.println("informe o cpf ");
			Scanner ler2 = new Scanner(System.in);
			Integer cpf = ler2.nextLine();
			if (validacao.verificarcpf(cpf)) {
				return cpf;
			} else {
				System.out.println("erro!cpf invalido");
				return capturarcpf();
			}
		}
	
		
	
		public Integer capturartelefone() {

			System.out.println("informe o telefone");
			Scanner ler3 = new Scanner(System.in);
			Integer telefone = ler3.nextLine();
			if (validacao.verificartelefone(telefone)) {
				return telefone;
			} else {
				System.out.println("erro! telefone invalido ");
				return capturartelefone();
			}
		}
	    
		public Integer capturarnumeroReserva() {

			System.out.println("informe o numero reserva");
			Scanner ler3 = new Scanner(System.in);
			Integer numeroReserva = ler3.nextLine();
			if (validacao.verificarnumeroReserva(numeroReserva)) {
				return numeroReserva;
			} else {
				System.out.println("erro! numero reserva invalido ");
				return capturarnumeroReserva();
			}
		}
	    


	}


