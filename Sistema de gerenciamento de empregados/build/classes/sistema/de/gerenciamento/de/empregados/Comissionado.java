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
public class Comissionado extends Empregado{
    private double totalVenda, taxaComissao;

    public Comissionado(double totalVenda, double taxaComissao, String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.totalVenda = totalVenda;
        this.taxaComissao = taxaComissao;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }


    public double vencimento(){
        return this.totalVenda * this.taxaComissao;
    }    
    
    public void imprimir(){
        super.imprimeDados();
        System.out.println("Vencimento: "+vencimento());
    }
    
}
