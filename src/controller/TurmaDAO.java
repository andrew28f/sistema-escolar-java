package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Turma;

public class TurmaDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public TurmaDAO() {
        con = Conexao.conectar();
    }
    
    public int inserir(Turma t) {
        try {
            String sql = "insert into tb_turma(nome, curso_id, nivel_id, professor_id, horario)"
                    + "values (?, ?, ?, ?, ?)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            cmd.setString(1, t.getNome());
            cmd.setInt(2, t.getCursoId());
            cmd.setInt(3, t.getNivelId());
            cmd.setInt(4, t.getProfessorId());
            cmd.setString(4, t.getHorario());
            
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
