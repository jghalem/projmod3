package execucao;

import java.util.List;
import java.util.Scanner;

import entidade.Login;
import entradaDados.EntradaDadosLogin;
import persistencia.LoginDAO;
import validacao.ValidacaoLogin;

public class ExecutaLogin {

	protected static Login l;
	protected static LoginDAO ld;
	protected static Scanner s;

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
				System.out.println("O usu�rio deve ter exatamente 11 caracteres e conter somente n�meros!");
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
				System.out.println("O usuario deve ter 11 caracteres e possuir apenas n�meros!");
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
			System.out.println("Digite apenas n�meros!");
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
							if (ld.defIsLogado(vis)) {
								System.out.println("Logado com sucesso!");
								return true;
							}
						} else {
							System.out.println("Senha incorreta!");
							fazerLogin();
						}
					} else {
						System.out.println(
								"A senha deve ter de 6 a 20 caracteres e conter somente n�meros, mai�sculas e min�sculas!");
						fazerLogin();
					}
				} else {
					System.out.println("Usu�rio incorreto!");
					fazerLogin();
				}
			} else {
				System.out.println("O usu�rio deve ter 11 caracteres e conter somente n�meros!");
				fazerLogin();
			}

		} catch (Exception inputException) {
			System.out.println("Erro!");
		}
		return false;
	}

	public static void testeMetodos() throws Exception {
		
		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		System.out.println("Digite a opera��o desejada: \nCriar - Visualizar - Atualizar - Apagar");
		String op = s.nextLine();
		op.toLowerCase();

		switch (op) {
		case "criar":
				criarLogin();
			break;
		case "visualizar":
			if (ld.buscarLogados()) {
				visualizarLogin();
				;
			} else {
				System.out.println("Fa�a login para poder acessar as op��es!");
				fazerLogin();
			}
			break;
		case "atualizar":
			if (ld.buscarLogados()) {
				atualizarLogin();
			} else {
				System.out.println("Fa�a login para poder acessar as op��es!");
				fazerLogin();
			}
			break;
		case "apagar":
			if (ld.buscarLogados()) {
				apagarLogin();
			} else {
				System.out.println("Fa�a login para poder acessar as op��es!");
				fazerLogin();
			}
			break;
		default:
			System.out.println("Escolha uma das quatro op��es!\n");
			testeMetodos();
			break;
		}
	}
}
