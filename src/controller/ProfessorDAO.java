package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public ProfessorDAO() {
        con = Conexao.conectar();
    }
    
    public int inserir(Professor p) {
        try {
            String sql = "insert into tb_professor(nome, email, telefone, especialidade)"
                    + "values (?, ?, ?, ?)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            cmd.setString(1, p.getNome());
            cmd.setString(2, p.getEmail());
            cmd.setString(3, p.getTelefone());
            cmd.setString(4, p.getEspecialidade());
            
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
    
    public int atualizar(Professor p) {
        try {
            
            String sql = "update tb_professor set nome = ?, email = ?, telefone = ?, especialidade = ?"
                    + "where id = ?";
            
            cmd = con.prepareStatement(sql);
            cmd.setString(1, p.getNome());
            cmd.setString(2, p.getEmail());
            cmd.setString(3, p.getTelefone());
            cmd.setString(4, p.getEspecialidade());
            
            return cmd.executeUpdate() > 0 ? p.getId() : -1;
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }
    }
    
    public List<Professor> listar() {
        try {
            
            String sql = "select * from tb_professor order by nome";
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List<Professor> lista = new ArrayList<>();
            while (rs.next()) {
                Professor p = new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("especialidade")
                );
                lista.add(p);
            }
            return lista;
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
