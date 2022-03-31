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
public class Cliente extends Pessoa{
    private int limiteCredito, scoreCredito;

    public Cliente(int limiteCredito, int scoreCredito, String nome, String endereco, int CPF, int RG) {
        super(nome, endereco, CPF, RG);
        this.limiteCredito = limiteCredito;
        this.scoreCredito = scoreCredito;
    }
    
    
}
