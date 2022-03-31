package InterfaceRelogio2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luiz Fillipe
 */


public class Relogio{
    
    
    public static int segundo, minuto, hora;
    public static int seg_desp, min_desp, hora_desp;
    private String horario = "";

    
    
    public Relogio(){
    this.segundo = 0;
    this.seg_desp = 0;
    this.minuto = 0;
    this.min_desp = 0;
    this.hora = 0;
    this.hora_desp = 0;
    }
   
    public void setHorario (int segundo){
        this.segundo = segundo;
    }
    public void setHorario (int hora, int minuto){
        this.hora = hora;
        this.minuto = minuto;   
    }
    public void setHorario (int hora, int minuto, int segundo){
        this.hora = hora;
        this.minuto = minuto;  
        this.segundo = segundo;
    }  
    public void incrementaSegundo(){
        this.segundo = this.segundo + 1;
    }
    public void zeraSegundo(){
        this.segundo = 0;
    }
    public void incrementaMinuto(){
        this.minuto = this.minuto + 1;
    }
    public void zeraMinuto(){
        this.minuto = 0;
    }
    public void incrementaHora(){
        this.hora = this.hora + 1;
    }      
    public void zeraHora(){
        this.hora = 0;
    }
    public void atualizaHorario(int hora, int minuto, int segundo){
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        
    }
    public void despertador(){
        if (this.hora == this.hora_desp && this.minuto == this.min_desp && this.segundo == this.seg_desp){
            som Musica = new som();
            Musica.main();
        }
    }
    public void setDespertador(int hora, int minuto, int segundo){
        this.hora_desp = hora;
        this.min_desp = minuto;
        this.seg_desp = segundo;
    }
 
    
    public String iniciar() {

        //limpaTela();
        horario = "";
        horario = horario + this.hora+" Horas "+this.minuto+" minutos "+this.segundo+" segundos";
        this.incrementaSegundo();
        this.despertador();
        
        if (this.segundo == 60){
            this.zeraSegundo();
            this.incrementaMinuto();
        }    
        if (this.minuto == 60){
            this.zeraMinuto();
            this.incrementaHora(); 
        }   
        if (this.hora == 24){
            this.zeraHora(); 
            this.zeraMinuto();
        }
        return horario;
    }
  

public void limpaTela(){
  for(int count=0 ; count<6 ; count++)
    System.out.println(""); 
}


}
