/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Fillipe
 */
public class Inter {

    /**
     * @param args the command line arguments
     */

    static List<Corrente> ListaContaCorrente = new ArrayList<Corrente>();
    public static void main(String[] args) {   
        // TODO code application logic here
        //MenuGeral Menu = new MenuGeral();
        //Menu.setVisible(true);

        Login Acesso = new Login();
        Acesso.setVisible(true);
        /*
        Corrente conta = new Corrente(1000.00,35.00,433373, 2524, 0.0,"17/03/2008");
        conta.imprimeContaBancaria();
        
        conta.Depositar(1, "Deposito", "08/08/2021", 600.00);
        conta.Depositar(1, "Deposito", "08/08/2021", 720.00);
        conta.Sacar(3, "Saque", "09/08/2021", 500.00);
        
        conta.ImprimirExtrato();
        */
        
        
    }
}
