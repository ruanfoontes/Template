//Nesse Arquivo guarda-se dados do Banco de Dados desse Sistema 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    //Endereço aonde o Arquivo do Banco vai Morar
    private static final String URL = "jdbc:h2:./dados/meubanco";

      //chave-> Usuario padrão chamado "sa"
    private static final String USUARIO = "sa";
    private static final String SENHA = "";

        //O "Ato de Abrir a Porta"
    public static Connection conectar() { //Connection-> Por onde a informação passa
        try { //DriverManager.getConnection-> é o java pegando a chave(URL) para entrar
            return DriverManager.getConnection(URL, USUARIO, SENHA); 
        } catch (SQLException e) {
            System.out.println("Erro ao ligar o banco: " + e.getMessage());
            return null;
            //try e catch avisa o erro 
        }
    }    
}
