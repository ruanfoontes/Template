import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class TarefaDAO {
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS tarefas (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "nome VARCHAR(255) NOT NULL)";

         try (Connection conn = ConexaoBanco.conectar();
              Statement stmt = conn.createStatement()) {

                stmt.execute(sql);
                System.out.println("Tabela pronta para uso!");

              } catch (SQLException e) {
                System.out.println("Erro ao criar Tabela: " + e.getMessage());
              }         
    }
}
