package validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoQuarto {
	public static Pattern p;
	public static Matcher m;

	public static boolean validarQuarto(Integer numeroQuarto) {
		String numQuarto;
		numQuarto = numeroQuarto.toString();
		p = Pattern.compile("[0-9]{3}");
		m = p.matcher(numQuarto);
		return m.matches();
	}

	public static boolean validarAndar(Integer andarQuarto) {
		String andQuarto;
		andQuarto = andarQuarto.toString();
		p = Pattern.compile("[1-9]{1}");
		m = p.matcher(andQuarto);
		return m.matches();
	}
	
	public static boolean validarDisponibilidade(String disponivel) {
		disponivel.toString();
		p = Pattern.compile("[sn]{1}");
		m = p.matcher(disponivel);
		return m.matches();
	}

}