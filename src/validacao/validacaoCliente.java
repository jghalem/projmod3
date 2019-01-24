package validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validacaoCliente {

	Pattern p; 
    Matcher m; 
    
  
    public boolean verificarcpf (String cpf){

        p = Pattern.compile("{3,30}");
        
        if(cpf.length() > 11)
        
        m = p.matcher(cpf);
	
        return m.matches();
    }
    
    
    public boolean verificarNome (String nome){

        p = Pattern.compile("[a-zA-Zà-ù]");
        
        m = p.matcher(nome);
        
 
        return m.matches();
    }
        
   

public boolean verificarEmail (String email){
       
    p = Pattern.compile("[a-z0-9_.-]+@[a-z0-9_.-]+\\.[a-z]+");
        
        m = p.matcher(email);
        
    
        return m.matches();

}

public boolean verificarContato (String Contato){

    p = Pattern.compile("{3,30}");
     
    if(Contato.length() > 16)
    	
    m = p.matcher(Contato);

    return m.matches();
}



}














