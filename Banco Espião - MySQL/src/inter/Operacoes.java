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
public class Operacoes {
    private int TipoOperacao; // 1- Credito Deposito; 2 - Credito Transferencia; 3-  Debito Saque 
    private String DescOperacao;
    private String DataOperacao;
    private double valor;

    public Operacoes() {
    }
    
    public Operacoes(int TipoOperacao, String DescOperacao, String DataOperacao, double valor) {
        this.TipoOperacao = TipoOperacao;
        this.DescOperacao = DescOperacao;
        this.DataOperacao = DataOperacao;
        this.valor = valor;
    }
    public int getTipoOperacao() {
        return TipoOperacao;
    }

    public String getDescOperacao() {
        return DescOperacao;
    }

    public String getDataOperacao() {
        return DataOperacao;
    }

    public double getValor() {
        return valor;
    }


}
