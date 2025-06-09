package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Curso> listar() {
        try {
            String sql = "select * from tb_curso order by nome";
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List<Curso> lista = new ArrayList<>();
            while (rs.next()) {
                Curso c = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getString("descricao")
                );
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Curso> pesquisarPorId(String id) {
        try {
            int Id = Integer.parseInt(id);
            
            String sql = "select * from tb_curso where id = ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setInt(1, Id);
            ResultSet rs = cmd.executeQuery();
            List<Curso> lista = new ArrayList<>();
            while (rs.next()) {
                Curso c = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getString("descricao")
                );
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Curso> pesquisarPorNome(String nome) {
        try {
            String sql = "select * from tb_curso where nome ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nome + "%");
            ResultSet rs = cmd.executeQuery();
            List<Curso> lista = new ArrayList<>();
            while (rs.next()) {
                Curso c = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getString("descricao")
                );
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Curso> pesquisarPorCargaHoraria(String cargaHoraria) {
        try {
            int CargaHoraria = Integer.parseInt(cargaHoraria);
            
            String sql = "select * from tb_curso where carga_horaria = ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setInt(1, CargaHoraria);
            ResultSet rs = cmd.executeQuery();
            List<Curso> lista = new ArrayList<>();
            while (rs.next()) {
                Curso c = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getString("descricao")
                );
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
