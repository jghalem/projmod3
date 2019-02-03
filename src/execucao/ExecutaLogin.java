package execucao;

import java.util.List;
import java.util.Scanner;

import entidade.Login;
import entradaDados.EntradaDadosLogin;
import persistencia.LoginDAO;
import validacao.ValidacaoLogin;

public class ExecutaLogin {

	private static Login l;
	private static LoginDAO ld;
	private static Scanner s;

	public static void main(String[] args) {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		testeMetodos();
	}

	public static void criarLogin() {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		try {
			l.setIdfuncionario(EntradaDadosLogin.capturarId());
			l.setSenha(EntradaDadosLogin.capturarSenha());
			l.setGerente(ld.buscarIsGerente(l.getIdfuncionario()));
			l.setLogado(false);

			if (ld.inserir(l)) {
				System.out.println("Login Gravado!");
				System.out.println(l);
			} else {
				System.out.println("Erro ao criar login!");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void visualizarLogin() {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o usuario que deseja visualizar: (Digite '0' para todos)");
			String vis = s.nextLine();
			if (vis.equals("0")) {
				if (ValidacaoLogin.validarUsuario(vis)) {
					List<Login> logins = ld.buscarLoginEspecifico(vis);
					for (Login log : logins) {
						System.out.println(log);
					}
				} else {
					List<Login> logins = ld.buscarLogin();
					for (Login log : logins) {
						System.out.println(log);
					}
				}
			} else {
				System.out.println("O usuário deve ter exatamente 11 caracteres e conter somente números!");
				visualizarLogin();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void atualizarLogin() {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o usuario que deseja alterar:");
			String usuario = s.nextLine();
			if (ValidacaoLogin.validarUsuario(usuario)) {
				l.setUpdate(usuario);
				List<Login> logins = ld.buscarLoginEspecifico(l.getUpdate());
				for (Login log : logins) {
					System.out.println(log);
				}

				l.setUsuario(EntradaDadosLogin.capturarUsuario());
				l.setSenha(EntradaDadosLogin.capturarSenha());
				l.setGerente(EntradaDadosLogin.capturarIsGerente());
				l.setLogado(false);

				System.out.println(ld.atualizarLogin(l));
			} else {
				System.out.println("O usuario deve ter 11 caracteres e possuir apenas números!");
				atualizarLogin();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void apagarLogin() {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o usuario que deseja apagar:");
			Integer vis = s.nextInt();

			System.out.println(ld.excluirLogin(vis));

		} catch (Exception inputException) {
			System.out.println("Digite apenas números!");
		}
	}

	public static boolean fazerLogin() {
		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		try {
			System.out.println("Digite o usuario:");
			String vis = s.nextLine();
			if (ValidacaoLogin.validarUsuario(vis)) {
				if (ld.fazerLoginUsuario(vis).equals(vis)) {
					System.out.println("Digite a senha:");
					String sen = s.nextLine();

					if (ValidacaoLogin.validarSenha(sen)) {
						if (ld.fazerLoginSenha(sen).equals(sen)) {
							if (ld.buscarIsLogado(vis)) {
								System.out.println("Logado com sucesso!");
							}
						} else {
							System.out.println("Senha incorreta!");
							fazerLogin();
						}
					} else {
						System.out.println(
								"A senha deve ter de 6 a 20 caracteres e conter somente números, maiúsculas e minúsculas!");
						fazerLogin();
					}

				} else {
					System.out.println("Usuário incorreto!");
					fazerLogin();
				}
			} else {
				System.out.println("O usuário deve ter 11 caracteres e conter somente números!");
				fazerLogin();
			}

		} catch (Exception inputException) {
			System.out.println("Erro!");
		}
		return false;
	}

	public static void testeMetodos() {

		System.out.println("Digite a operação desejada: \nCriar - Visualizar - Atualizar - Apagar - Login");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "criar":
			criarLogin();
			break;
		case "visualizar":
			visualizarLogin();
			break;
		case "atualizar":
			atualizarLogin();
			break;
		case "apagar":
			apagarLogin();
			break;
		case "login":
			fazerLogin();
			break;
		default:
			System.out.println("Escolha uma das quatro opções!\n");
			testeMetodos();
			break;
		}
	}
}
