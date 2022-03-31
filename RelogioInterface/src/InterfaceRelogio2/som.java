/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceRelogio2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author Luiz Fillipe
 */
public class som {
    URL som = som.class.getResource("som.wav");
    AudioClip Som = Applet.newAudioClip(som);
    
    public void main(){  
        som tocar = new som();
        tocar.Som.play();
        
    }
}
