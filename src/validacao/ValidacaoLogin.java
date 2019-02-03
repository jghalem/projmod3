package validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoLogin {
	public static Pattern p;
	public static Matcher m;

	public static boolean validarUsuario(String usuario) {
		p = Pattern.compile("[0-9]{11}");
		m = p.matcher(usuario);
		return m.matches();
	}
	
	public static boolean validarSenha(String senha) {
		p = Pattern.compile("[a-zA-Z0-9]{6,20}");
		m = p.matcher(senha);
		return m.matches();
	}

}