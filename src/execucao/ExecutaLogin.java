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

	public static boolean fazerLoginFuncionario() throws Exception {
		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		System.out.println("Digite o usuario:");
		String usu = s.nextLine();
		if (ValidacaoLogin.validarUsuario(usu)) {
			if (ld.fazerLoginUsuario(usu).equals(usu)) {
				System.out.println("Digite a senha:");
				String sen = s.nextLine();

				if (ValidacaoLogin.validarSenha(sen)) {
					if (ld.fazerLoginSenha(sen, usu).equals(sen)) {
						if (!ld.buscarCargo(usu)) {
							return true;
						} else {
							return false;
						}
					} else {
						System.out.println("Senha incorreta!");
						fazerLoginFuncionario();
					}
				} else {
					System.out.println(
							"A senha deve ter de 6 a 20 caracteres e conter somente números, maiúsculas e minúsculas!");
					fazerLoginFuncionario();
				}
			} else {
				System.out.println("Usuário incorreto!");
				fazerLoginFuncionario();
			}
		} else {
			System.out.println("O usuário deve ter 11 caracteres e conter somente números!");
			fazerLoginFuncionario();
		}
		return false;
	}
	
	public static boolean fazerLoginGerente() throws Exception {
		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		System.out.println("Digite o usuario:");
		String usu = s.nextLine();
		if (ValidacaoLogin.validarUsuario(usu)) {
			if (ld.fazerLoginUsuario(usu).equals(usu)) {
				System.out.println("Digite a senha:");
				String sen = s.nextLine();

				if (ValidacaoLogin.validarSenha(sen)) {
					if (ld.fazerLoginSenha(sen, usu).equals(sen)) {
						if (ld.buscarCargo(usu)) {
							return true;
						} else {
							return false;
						}
					} else {
						System.out.println("Senha incorreta!");
						fazerLoginFuncionario();
					}
				} else {
					System.out.println(
							"A senha deve ter de 6 a 20 caracteres e conter somente números, maiúsculas e minúsculas!");
					fazerLoginFuncionario();
				}
			} else {
				System.out.println("Usuário incorreto!");
				fazerLoginFuncionario();
			}
		} else {
			System.out.println("O usuário deve ter 11 caracteres e conter somente números!");
			fazerLoginFuncionario();
		}
		return false;
	}

	public static void testeMetodos() throws Exception {

		l = new Login();
		ld = new LoginDAO();
		s = new Scanner(System.in);

		System.out.println("Digite a operação desejada: \nCriar - Visualizar - Atualizar - Apagar");
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
		default:
			System.out.println("Escolha uma das quatro opções!\n");
			testeMetodos();
			break;
		}
	}
}
