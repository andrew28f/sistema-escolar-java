package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Turma;
import model.TurmaDetalhada;

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
            cmd.setString(5, t.getHorario());
            
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
            String sql = "select * from tb_turma order by id";
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
    
    public List<TurmaDetalhada> listarPorNomes() {
        try {
            String sql = "select t.id, t.nome, c.nome as nome_curso,\n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id";
            cmd = con.prepareStatement(sql);
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
                        rs.getString("horario")
                );
                lista.add(t);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<TurmaDetalhada> pesquisarPorId(String idString) {
        try {
            int id = Integer.parseInt(idString);
            
            String sql = "select t.id, t.nome, c.nome as nome_curso, \n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id\n" +
                        "where t.id = ? order by id";
            cmd = con.prepareStatement(sql);
            cmd.setInt(1, id);
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
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
    
    public List<TurmaDetalhada> pesquisarPorNome(String nome) {
        try {
            String sql = "select t.id, t.nome, c.nome as nome_curso, \n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id\n" +
                        "where t.nome ilike ? order by id";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nome + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
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
    
    public List<TurmaDetalhada> pesquisarPorCurso(String curso) {
        try {
            String sql = "select t.id, t.nome, c.nome as nome_curso, \n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id\n" +
                        "where c.nome ilike ? order by id";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + curso + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
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
    
    public List<TurmaDetalhada> pesquisarPorNivel(String nivel) {
        try {
            String sql = "select t.id, t.nome, c.nome as nome_curso, \n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id\n" +
                        "where n.nome ilike ? order by id";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nivel + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
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
    
    public List<TurmaDetalhada> pesquisarPorProfessor(String professor) {
        try {
            String sql = "select t.id, t.nome, c.nome as nome_curso, \n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id\n" +
                        "where p.nome ilike ? order by id";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + professor + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
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
    
    public List<TurmaDetalhada> pesquisarPorHorario(String horario) {
        try {
            String sql = "select t.id, t.nome, c.nome as nome_curso, \n" +
                        "n.nome as nome_nivel, p.nome as nome_professor, t.horario\n" +
                        "from tb_turma t\n" +
                        "join tb_curso c on t.curso_id = c.id\n" +
                        "join tb_nivel n on t.nivel_id = n.id\n" +
                        "join tb_professor p on t.professor_id = p.id\n" +
                        "where horario ilike ? order by id";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + horario + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<TurmaDetalhada> lista = new ArrayList<>();
            while (rs.next()) {
                TurmaDetalhada t = new TurmaDetalhada(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nome_curso"),
                        rs.getString("nome_nivel"),
                        rs.getString("nome_professor"),
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
    
    public List listarHorarios() {
        try {
            String sql = "select distinct horario from tb_turma order by horario";
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(rs.getString("horario"));
            }
            return lista;
        } catch(SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
