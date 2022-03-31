package inter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Corrente extends ContaBancaria{
  private double Limite;
  private double MensalidadeManutencao;
  

    public Corrente() {
    }

    public Corrente(double Limite, double MensalidadeManutencao, int Agencia, int Conta, String DataAbertura, double Saldo) {
        super(Agencia, Conta, DataAbertura, Saldo);
        this.Limite = Limite;
        this.MensalidadeManutencao = MensalidadeManutencao;
    }
        /////////////////////////////////////////////////////////////
    public void Sacar (int agencia, int Conta, int TOper, String DescOperacao, String Data, double Valor) {       
        if ((getSaldo()+this.Limite)>=Valor){//Verifica se há saldo suficiente, considerando o limite
            
            ConexaoMySQL conec = new ConexaoMySQL();
            setSaldo(getSaldo()-Valor);//Atualiza saldo com o valor sacado
            //Chamar os métodos : insereExtrato e atualizaSaldo
            conec.insereExtratoNoMySQL(Conta, Data, TOper, Valor, DescOperacao);
            conec.atualizaSaldoNoMySQL(agencia, Conta, getSaldo());
            Operacoes lancamentoAtual = new Operacoes (TOper,DescOperacao,Data,Valor);
            JOptionPane.showMessageDialog(null, "Saque Realizado com Sucesso!","Informação",INFORMATION_MESSAGE);

       }
       else
        JOptionPane.showMessageDialog(null, "Seu saldo é de R$: "+Formata(getSaldo())+" e com o limite fica: R$ "+(getSaldo()+this.Limite)+" e é insuficiente para a retirada de "+Formata(Valor),"Informação",INFORMATION_MESSAGE);
    }
    ///////////////////////////////////////////////////////////
    public void imprimirExtrato(){
        super.imprimirExtrato();
        System.out.println("Saldo + limite: "+Formata(getSaldo()+this.Limite));
    }
    
    public void imprimirDados(){
        super.imprimirDados();
        System.out.println("Limite: "+Formata(this.Limite));
        System.out.println("Mensalidade: "+Formata(this.MensalidadeManutencao));
      
    }

    public double getLimite() {
        return Limite;
    }

    public double getMensalidadeManutencao() {
        return MensalidadeManutencao;
    }

    public void setLimite(double Limite) {
        this.Limite = Limite;
    }

    public void setMensalidadeManutencao(double MensalidadeManutencao) {
        this.MensalidadeManutencao = MensalidadeManutencao;
    }

  

    
  
}
