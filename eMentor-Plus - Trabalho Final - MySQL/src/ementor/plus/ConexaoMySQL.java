/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ementor.plus;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Luiz Fillipe
 */
public class ConexaoMySQL {
   
    
    
    
        /* Seção de atributos/variáveis iniciais  */
    private String caminho = "localhost";//Indica que usaremos o serve na máquina local
    private String porta = "3306"; // Porta padrão de conexão do MySQL Server
    private String nome = "ementor"; // Nome da nossa base de dados
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
        
    public void desconectaMySQL(Connection conexao){
        try{
            if (conexao !=null)  
                conexao.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu"+e+"","ERRO",JOptionPane.ERROR_MESSAGE) ;
         }
    }

    PreparedStatement prepareStatement(String sql_selecao_conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void inserirProfessorDadosNoMYSQL (String nome, String CPF,String telefone,String dataNascimento,String dataAdmissao,double salarioBruto){
        Connection conexao = realizaConexaoMySQL();  
        String sql_pessoa = "insert into pessoa (nome,CPF,Telefone,dataNascimento) values (?,?,?,?)";
        String sql_professor = "insert into professores (nome,CPF, dataAdmissao,salarioBruto) values (?,?,?,?)";


    try{
        PreparedStatement atuador_pessoa = conexao.prepareStatement(sql_pessoa);
        atuador_pessoa.setString(1,nome);
        atuador_pessoa.setString(2,CPF);
        atuador_pessoa.setString(3,telefone);
        atuador_pessoa.setString(4,dataNascimento);
        atuador_pessoa.execute(); 
       
        PreparedStatement atuador_professor = conexao.prepareStatement(sql_professor);
        atuador_professor.setString(1,nome);
        atuador_professor.setString(2,CPF);
        atuador_professor.setString(3,dataAdmissao);
        atuador_professor.setDouble(4,salarioBruto);
        atuador_professor.execute();
 
        JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);    
      }
        desconectaMySQL(conexao);
}
    
    public ArrayList<Professor> listaProfessoresSQL(String tipoOrdenacao){
        Connection conexao = realizaConexaoMySQL();//Estabelce conexao 
        ArrayList<Professor> professoresLista = new ArrayList();//Cria uma lista com os dados dos professores
       
        try{
            
            String sql_selecao_professor = "SELECT pessoa.nome, pessoa.CPF, pessoa.dataNascimento, pessoa.telefone, professores.dataAdmissao, professores.salarioBruto FROM pessoa, professores WHERE pessoa.CPF = professores.CPF ORDER BY "+tipoOrdenacao;
            PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
            ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery();// è aqui que fica o resultado da Seleçao do MYSQL
            /*Seçao para percorrer todas as linhas resultantes da seleçao.Logo deve-se usar um laço de repetiçai */
            
            while(ResultadoSelecao.next()){//laço de repetiçao para percorrer todo conjunto de resultados  "ResultSet" trazidos pela Query
                Professor ObjetoProfessor = new Professor();//Cria objeto professor
               /* Seçao para inserir em todos os atributos do objetoAluno os valores dos campos do MYSQL */
                ObjetoProfessor.CPF = ResultadoSelecao.getString("CPF");
                ObjetoProfessor.nome = ResultadoSelecao.getString("nome");
                ObjetoProfessor.dataDeNascimento = ResultadoSelecao.getString("dataNascimento");
                ObjetoProfessor.telefone = ResultadoSelecao.getString("telefone");
                ObjetoProfessor.setDataDeAdmissao(ResultadoSelecao.getString("dataAdmissao"));
                ObjetoProfessor.setSalarioBruto(ResultadoSelecao.getDouble("salarioBruto"));

               professoresLista.add(ObjetoProfessor);// Adiciona a lista do Objeto atual 
            }
               ResultadoSelecao.close();
               atuador_selecao_professor.close();
               
       }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
          return null;
      }
      desconectaMySQL(conexao);
      return professoresLista;
    }
    public Professor buscaProfesor(String CPF){
        Connection conexao = realizaConexaoMySQL(); 
        Professor Objeto = new Professor();
        Objeto = null;
        try{
            String sql_selecao_professor = "SELECT *FROM ementor.pessoa, ementor.professores where pessoa.CPF = professores.CPF and pessoa.CPF='"+CPF+"';";
            PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
            ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery();
            while(ResultadoSelecao.next()){
                Professor ObjetoProfessor = new Professor();
                ObjetoProfessor.CPF = ResultadoSelecao.getString("CPF");
                ObjetoProfessor.nome = ResultadoSelecao.getString("nome");
                ObjetoProfessor.dataDeNascimento = ResultadoSelecao.getString("dataNascimento");
                ObjetoProfessor.telefone = ResultadoSelecao.getString("telefone");
                ObjetoProfessor.setDataDeAdmissao(ResultadoSelecao.getString("dataAdmissao"));
                ObjetoProfessor.setSalarioBruto(ResultadoSelecao.getDouble("salarioBruto"));
                Objeto = ObjetoProfessor;
            }
            ResultadoSelecao.close();
            atuador_selecao_professor.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
        }
            desconectaMySQL(conexao);
            return Objeto;
    }
    
    
    
    public void atualizarProfessorDadosNoMySQL(String CPF,String dataAdmissao,String nome,String telefone,String dataDeNascimento,Double salarioBruto){
        Connection conexao = realizaConexaoMySQL(); 
        Professor teacher = new Professor();
        teacher = null;
        String sql = "update ementor.pessoa set nome='"+nome+"', telefone='"+telefone+"', dataNascimento='"+dataDeNascimento+"' where pessoa.CPF='"+CPF+"';";
        String sql_professores = "update ementor.professores set nome = '"+nome+"', dataAdmissao = '"+dataAdmissao+"', salarioBruto = '"+salarioBruto+"' where CPF = '"+CPF+"';";
        try{
            PreparedStatement atuador = conexao.prepareStatement(sql);
            atuador.executeUpdate();
            
            
            PreparedStatement atuador_professores = conexao.prepareStatement(sql_professores);
            atuador_professores.executeUpdate();
            atuador_professores.close();
            
            JOptionPane.showMessageDialog(null,"Dados Atualizados com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
      }
            desconectaMySQL(conexao);
    }

    public void inserirAlunosDadosNoMYSQL (String nome, String CPF,String telefone,String dataNascimento,String matricula,String periodo){
        Connection conexao = realizaConexaoMySQL();  
        String sql_pessoa = "insert into pessoa (nome,CPF,Telefone,dataNascimento) values (?,?,?,?)";
        String sql_aluno = "insert into alunos (nome,CPF, matricula, periodo) values (?,?,?,?)";


    try{
        PreparedStatement atuador_pessoa = conexao.prepareStatement(sql_pessoa);
        atuador_pessoa.setString(1,nome);
        atuador_pessoa.setString(2,CPF);
        atuador_pessoa.setString(3,telefone);
        atuador_pessoa.setString(4,dataNascimento);
        atuador_pessoa.execute(); 
       
        PreparedStatement atuador_aluno = conexao.prepareStatement(sql_aluno);
        atuador_aluno.setString(1,nome);
        atuador_aluno.setString(2,CPF);
        atuador_aluno.setString(3,matricula);
        atuador_aluno.setString(4,periodo);
        atuador_aluno.execute();
 
        JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);    
      }
        desconectaMySQL(conexao);
}
        public ArrayList<Aluno> listaAlunosSQL(String tipoOrdenacao){
        Connection conexao = realizaConexaoMySQL();//Estabelce conexao 
        ArrayList<Aluno> alunoLista = new ArrayList();//Cria uma lista com os dados dos professores
       
        try{
            
            String sql_selecao_aluno = "SELECT pessoa.nome, pessoa.CPF, pessoa.dataNascimento, pessoa.telefone, alunos.matricula, alunos.periodo FROM pessoa, alunos WHERE pessoa.CPF = alunos.CPF ORDER BY "+tipoOrdenacao;
            PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
            ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery();// è aqui que fica o resultado da Seleçao do MYSQL
            /*Seçao para percorrer todas as linhas resultantes da seleçao.Logo deve-se usar um laço de repetiçai */
            
            while(ResultadoSelecao.next()){//laço de repetiçao para percorrer todo conjunto de resultados  "ResultSet" trazidos pela Query
                Aluno ObjetoAluno = new Aluno();//Cria objeto professor
               /* Seçao para inserir em todos os atributos do objetoAluno os valores dos campos do MYSQL */
                ObjetoAluno.CPF = ResultadoSelecao.getString("CPF");
                ObjetoAluno.nome = ResultadoSelecao.getString("nome");
                ObjetoAluno.dataDeNascimento = ResultadoSelecao.getString("dataNascimento");
                ObjetoAluno.telefone = ResultadoSelecao.getString("telefone");
                ObjetoAluno.setMatricula(ResultadoSelecao.getString("matricula"));
                ObjetoAluno.setPeriodo(ResultadoSelecao.getString("periodo"));

               alunoLista.add(ObjetoAluno);// Adiciona a lista do Objeto atual 
            }
               ResultadoSelecao.close();
               atuador_selecao_aluno.close();
               
       }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
          return null;
      }
      desconectaMySQL(conexao);
      return alunoLista;
    }
        
    public Aluno buscaAluno(String CPF){
        Connection conexao = realizaConexaoMySQL(); 
        Aluno Objeto = new Aluno();
        Objeto = null;
        try{
            String sql_selecao_professor = "SELECT *FROM ementor.pessoa, ementor.alunos where pessoa.CPF = alunos.CPF and pessoa.CPF='"+CPF+"';";
            PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
            ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery();
            while(ResultadoSelecao.next()){
                Aluno ObjetoAluno = new Aluno();
                ObjetoAluno.CPF = ResultadoSelecao.getString("CPF");
                ObjetoAluno.nome = ResultadoSelecao.getString("nome");
                ObjetoAluno.dataDeNascimento = ResultadoSelecao.getString("dataNascimento");
                ObjetoAluno.telefone = ResultadoSelecao.getString("telefone");
                ObjetoAluno.setMatricula(ResultadoSelecao.getString("matricula"));
                ObjetoAluno.setPeriodo(ResultadoSelecao.getString("periodo"));
                Objeto = ObjetoAluno;
            }
            ResultadoSelecao.close();
            atuador_selecao_professor.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
        }
            desconectaMySQL(conexao);
            return Objeto;
    }
    public void atualizarAlunoDadosNoMySQL(String CPF,String matricula,String nome,String telefone,String dataDeNascimento,String periodo){
        Connection conexao = realizaConexaoMySQL(); 
        Aluno Objeto = new Aluno();
        Objeto = null;
        String sql = "update ementor.pessoa set nome='"+nome+"', telefone='"+telefone+"', dataNascimento='"+dataDeNascimento+"' where pessoa.CPF='"+CPF+"';";
        String sql_alunos = "update ementor.alunos set nome = '"+nome+"', matricula = '"+matricula+"', periodo = '"+periodo+"' where CPF = '"+CPF+"';";
        try{
            PreparedStatement atuador = conexao.prepareStatement(sql);
            atuador.executeUpdate();
            
            
            PreparedStatement atuador_alunos = conexao.prepareStatement(sql_alunos);
            atuador_alunos.executeUpdate();
            atuador_alunos.close();
            
            JOptionPane.showMessageDialog(null,"Dados Atualizados com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
      }
            desconectaMySQL(conexao);
    }

}
