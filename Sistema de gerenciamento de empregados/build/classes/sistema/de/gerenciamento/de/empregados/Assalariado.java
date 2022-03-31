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
public class Assalariado extends Empregado {
        private double salario;

    public Assalariado(double salario, String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }


    public void imprimir(){
        super.imprimeDados();
        System.out.println("Vencimento: "+this.salario);
    }
    public double vencimento(){
        return this.salario;
    }
        
        
}
