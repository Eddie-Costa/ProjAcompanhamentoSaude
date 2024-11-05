
package Control;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Controle_Usuario {
    ResultSet rs;
    PreparedStatement sql;
    Statement comando;
    Connection conexao;
    
    Usuario user = new Usuario();
   
    public void Conexao(){
        try{
            // Variáveis com os dados da conexão ao BD
            String nomeservidor = "localhost:3306";
            String nomebanco = "AcompanhamentoSaude";
            String nomeusuario = "root";
            String senha= "";
            // especificação do driver a ser utilizado
            String nomedriver = "com.mysql.cj.jdbc.Driver";
            // ativa o driver
            Class.forName(nomedriver);
            // Criando a conexão ao Banco
            String url = "jdbc:mysql://"+nomeservidor+"/"+nomebanco+"?useTimezone=true&serverTimezone=UTC";
            conexao=DriverManager.getConnection(url,nomeusuario,senha);
            comando = conexao.createStatement();
            
        }
        catch (ClassNotFoundException e)
	     {
	       JOptionPane.showMessageDialog(null,"Driver não encontrado!");
             }
        catch (Exception e){
               JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }

    }
    public void Cadastrar(String p_nome, int p_idade, double p_peso, double p_altura, double p_pa, double p_glicemia, double p_colesterol, double p_Creatinina, int p_freq, double p_imc, String p_remed){
        user.setNome(p_nome);
        user.setIdade(p_idade);
        user.setAltura(p_altura);
        user.setPA(p_pa);
        user.setGlicemia(p_glicemia);
        user.setColesterol(p_colesterol);
        user.setCreatinina(p_Creatinina);
        user.setFrequenciaAcad(p_freq);
        user.CalcularIMC(p_altura, p_peso);
        user.setRemediosDiarios(p_remed);
        try{
        sql = conexao.prepareStatement("Insert into Usuario (Nome, Idade, Peso, Altura, PA, Glicemia, Colesterol, Creatinina, FrequenciaAcad, Imc, RemediosDiarios)"+
                "values (?,?,?,?,?,?,?,?,?,?,?)");
        sql.setString(1, user.getNome());
        sql.setInt(2, user.getIdade());
        sql.setDouble(3, user.getPeso());
        sql.setDouble(4, user.getAltura());
        sql.setDouble(5, user.getPA());
        sql.setDouble(6, user.getGlicemia());
        sql.setDouble(7, user.getColesterol());
        sql.setDouble(8, user.getCreatinina());
        sql.setInt(9, user.getFrequenciaAcad());
        sql.setDouble(10, user.getIMC());
        sql.setString(11, user.getRemediosDiarios());
        int reg = sql.executeUpdate();
        if (reg !=0){
            JOptionPane.showMessageDialog(null,"Dados cadastrados !!!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Erro Sql !!!");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao conectar Banco de Dados !!!");
        }
        
    }
    
    public void Listar(){
        try{
        // objeto sql recebe a instrução a ser executada
        sql=conexao.prepareStatement("select * from Usuario");
        // rs recebe uma lista de retorno pelo executequery
        rs=sql.executeQuery();
        // percorre a lista (enquanto houver o próximo)
        while(rs.next()){
            // rs busca cada registro da lista pelo nome do campo da tabela
            JOptionPane.showMessageDialog(null, "Nome: "+rs.getString("Nome")+ "\n Idade: "+rs.getInt("Idade")+
                    "\n Peso: "+rs.getDouble("Peso")+"\n Altura: "+rs.getDouble("Altura")+"\n Pressão Arterial: "+rs.getDouble("PA")+"\n Glicemia: "+rs.getDouble("Glicemia")+ "\n Colesterol: "+rs.getDouble("Colesterol")+ "\n Creatinina"+rs.getDouble("Creatinina")+ "\n Frequencia na Academia: "+rs.getInt("FrequenciaAcad")+ "\n IMC: " +rs.getDouble("Imc")+ "\n Remedios Diarios: "+rs.getString("RemediosDiarios"));
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao conectar Banco de Dados !!!");
        }
    }
   
      public String Consultar(int numrgm){
          String dados="";
          try{
              sql = conexao.prepareStatement("Select * from alunos where rgm = ?");
              sql.setInt(1, numrgm);
              rs = sql.executeQuery();
              if (rs.next()){
                  dados+=rs.getString("nome_aluno");
                  dados+=";";
                  dados+=rs.getString("nota1");
                  dados+=";";
                  dados+=rs.getString("nota2");
              }
              else{
                   JOptionPane.showMessageDialog(null,"rgm não encontrado");
              }
              
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(null,"Erro ao conectar Banco de Dados !!!");
          }
          return dados;
      } 
    
    
    public void Alterar(int numrgm, String nm, double n1, double n2){
        try{
            sql = conexao.prepareStatement("update alunos set nome_aluno='"+nm+"', nota1='"+n1+"', nota2='"+n2+"' where rgm="+numrgm);
            int verifica=sql.executeUpdate();
            if(verifica>0){
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Registro não alterado !!!");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar Banco de dados");
        }
    }
    
    public void Excluir(int numrgm){
        try{
            sql = conexao.prepareStatement("delete from alunos where rgm="+numrgm);
            int verifica = sql.executeUpdate();
            if (verifica>0){
                JOptionPane.showMessageDialog(null, "Sucesso!!!");
            }else{
                JOptionPane.showMessageDialog(null, "Exclusão não sucedida!!!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar Banco de dados");
        }
    }
}
