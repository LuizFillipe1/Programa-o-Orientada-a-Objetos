/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

/**
 *
 * @author Luiz Fillipe
 */
public class Pessoa {
    
    private String nome, endereco;
    private int CPF, RG;

    public Pessoa(String nome, String endereco, int CPF, int RG) {
        this.nome = nome;
        this.endereco = endereco;
        this.CPF = CPF;
        this.RG = RG;
    }
    
}
