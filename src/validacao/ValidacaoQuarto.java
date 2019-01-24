package validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoQuarto {
	Pattern p;
	Matcher m;

	public boolean VerificarQuarto(String nome) {
		p = Pattern.compile("[1-9]{3}");
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