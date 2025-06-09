package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;

public class UsuarioDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public UsuarioDAO() {
        con = Conexao.conectar();
    }
    
    public int inserir(Usuario u) {
        try {
            
            // Instrução SQL para inserção de dados
            String sql = "insert into tb_usuario(nome, email, senha) values (?, ?, MD5(?))";

            // Verificação da sintaxe do comando sql
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            // Especificação de parâmetros da instrução sql
            cmd.setString(1, u.getNome());
            cmd.setString(2, u.getEmail());
            cmd.setString(3, u.getSenha());
            
            // Execução da instrução sql
            if (cmd.executeUpdate() > 0) {
                // Retorna chave primária (ID) do usuário
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next() ? rs.getInt(1) : -1;
            }
            
            // Retorna -1 se algo der errado
            return -1;
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }
    }
    
}
