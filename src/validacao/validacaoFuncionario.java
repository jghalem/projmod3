package validacao;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class validacaoFuncionario {

	Pattern p; 
    Matcher m; 
    
    
    
    public boolean verificarnome (String nome){

        p = Pattern.compile("[ a-zA-Zà-ù]{3,30}");
        
        m = p.matcher(nome);
        
 
        return m.matches();
    }
        
    public boolean verificarrg(String rg){

        p = Pattern.compile("[0-9]{8,10}");
        
        if(rg.length() >= 8)
        
        m = p.matcher(rg);
	
        return m.matches();
    }

    public boolean verificarcpf (String cpf){

        p = Pattern.compile("[0-9]{11}");
        
        if(cpf.length() == 11)
        
        m = p.matcher(cpf);
	
        return m.matches();
    }

public boolean verificarcontato (String contato){

    p = Pattern.compile("[+0-9]{11,16}");
     
    if(contato.length() >= 11)
    
    m = p.matcher(contato);
    
    return m.matches();
}


    

    
    
}


















