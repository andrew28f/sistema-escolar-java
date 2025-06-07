package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    // PARÂMETROS
    private static final String USUARIO = "postgres";
    private static final String SENHA = "password12345";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/EscolaIdiomas";
    private static final String DRIVER = "org.postgresql.Driver";
    
    // Estabelecer a conexão entre o APP e o SGBD
    public static Connection conectar() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e){
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
