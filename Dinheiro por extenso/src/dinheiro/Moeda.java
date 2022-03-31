/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinheiro;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

/**
 *
 * @author Luiz Fillipe
 */
public class Moeda {
    private double valor;
    private int real_unidade, real_dezena, real_centena, moeda, moeda_unidade, moeda_dezena;
    private enum unidade {Um, Dois, Tres, Quatro, Cinco, Seis, Sete, Oito, Nove, Dez, Onze, Doze, Treze, Quatorze, Quinze, Dezesseis, Dezessete, Dezoito, Dezenove};
    private enum dezena {Dez, Vinte, Trinta, Quarenta, Cinquenta, Sessenta, Setenta, Oitenta, Noventa};
    private enum centena {Cento, Duzentos, Trezentos, Quatrocentos, Quinhentos, Seiscentos, Setecentos, Oitocentos, Novecentos};
    private String extenso = "";
    
    public Moeda(double valor){
        this.valor = valor;    
}
    public Moeda(){
        this.valor = 0;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public void imprimir(){     
        this.enumeraReal();
        this.enumeraMoeda();
        JOptionPane.showMessageDialog(null,this.valor + " Reais \n" + this.extenso,"DINHEIRO R$",PLAIN_MESSAGE);
    }
    public void enumeraReal (){
        if (this.valor < 0){
            this.extenso = this.extenso + "Menos ";
            this.valor = Math.abs(this.valor);
        }
        this.real_unidade = (int) this.valor;
        if (this.real_unidade > 0 && this.real_unidade < 20)
            this.extenso = this.extenso + unidade.values()[this.real_unidade-1] + " Reais";
        else if (this.valor > 19 && this.valor < 100){
            this.real_dezena = (int) this.valor / 10;
            this.real_unidade = (int)(this.valor - real_dezena *10);
            if(this.real_unidade == 0)
                this.extenso = this.extenso + dezena.values()[this.real_dezena-1] + " Reais";
            else
                this.extenso = this.extenso + dezena.values()[this.real_dezena-1] + " e " + unidade.values()[this.real_unidade-1]+ " Reais";
        }
        else if (this.valor > 99 && this.valor < 1000){
            this.real_centena = (int) this.valor / 100;
            this.real_dezena = (int) ((this.valor - real_centena * 100) / 10);
            this.real_unidade = (int)(this.valor - (real_centena * 100) - (real_dezena * 10));
            if (this.real_dezena == 0 && real_unidade == 0)
                if (this.real_centena == 1)
                    this.extenso = this.extenso + "Cem Reais";
                else
                    this.extenso = this.extenso + centena.values()[this.real_centena-1] + " Reais";
            else if (this.real_dezena == 1 || this.real_dezena == 0){
                this.real_unidade = (int) this.valor - this.real_centena *100;
                this.extenso = this.extenso + centena.values()[this.real_centena-1] + " e "+ unidade.values()[this.real_unidade-1] + " Reais";                
            }
            else if (this.real_unidade == 0)
                this.extenso = this.extenso + centena.values()[this.real_centena-1] + " e "+ dezena.values()[this.real_dezena-1] + " Reais";
            else
                this.extenso = this.extenso + centena.values()[this.real_centena-1] + " e " + dezena.values()[this.real_dezena-1] + " e " + unidade.values()[this.real_unidade-1]+ " Reais";
        }
        else if (this.valor >= 1000)
            this.extenso = this.extenso + "Mil reais";
        if (this.real_unidade == 0 && this.real_dezena == 0)
            this.extenso = this.extenso + "";

        
    }
    public void enumeraMoeda(){
        this.moeda = (int)(Math.round((this.valor - (int)this.valor) * 100));
        if ((int) this.valor > 0)
            this.extenso = this.extenso + " e ";
        if (this.moeda == 0)
            this.extenso = this.extenso + "";
        else if (this.moeda > 0 && this.moeda < 20)
            this.extenso = this.extenso + unidade.values()[this.moeda-1] + " Centavos";
        else if (this.moeda > 19 && this.moeda < 100){
            this.moeda_dezena = (int) this.moeda / 10;
            this.moeda_unidade = (int)(this.moeda - moeda_dezena *10);
            if (moeda_unidade == 0 ){
                this.extenso = this.extenso + dezena.values()[this.moeda_dezena-1] + " Centavos";
            }
            else
                this.extenso = this.extenso + dezena.values()[this.moeda_dezena-1] + " e " + unidade.values()[this.moeda_unidade-1]+ " Centavos";
        } 
    }    
}
