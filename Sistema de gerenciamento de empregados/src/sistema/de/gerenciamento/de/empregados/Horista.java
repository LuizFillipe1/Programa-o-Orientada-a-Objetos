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
public class Horista extends Empregado{
    private double precoHora, horasTrabalhadas;

    public Horista(double precoHora, double horasTrabalhadas, String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.precoHora = precoHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double vencimento(){
        return this.precoHora * this.horasTrabalhadas;
    }        
    public void imprimir(){
        super.imprimeDados();
        System.out.println("Vencimento: "+vencimento());   
    }
}
