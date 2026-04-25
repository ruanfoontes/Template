package src;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarefaDAO {

    
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS tarefas (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "nome VARCHAR(255) NOT NULL)";
        
        try (Connection conn = ConexaoBanco.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao preparar o cofre: " + e.getMessage());
        }
    }

    //Salva as Tarefas 
    public void salvarTarefa(String nome) {
        String sql = "INSERT INTO tarefas (nome) VALUES (?)";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
            System.out.println("Tarefa guardada no banco com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao guardar tarefa: " + e.getMessage());
        }
    }

    //lê tudo o que tem na Lista
    public ArrayList<Tarefa> listarTarefas() {
        ArrayList<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";

        try (Connection conn = ConexaoBanco.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                
                //mostra o ID para saber qual número apagar depois!
                System.out.print("[" + id + "] "); 
                
                Tarefa t = new Tarefa(nome);
                lista.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler do banco: " + e.getMessage());
        }
        return lista;
    }

    public void removerTarefa(int id) {
          String sql = "DELETE FROM tarefas WHERE id = ?";

          try (Connection conn = ConexaoBanco.conectar();
               PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);

                int linhas = pstmt.executeUpdate();

                if (linhas > 0) {
                  System.out.println("Sucesso: Tarefa removida!");
                } else {
                  System.out.println("Aviso: Nenhum item encontrado com esse ID.");
                }

               } catch (SQLException e) {
                System.out.println("Erro ao deletar no banco: " + e.getMessage());
               }
               
        }
}