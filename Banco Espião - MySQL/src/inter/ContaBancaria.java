package inter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private int Agencia;
    private int Conta;
    private String DataAbertura;
    private double Saldo;
    private List<Operacoes> Extrato = new ArrayList<Operacoes>();

    public ContaBancaria() {
    }

    public ContaBancaria(int Agencia, int Conta, String DataAbertura, double Saldo) {
        this.Agencia = Agencia;
        this.Conta = Conta;
        this.DataAbertura = DataAbertura;
        this.Saldo = Saldo;
    }
    public String Formata (double valor){
        DecimalFormat doubleFormata = new DecimalFormat();
        doubleFormata.applyPattern("R$ #,##0.00");
        return doubleFormata.format(valor);
    }
    /////////////////////////////////////////////////////////////
    public void Sacar (int TOper, String DescOperacao, String Data, double Valor){
       if (this.Saldo>=Valor) {
           this.Saldo=this.Saldo-Valor;
           Operacoes lancamentoAtual = new Operacoes (TOper,DescOperacao,Data,Valor);
           Extrato.add(lancamentoAtual);
       }
       else
          System.out.println("Saldo de "+Formata(this.Saldo)+" é insuficiente para a retirada de "+Formata(Valor));
    }
    ////////////////////////////////////////////////////////////////
    public void depositar (int agencia, int Conta, int TOper, String DescOperacao, String Data, double Valor){
      //Elementos do MySQL tanto para extrato qualto atualização de saldo 
      ConexaoMySQL conec = new ConexaoMySQL();
      this.Saldo=this.Saldo+Valor;
      //Chamar os métodos : insereExtrato e atualizaSaldo
      conec.insereExtratoNoMySQL(Conta, Data, TOper, Valor, DescOperacao);
      conec.atualizaSaldoNoMySQL(agencia, Conta, this.Saldo);
      Operacoes lancamentoAtual = new Operacoes (TOper,DescOperacao,Data,Valor);
      Extrato.add(lancamentoAtual);
    }
    //////////////////////////////////////////////////////////////////
    public void imprimirExtrato(){
        Operacoes lancamento = new Operacoes();
        int n = Extrato.size();
        for (int i =0;i<n;i++){
            lancamento = Extrato.get(i);
            System.out.println(lancamento.getDataOperacao()+" - "+lancamento.getDescOperacao()+" "+Formata(lancamento.getValor()));
        }
        System.out.println("Saldo atual "+Formata(this.Saldo));
    }
    public void imprimirDados(){
        System.out.println("Agencia: "+this.Agencia);
        System.out.println("Conta: "+this.Conta);
        System.out.println("Data Abertura: "+this.DataAbertura);
    }

    public int getAgencia() {
        return Agencia;
    }

    public int getConta() {
        return Conta;
    }

    public String getDataAbertura() {
        return DataAbertura;
    }

    public double getSaldo() {
        return Saldo;
    }

    public List<Operacoes> getExtrato() {
        return Extrato;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public void setAgencia(int Agencia) {
        this.Agencia = Agencia;
    }

    public void setDataAbertura(String DataAbertura) {
        this.DataAbertura = DataAbertura;
    }
    

    
}
