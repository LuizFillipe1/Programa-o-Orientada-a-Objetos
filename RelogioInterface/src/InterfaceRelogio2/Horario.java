/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceRelogio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Fillipe
 */
public class Horario implements Runnable{

    @Override
    public void run() {
        String horario = "";
        Relogio Hora = new Relogio();
        Hora.setHorario(12,12,12);
        for (;;) {
            horario = Hora.iniciar();
            View.DisplayRelogio.setText(horario);
            Hora.despertador();    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Horario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    
}
