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
public class Bancario extends Pessoa{
    private int numeroMatricula, nivelAcessoSistema;

    public Bancario(int numeroMatricula, int nivelAcessoSistema, String nome, String endereco, int CPF, int RG) {
        super(nome, endereco, CPF, RG);
        this.numeroMatricula = numeroMatricula;
        this.nivelAcessoSistema = nivelAcessoSistema;
    }
    
    
}
