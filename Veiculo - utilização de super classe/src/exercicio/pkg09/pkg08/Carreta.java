/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.pkg09.pkg08;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

/**
 *
 * @author Luiz Fillipe
 */
public class Carreta extends Carro{
    private float pesoBrutoTotal, pesoLiquido, pesoMaximo;
    private int numeroDeEixos;
    private String codigoANTT, tipoDeCarga;

    public Carreta(float pesoBrutoTotal, float pesoLiquido, float pesoMaximo, int numeroDeEixos, String codigoANTT, String tipoDeCarga, int ano, int velocidadeAtual, int velocidadeMaxima, int numeroMarcha, int marchaAtual, float volumeCombustivel, float capacidadeDoTanque, String modelo, String cor, String proprietario, String chassi, String marca, String trajeto) {
        super(ano, velocidadeAtual, velocidadeMaxima, numeroMarcha, marchaAtual, volumeCombustivel, capacidadeDoTanque, modelo, cor, proprietario, chassi, marca, trajeto);
        this.pesoBrutoTotal = pesoBrutoTotal;
        this.pesoLiquido = pesoLiquido;
        this.pesoMaximo = pesoMaximo;
        this.numeroDeEixos = numeroDeEixos;
        this.codigoANTT = codigoANTT;
        this.tipoDeCarga = tipoDeCarga;
    }

    public float getPesoBrutoTotal() {
        return pesoBrutoTotal;
    }

    public void setPesoBrutoTotal(float pesoBrutoTotal) {
        this.pesoBrutoTotal = pesoBrutoTotal;
    }

    public float getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(float pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public float getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(float pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public int getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public void setNumeroDeEixos(int numeroDeEixos) {
        this.numeroDeEixos = numeroDeEixos;
    }

    public String getCodigoANTT() {
        return codigoANTT;
    }

    public void setCodigoANTT(String codigoANTT) {
        this.codigoANTT = codigoANTT;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    
    
        public void InformacoesGerais(){
        JOptionPane.showMessageDialog(null,    
                "Proprietário: "+this.getProprietario()+"\n"+
                "Marca: "+marcaClass.getNome()+"\n"+
                "Modelo: "+marcaClass.getnrDeModelos()+"\n"+
                "Ano de Fabricação: "+marcaClass.getanoLancamento()+"\n"+
                "Chassi: "+marcaClass.getcodigoIdentificador()+"\n"+
                "Cor: "+this.getCor()+"\n"+
                "Velocidade Máxima: "+this.getVelocidadeMaxima()+" Km/h"+"\n"+
                "Capacidade do Tanque: "+this.getCapTanque()+" litros"+"\n"+
                "Número de Eixos: " + this.numeroDeEixos+"\n"+
                "Peso bruto total: " +this.pesoBrutoTotal+" toneladas"+"\n"+
                "Peso Líquido: "+this.pesoLiquido + " toneladas"+"\n"+
                "Tipo de carga: " +this.tipoDeCarga
                ,"Informações do carro",PLAIN_MESSAGE);
        
    }
    
    public String carregarCarga(float pesoDaCarga){
        if(this.pesoMaximo > pesoDaCarga)
            return "Carga permitida";
        else
            return "Carga máxima exedida";
        
    }    
}
