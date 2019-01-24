package validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoCliente {
	Pattern p;
	Matcher m;

	public boolean VerificarNome(String nome) {
		p = Pattern.compile("[a-zA-Zà-ù]{3,30}");
		m = p.matcher(nome);
		return m.matches();
	}

	public boolean VerificarSexo(String sexo) {
		boolean verifica = false;
		if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m")) {
			verifica = true;
		}
		return verifica;
	}

	public boolean VerificarEmail(String email) {
		p = Pattern.compile("[a-z0-9_.-]+@[a-z0-9_.-]+\\.[a-z]+");
		m = p.matcher(email);
		return m.matches();
	}

}
