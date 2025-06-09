package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Curso;

public class CursoDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public CursoDAO() {
        con = Conexao.conectar();
    }
    
    public int inserir(Curso c) {
        try {
            String sql = "insert into tb_curso(nome, carga_horaria, descricao)"
                    + "values (?, ?, ?)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            cmd.setString(1, c.getNome());
            cmd.setInt(2, c.getCargaHoraria());
            cmd.setString(3, c.getDescricao());
            
            if (cmd.executeUpdate() > 0) {
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next() ? rs.getInt(1) : -1;
            }
            
            return -1;
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }
    }
    
}
