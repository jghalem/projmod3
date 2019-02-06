package entradaDados;

import java.util.Scanner;

import validacao.validacaoFuncionario;

public class entradaDadosFuncionario {

	private static validacaoFuncionario validacao;

	public entradaDadosFuncionario() {
		validacao = new validacaoFuncionario();
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

	public String capturarcontato() {

		System.out.println("informe o contato");
		Scanner ler3 = new Scanner(System.in);
		String contato = ler3.nextLine();
		if (validacao.verificarcontato(contato)) {
			return contato;
		} else {
			System.out.println("erro!contato invalido ");
			return capturarcontato();
		}
	}

	public boolean capturarCargo() {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("informe o cargo: (gerente(g)/funcionario(f))");
			String f = s.nextLine();
			f.toLowerCase();
			String g = "g";

			if (f.equals(g)) {
				System.out.println("olá gerente!");
				return true;

			} else {
				System.out.println("olá funcionario!");

			}
		} catch (Exception e) {
			System.out.println("Erro!" + e.getLocalizedMessage());
			e.printStackTrace();
			return capturarCargo();
		}
		return false;
	}
}
