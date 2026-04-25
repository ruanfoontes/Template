package src;
//Nesse Arquivo guarda-se dados do Banco de Dados desse Sistema 
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties; // ler o arquivo .properties
import java.io.FileInputStream; // para abrir o arquivo

public class ConexaoBanco {
    public static Connection conectar() {
        Properties props = new Properties();
        try {
            // Abre o arquivo
            FileInputStream fis = new FileInputStream("config/config.properties");
            // Lê o que está escrito lá
            props.load(fis);
            // Pega os valores (db.url, etc)
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.pass");

            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}
