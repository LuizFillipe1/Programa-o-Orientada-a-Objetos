/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ementor.plus;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Luiz Fillipe
 */
public class Aluno extends Pessoa {

    private String matricula, periodo;

    public Aluno(String matricula, String periodo, String nome, String dataDeNascimento, String CPF, String telefone) {
        super(nome, dataDeNascimento, CPF, telefone);
        this.matricula = matricula;
        this.periodo = periodo;
    }
    
    public Aluno(){
        super();
        this.matricula = "";
        this.periodo = "";
    }  

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    public void setDados(String matricula, String periodo, String nome, String dataDeNascimento, String CPF, String telefone) {
        super.setDados(nome, dataDeNascimento, CPF, telefone);
        this.periodo = periodo;
        this.matricula = matricula;     
    }
}
