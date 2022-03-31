/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.gerenciamento.de.empregados;

/**
 *
 * @author Luiz Fillipe
 */
public class Empregado {
    
    private String nome, sobrenome, cpf; 

    public Empregado(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobremome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double vencimento() {
       return 0;
    }
    
    public void imprimeDados(){
        System.out.println("Nome: "+this.nome+"\n"+
                           "Sobrenome: "+this.sobrenome+"\n"+
                           "CPF: "+this.cpf);
        
    }
    


    
}
