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
public class Gerente extends Bancario{
    private int numeroMatricula_G, nivelAcessoSistema_G;

    public Gerente(int numeroMatricula_G, int nivelAcessoSistema_G, int numeroMatricula, int nivelAcessoSistema, String nome, String endereco, int CPF, int RG) {
        super(numeroMatricula, nivelAcessoSistema, nome, endereco, CPF, RG);
        this.numeroMatricula_G = numeroMatricula_G;
        this.nivelAcessoSistema_G = nivelAcessoSistema_G;
    }
    

    
    
}
