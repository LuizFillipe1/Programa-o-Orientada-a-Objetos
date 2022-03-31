/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ementor.plus;

/**
 *
 * @author Luiz Fillipe
 */
public class Pessoa {
    protected String nome, dataDeNascimento, CPF, telefone;
    
    public Pessoa(){
        this.nome = "";
        this.dataDeNascimento = "";
        this.CPF = "";
        this.telefone = "";
    }

    public Pessoa(String nome, String dataDeNascimento, String CPF, String telefone) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.CPF = CPF;
        this.telefone = telefone;
    }
    
    
    public void setDados(String nome, String dataDeNascimento, String CPF, String telefone) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.CPF = CPF;
        this.telefone = telefone;     
    }

}
