package inter;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
       


public class ConexaoMySQL {
    
    /* Seção de atributos/variáveis iniciais  */
    private String caminho = "localhost";//Indica que usaremos o serve na máquina local
    private String porta = "3306"; // Porta padrão de conexão do MySQL Server
    private String nome = "bancoespiao"; // Nome da nossa base de dados
    private String usuario ="root";// Usuário padrão MySQL
    private String senha = "admin"; // Senha definida no momento da instalaçã odo MySQL
    private String FusoHorario = "?useTimeZone=true&serverTimezone=UTC";// Ajustar horário com a Oracle
    private String URL = "jdbc:mysql://"+caminho+":"+porta+"/"+nome+FusoHorario;

    public ConexaoMySQL() {
    }
  
    public Connection realizaConexaoMySQL(){
       try{
          return DriverManager.getConnection(URL,usuario,senha);
       }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu"+e+"","ERRO",JOptionPane.ERROR_MESSAGE) ;
          return null;
       }
    }
    ///////////////////////////////////////
    public void desconectaMySQL(Connection conexao){
        try{
          if (conexao !=null)  
              conexao.close();
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu"+e+"","ERRO",JOptionPane.ERROR_MESSAGE) ;
         }
    }
    ///////////////////////////////////////////
    public void insereContaCorrenteNoMySQL(int agencia, int conta, String dataAbertura,
                                          double valorSaldo, double valorLimite, double valorMensalidade){
        
        Connection conexao = realizaConexaoMySQL();
        
        String sql_bancaria="insert into contabancaria (NumeroConta, Agencia, Saldo, DataAbertura) values (?,?,?,?)";
        String sql_corrente="insert into contacorrente (NumeroConta, Limite, Mensalidade) values (?,?,?)";
        try{//Aqui serão aplicados todos os recursos para efetivar a inserção no MySQL
            PreparedStatement Atuador_bancaria = conexao.prepareStatement(sql_bancaria);
            PreparedStatement Atuador_corrente = conexao.prepareStatement(sql_corrente);
            
            /*Seção para setar os campos npo atuador  */
            Atuador_bancaria.setInt(1, conta);//Substitui a primeira interrogação no insert into de bancaria
            Atuador_bancaria.setInt(2, agencia);//Substitui a segunda interrogação no insert into de bancaria
            Atuador_bancaria.setDouble(3, valorSaldo); // Substitui a terceira interrogação
            Atuador_bancaria.setString(4, dataAbertura);
            Atuador_bancaria.execute();//Executa diretamente no MySQL
            
            Atuador_corrente.setInt(1, conta);
            Atuador_corrente.setDouble(2, valorLimite);
            Atuador_corrente.setDouble(3, valorMensalidade);
            Atuador_corrente.execute();//Executa diretamente no MySQL
            
           desconectaMySQL(conexao);
           
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu"+e+"","ERRO",JOptionPane.ERROR_MESSAGE) ;
         }
    }
    
    
public Corrente buscaContaCorrente(int agencia, int conta){
        Connection conexao = realizaConexaoMySQL();
        Corrente conta_atual = new Corrente();//Cria objeto para guardar a conta corrente encontrada, caso exista no MySQL
        conta_atual=null;
        try{
            String sql_selecao_conta ="SELECT *FROM bancoespiao.contabancaria, bancoespiao.contacorrente where contabancaria.NumeroConta=contacorrente.NumeroConta AND contabancaria.Agencia="+agencia+" AND contacorrente.NumeroConta="+conta+";";
            PreparedStatement atuador_selecao_conta = conexao.prepareStatement(sql_selecao_conta);
            ResultSet ResultadoSelecao = atuador_selecao_conta.executeQuery();
        
            while(ResultadoSelecao.next()){
                Corrente ObjetoConta = new Corrente(); //Cria objeto para copiar os dados do MySQL
                ObjetoConta.setSaldo(ResultadoSelecao.getDouble("Saldo"));
                ObjetoConta.setAgencia(ResultadoSelecao.getInt("Agencia"));
                ObjetoConta.setDataAbertura(ResultadoSelecao.getString("DataAbertura"));
                ObjetoConta.setLimite(ResultadoSelecao.getDouble("Limite"));
                ObjetoConta.setMensalidadeManutencao(ResultadoSelecao.getDouble("Mensalidade"));
                conta_atual = ObjetoConta;//Adiciona a objeto de Conta Corrente o Objeto Atual
            }
            ResultadoSelecao.close();
            atuador_selecao_conta.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu:"+e+"","Erro",JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao);
        return conta_atual;
    }
    
   
    public void insereExtratoNoMySQL(int conta, String dataOperacao, int tipoOper, double valorOperacao, String descOper){
        Connection conexao = realizaConexaoMySQL();
        String sql_extrato ="insert into operacoes (NumContExtrato ,TipoOperacao , Valor , DataOperacao, DescricaoOperacao) values (?,?,?,?,?)";
        try{//Aqui serão aplicados todos os recursos para efetivar a inserção dos dados na Tabela Operações do MySQL
            PreparedStatement Atuador_extrato = conexao.prepareStatement(sql_extrato);
            /*Seção para setar os campos no atuador */
            Atuador_extrato.setInt(1, conta);
            Atuador_extrato.setInt(2, tipoOper);
            Atuador_extrato.setDouble(3, valorOperacao);
            Atuador_extrato.setString(4, dataOperacao);
            Atuador_extrato.setString(5, descOper);
            Atuador_extrato.execute();//Nesse momento estará sendo lançado o comando insert into "fisicamente" no MySQL
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu:"+e+"","Erro",JOptionPane.ERROR_MESSAGE);
         }
        desconectaMySQL(conexao);
    }
    ////////////////////////////////////////////////
    public void atualizaSaldoNoMySQL(int agencia,int conta, double valor){
     Connection conexao = realizaConexaoMySQL();
     String sql_atualiza_saldo = "update bancoespiao.contabancaria set Saldo='"+valor+"' where Agencia="+agencia+" AND NumeroConta="+conta+";";
     try{
        PreparedStatement atuador = conexao.prepareStatement(sql_atualiza_saldo);
        atuador.executeUpdate();
        atuador.close();      
         
     }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu:"+e+"","Erro",JOptionPane.ERROR_MESSAGE);
         }
        desconectaMySQL(conexao);
    }
    
}
