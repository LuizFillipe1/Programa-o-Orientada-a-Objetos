package veiculos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;


/**
 *
 * @author Luiz Fillipe O. Morais
 *         Matrícula: 2019107733
 *              &
 *         Emanuel Silva Sergio
 *         Matrícula: 2019107863
 */
public class Carro {
    private int ano, velocidadeAtual, velocidadeMaxima, numeroMarcha, marchaAtual;
    private float volumeCombustivel, capacidadeDoTanque;
    private String cor,proprietario, direcaoTrajeto;
    public Marca marcaClass = new Marca();
    
    
    public Carro(){
        this.velocidadeAtual = 0;
        this.velocidadeMaxima = 0;
        this.numeroMarcha = 0;
        this.marchaAtual = 0;
        this.volumeCombustivel = 0;
        this.capacidadeDoTanque = 0;
        this.cor = "";
        this.proprietario = "";
        this.direcaoTrajeto = "";
    }
    public Carro(int ano,int velocidadeAtual, int velocidadeMaxima, int numeroMarcha, int marchaAtual,
            float volumeCombustivel,float capacidadeDoTanque,
            String modelo, String cor, String proprietario, String chassi, String marca, String trajeto){     
        this.velocidadeAtual = velocidadeAtual;
        this.velocidadeMaxima = velocidadeMaxima;
        this.numeroMarcha = numeroMarcha;
        this.marchaAtual = marchaAtual;
        this.volumeCombustivel = volumeCombustivel;
        this.capacidadeDoTanque = capacidadeDoTanque;
        this.direcaoTrajeto = trajeto;
        this.cor = cor;
        this.proprietario = proprietario;
        this.marcaClass.setcodigoIdentificador(chassi);
        this.marcaClass.setNome(marca);
        this.marcaClass.setanoLancamento(ano);
        this.marcaClass.setnrDeModelos(modelo);
    }
    public void Acelerar(){
        if(this.velocidadeAtual <= this.velocidadeMaxima )
            this.velocidadeAtual = this.velocidadeAtual + 5;
        else
            System.out.println("Velocidade exede a máxima!");
    }
    public void Frear(){
        if (this.velocidadeAtual -4 >= 0)
            this.velocidadeAtual -= 4;
        else if (this.velocidadeAtual > 0)
            this.velocidadeAtual = 0;
    }
    public void TrocarMarcha(int posicao){
        if ((posicao > -1) || (posicao>this.numeroMarcha) )
            if (Math.abs(this.marchaAtual - posicao) <= 2 )
                this.marchaAtual = posicao;
            else
                System.out.println("a marcha nao pode variar mais que dois incrementos");
        else
            System.out.println("Marcha invalida");
    }
    public int getVelocidade(){
        return this.velocidadeAtual;
    }
    public void setVelocidadeAtual(int velocidade){
        this.velocidadeAtual = velocidade;
    }
    public void setVelocidadeMaxima(int velocidade){
        this.velocidadeMaxima = velocidade;
    }
    public void setProprietario(String nome){
        this.proprietario = nome;
    }
    public String getProprietario(){
        return this.proprietario;
    }
    public int getVelocidadeMaxima(){
        return this.velocidadeMaxima;
    }
    public void setNumeroMarcha(int totalMarcha){
        this.numeroMarcha= totalMarcha;
    }
    public void setCapTanque (float litros){
        this.capacidadeDoTanque = litros;
    }
    public float getCapTanque (){
        return this.capacidadeDoTanque;
    }
    public void setVolumeCombustivel(float volume){
        this.volumeCombustivel = volume;
    }
    public float getVolumeCombustivel(){
        return this.volumeCombustivel;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public String getCor(){
        return this.cor;
    }
    public float autonomia(float consumoMedio){
        return consumoMedio * volumeCombustivel;
    }
    public int getMarcha(){
        return this.marchaAtual;
    }
    public void setAno(int ano){
        marcaClass.setanoLancamento(ano);
    }   
    public void setdirecaoTrajeto(String trajeto){
        this.direcaoTrajeto = trajeto;
    }
    public String getdirecaoTrajeto(){
        return this.direcaoTrajeto;
    }
    
    public void dirigir(int Velocidade, String direcao){
        this.setVelocidadeAtual(Velocidade);
        this.setdirecaoTrajeto(direcao);
    }
 
    public void InformacoesGerais(){
        JOptionPane.showMessageDialog(null,    
                "Proprietário: "+this.getProprietario()+"\n"+
                "Marca: "+marcaClass.getNome()+"\n"+
                "Modelo: "+marcaClass.getnrDeModelos()+"\n"+
                "Ano de Fabricação: "+marcaClass.getanoLancamento()+"\n"+
                "Chassi: "+marcaClass.getcodigoIdentificador()+"\n"+
                "Cor: "+this.getCor()+"\n"+
                "Velocidade Máxima: "+this.getVelocidadeMaxima()+" Km/h"+"\n"+
                "Capacidade do Tanque: "+this.getCapTanque()+" litros"+"\n"
                ,"Informações do carro",PLAIN_MESSAGE);
    }
    
    private void CaixasDaCorrida(String segmento){
        JOptionPane.showMessageDialog(null,   
            "--------------Autódromo de Interlagos--------------"+"\n"+
            "Trajeto "+segmento+"\n"+
            "Velocidade Atual: "+this.getVelocidade()+" Km/h"+"\n"+
            "Marcha Atual: "+this.getMarcha()+"\n"+
            "Direção: "+this.getdirecaoTrajeto()+"\n"              
             ,"Pista de Interlagos", PLAIN_MESSAGE);    
    }
    public void FinalizouCorrida(){
        ImageIcon icon = new ImageIcon("dab2.png");
        ImageIcon icon2 = new ImageIcon("emote.png");
        JOptionPane.showMessageDialog(null,"","Pista de Interlagos", PLAIN_MESSAGE,icon);   
        JOptionPane.showMessageDialog(null,"Você rodou 2.942 metros, com um consumo médio de 8.7 Km/L","Pista de Interlagos", PLAIN_MESSAGE,icon2);           
    }


    public void PistaInterlagos(){
        //Iniciando a Corrida
        this.CaixasDaCorrida("B-M");      
        //Trajeto B-M 
        this.setdirecaoTrajeto("Reto");
        this.TrocarMarcha(1);
        this.Acelerar();
        this.CaixasDaCorrida("B-M");
        this.Acelerar();
        this.CaixasDaCorrida("B-M");
        this.Acelerar();
        this.CaixasDaCorrida("B-M");
        this.TrocarMarcha(2);
        this.Acelerar();
        this.CaixasDaCorrida("B-M");
        this.CaixasDaCorrida("B-M");
        //Trajeto D
        this.Frear();
        this.setdirecaoTrajeto("Esquerdo");
        this.CaixasDaCorrida("D");
        //Segmento E
        this.setdirecaoTrajeto("Direto");
        this.Acelerar();
        this.CaixasDaCorrida("E");
        this.Acelerar();
        this.setdirecaoTrajeto("Reto");
        this.CaixasDaCorrida("E");
        //Segmento N-H
        this.Acelerar();
        this.TrocarMarcha(3);
        this.CaixasDaCorrida("N-H");
        this.Acelerar();
        this.CaixasDaCorrida("N-H");
        this.Acelerar();
        //Segmento K
        this.TrocarMarcha(4);
        this.CaixasDaCorrida("K");
        this.setdirecaoTrajeto("Esquerdo");
        this.Frear();
        this.TrocarMarcha(3);
        this.CaixasDaCorrida("K");
        //Semento F, Q E G
        this.setdirecaoTrajeto("Reto");
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.TrocarMarcha(4);
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.TrocarMarcha(5);
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");        
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");           
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");  
        this.Acelerar();
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");  
        this.Acelerar();
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G"); 
        this.Acelerar();
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G");
        this.Acelerar();
        this.Acelerar();
        this.CaixasDaCorrida("F-Q-G"); 
        //Segmento S
        this.CaixasDaCorrida("S");
        this.Frear();
        this.CaixasDaCorrida("S");
        this.Frear();    
        this.CaixasDaCorrida("S");
        this.Frear();        
        this.CaixasDaCorrida("S");
        this.Frear();        
        this.CaixasDaCorrida("S");
        this.Frear();     
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.TrocarMarcha(4);
        this.CaixasDaCorrida("S");
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.CaixasDaCorrida("S");
        this.Frear();  
        this.Frear();  
        this.TrocarMarcha(3);
        this.CaixasDaCorrida("S");
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.CaixasDaCorrida("S");
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.CaixasDaCorrida("S");
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.Frear();  
        this.TrocarMarcha(2);
        this.CaixasDaCorrida("S");
        this.Frear();  
        this.Frear(); 
        this.CaixasDaCorrida("S");
        this.Frear(); 
        this.Frear(); 
        this.Frear(); 
        this.CaixasDaCorrida("S");
        this.Frear(); 
        this.CaixasDaCorrida("S");
        this.Frear(); 
        this.CaixasDaCorrida("S");
        this.Frear(); 
        this.CaixasDaCorrida("S");
        this.Frear(); 
        this.TrocarMarcha(0);
        this.CaixasDaCorrida("S");
        this.FinalizouCorrida();        
    }
}