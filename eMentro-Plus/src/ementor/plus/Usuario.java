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
public class Usuario extends Pessoa {
    protected String nomeDoUsuario, senha, nivelDeAcesso;

    public Usuario(String nomeDoUsuario, String senha, String nivelDeAcesso, String nome, String dataDeNascimento, String CPF, String telefone) {
        super(nome, dataDeNascimento, CPF, telefone);
        this.nomeDoUsuario = nomeDoUsuario;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }
    
    public void setDados (String nomeDoUsuario, String senha, String nivelDeAcesso, String nome, String dataDeNascimento, String CPF, String telefone) { 
        this.nomeDoUsuario = nomeDoUsuario;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso; 
        super.nome = nome;
        super.dataDeNascimento = dataDeNascimento;
        super.telefone = telefone;     
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }
    
    
  
    
    

    
}
