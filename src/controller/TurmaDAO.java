package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Turma> listar() {
        try {
            String sql = "select * from tb_turma order by nome";
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> listarPorNomes() {
        try {
            String sql = "select t.id as id_turma,"
                    + "t.nome as nome_turma,"
                    + "c.nome as nome_curso,"
                    + "n.nome as nome_nivel,"
                    + "p.nome as nome_professor,"
                    + "t.horario as horario_turma"
                    + "from tb_turma t"
                    + "join tb_curso c on t.curso_id = c.id"
                    + "join tb_nivel n on t.nivel_id = n.id"
                    + "join tb_professor p on t.professor_id = p.id";
            cmd = con.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            List lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                    new Object[] {
                        rs.getInt("id_turma"),
                        rs.getString("nome"),
                        rs.getInt("nome_curso"),
                        rs.getInt("nome_nivel"),
                        rs.getInt("nome_professor"),
                        rs.getString("horario_turma")
                    }
                );
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> pesquisarPorId(String id) {
        try {
            int Id = Integer.parseInt(id);
            
            String sql = "select * from tb_turma where id = ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setInt(1, Id);
            
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> pesquisarPorNome(String nome) {
        try {
            String sql = "select * from tb_turma where nome ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nome + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> pesquisarPorCursoId(String cursoId) {
        try {
            String sql = "select * from tb_turma where curso_id ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + cursoId + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> pesquisarPorNivelId(String nivelId) {
        try {
            String sql = "select * from tb_turma where nivel_id ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nivelId + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> pesquisarPorProfessorId(String professorId) {
        try {
            String sql = "select * from tb_turma where professor_id ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + professorId + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Turma> pesquisarPorHorario(String horario) {
        try {
            String sql = "select * from tb_turma where horario ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + horario + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Turma> lista = new ArrayList<>();
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("professor_id"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
