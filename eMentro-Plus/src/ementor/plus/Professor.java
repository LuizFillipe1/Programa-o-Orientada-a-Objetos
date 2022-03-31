/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ementor.plus;

/**
 *
 * @author Luiz Fillipe
 */
public class Professor extends Pessoa{
    
    private String dataDeAdmissao;
    private double salarioBruto;
    
    
    public Professor(){
        super();
        this.dataDeAdmissao = "";
        this.salarioBruto = 0;
    }  
    public Professor(String dataDeAdmissao, double salarioBruto, String nome, String dataDeNascimento, String CPF, String telefone) {
        super(nome, dataDeNascimento, CPF, telefone);
        this.dataDeAdmissao = dataDeAdmissao;
        this.salarioBruto = salarioBruto;
    }

    public void setDados(String dataDeAdmissao, double salarioBruto, String nome, String dataDeNascimento, String CPF, String telefone){
        super.setDados(nome, dataDeNascimento, CPF, telefone);
        this.dataDeAdmissao = dataDeAdmissao;
        this.salarioBruto = salarioBruto;
    }

    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    
    public double getSalarioBruto() {
        return salarioBruto;
    }
    
    public double calculaSalarioLiquido(double salarioBruto){
        if(salarioBruto < 5000){
            return salarioBruto * 0.86;
        }else{
           return salarioBruto -(salarioBruto * 0.14 + salarioBruto * 0.225);     
        }
        
    }
    
    
    
}
