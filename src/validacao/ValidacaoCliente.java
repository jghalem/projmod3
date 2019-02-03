package validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoCliente {

	Pattern p; 
    Matcher m; 
    
    
    
    public boolean verificarNome (String nome){

        p = Pattern.compile("[a-zA-Zà-ù]");
        
        m = p.matcher(nome);
        
 
        return m.matches();
    }
        
    public boolean verificarrg(String rg){

        p = Pattern.compile("{3,30}");
        
        if(rg.length() > 9)
        
        m = p.matcher(rg);
	
        return m.matches();
    }

    public boolean verificarcpf (String cpf){

        p = Pattern.compile("{3,30}");
        
        if(cpf.length() > 11)
        
        m = p.matcher(cpf);
	
        return m.matches();
    }

public boolean verificartelefone (String telefone){

    p = Pattern.compile("{3,30}");
     
    if(telefone.length() > 16)
    	
    m = p.matcher(telefone);

    return m.matches();
}

public boolean verificarnumeroReserva (String numeroReserva){

    p = Pattern.compile("{3,30}");
     
    if(numeroReserva.length() > 16)
    	
    m = p.matcher(numeroReserva);

    return m.matches();

}
}














