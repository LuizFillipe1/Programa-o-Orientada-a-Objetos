/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeromegasena;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

/**
 *
 * @author Luiz Fillipe
 */
public class NumeroMegaSena {

    /**
     * @param args the command line arguments
     */
    
    public static boolean pertence(int vetor[], int numero){
        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] == numero)
                return true;        
        return false;
    }
    
    public static int[] geraVetor(){
        int vetor [] = new int[global.tam];
        int i = 0;
        do {
            Random gerador = new Random(); 
            int numero = gerador.nextInt(61);
            if (!pertence(vetor,numero) && numero != 0){  
                vetor[i] = numero;   
                i++;
            }
        }while(i < global.tam);
        return vetor;
    }

    public static int solicitacao(){
        int N = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantas apostas deseja realizar?","MEGA SENA",QUESTION_MESSAGE));
        return N;
    }
    
    public static void Apostas(int N){
        int vetorJAgerado[] = new int[global.tam];
        String valores = "";
        
        for (int i = 0; i < N; i++){
            vetorJAgerado = geraVetor();
            Arrays.sort(vetorJAgerado);
            for (int j = 0; j < vetorJAgerado.length; j++)
                valores = valores +" "+ vetorJAgerado[j];
            valores = valores + "\n";  
        }
        JOptionPane.showMessageDialog(null,"Apostas:"+"\n"+valores,"MEGA SENA",INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Apostas(solicitacao());
    }
}
