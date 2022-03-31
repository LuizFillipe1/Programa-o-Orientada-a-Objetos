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
public class SistemaDeGerenciamentoDeEmpregados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       //Empregado teste1 = new Empregado("Luiz", "Fillipe", "128.412.654-85");
       Assalariado teste2 = new Assalariado(2500.00, "Luiz", "Fillipe","128.512.684-85");
       Comissionado teste3 = new Comissionado(3456.00,0.75,"Luiz","Fillipe","128.416.325-00");
       Horista teste4 = new Horista(7.56, 2360.00,"Luiz","Fillipe","128.631.541-96");
       
       teste2.imprimir();
       System.out.println("\n");
       teste3.imprimir();
       System.out.println("\n");
       teste4.imprimir();
       
       
               
               
             
        
        
    }
    
}
