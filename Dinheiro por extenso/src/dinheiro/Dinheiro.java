package dinheiro;

import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Fillipe
 */
public class Dinheiro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double a = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor: "));
        Moeda brasil = new Moeda(a);
        brasil.imprimir();
    }
    
}
