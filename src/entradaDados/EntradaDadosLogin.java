package entradaDados;

import java.util.Scanner;

import validacao.ValidacaoLogin;

public class EntradaDadosLogin {

	private static Scanner s;

	public static String capturarUsuario() {
		s = new Scanner(System.in);
		System.out.println("Digite o cpf do usuario:");
		String n = s.nextLine();
		if (ValidacaoLogin.validarUsuario(n)) {
			return n;
		} else {
			System.out.println("O cpf deve ter 11 caracteres e conter somente números!");
			return capturarUsuario();
		}
	}

	public static Integer capturarId() {
		try {
			s = new Scanner(System.in);
			System.out.println("Digite o id do funcionario:");
			int n = s.nextInt();
			return n;
		} catch (Exception e) {
			System.out.println("Digite apenas números!");
			return capturarId();
		}
	}

	public static String capturarSenha() {
		s = new Scanner(System.in);
		System.out.println("Digite a senha da conta:");
		String n = s.nextLine();
		if (ValidacaoLogin.validarSenha(n)) {
			return n;
		} else {
			System.out.println(
					"A senha deve ter de 6 a 20 caracteres e conter somente maiúsculas, minúsculas e números!");
			return capturarSenha();
		}
	}

	public static Boolean capturarIsGerente() {
		try {
			s = new Scanner(System.in);
			System.out.println("Usuario recebe permissões de gerente? (S / N)");
			String n = s.nextLine();
			n.toLowerCase();
			String s = "s";
			if (n.equals(s)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro!" + e.getLocalizedMessage());
			e.printStackTrace();
			return capturarIsGerente();
		}
	}

	public static Boolean capturarIsLogado() {
		try {
			s = new Scanner(System.in);
			String n = s.nextLine();
			System.out.println("Usuario esta logado? (S / N)");
			n.toLowerCase();
			String s = "s";
			if (n.equals(s)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro!" + e.getLocalizedMessage());
			e.printStackTrace();
			return capturarIsLogado();
		}
	}

}
