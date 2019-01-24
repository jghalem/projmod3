package entradaDados;

import java.util.Scanner;
import validacao.ValidacaoCliente;

public class EntradaDadosCliente {
    private ValidacaoCliente validacao;

    public EntradaDadosCliente() {
        validacao = new ValidacaoCliente();
    }

    public static Integer capturarCodigo() {
        try {
            System.out.println("Informe o código:");
            Scanner c = new Scanner(System.in);
            return c.nextInt();
        } catch (Exception e) {
            System.err.println("Erro: Informe valor inteiro\n");
            return capturarCodigo();
        }
    }

    public String capturarNome() {
        System.out.println("Informe o nome:");
        Scanner ler = new Scanner(System.in);
        String nome = ler.nextLine();
        if(validacao.VerificarNome(nome)){
            return nome;
        }else{
            System.out.println("Erro! Nome inválido");
            return capturarNome();
        }
    }
    
    public String capturarSexo(){
        System.out.println("Digite 'F' - FEMININO ou 'M' - MASCULINO");
        Scanner ler = new Scanner(System.in);
        String sex = ler.nextLine();
        if (validacao.VerificarSexo(sex)){
            return sex;
        }else{
            System.out.println("Erro! Sexo inválido");
            return capturarSexo();
        }
    }
    
        public String capturarEmail(){
        System.out.println("Digite seu email");
        Scanner ler = new Scanner(System.in);
        String em = ler.nextLine();
        if (validacao.VerificarEmail(em)){
            return em;
        }else{
            System.out.println("Erro! Email inválido");
            return capturarEmail();
        }
    }
}
