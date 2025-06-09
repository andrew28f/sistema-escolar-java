package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public AlunoDAO() {
        con = Conexao.conectar();
    }
    
    public int inserir(Aluno a) {
        try {
            String sql = "insert into tb_aluno(nome, email, telefone, data_nascimento)"
                    + "values (?, ?, ?, ?)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            cmd.setString(1, a.getNome());
            cmd.setString(2, a.getEmail());
            cmd.setString(3, a.getTelefone());
            
            // Formata data de nascimento para inserção no banco de dados
            String dataNascimento = a.getDataNascimento();
            LocalDate data = LocalDate.parse(dataNascimento);
            Date sqlData = Date.valueOf(data);
            
            cmd.setDate(4, sqlData);
            
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
    
    public int atualizar(Aluno a) {
        try {
            
            String sql = "update tb_aluno set nome = ?, email = ?, telefone = ?, data_nascimento = ? where id = ?";
            cmd = con.prepareStatement(sql);
            
            cmd.setString(1, a.getNome());
            cmd.setString(2, a.getEmail());
            cmd.setString(3, a.getTelefone());
            
            String dataNascimento = a.getDataNascimento();
            LocalDate data = LocalDate.parse(dataNascimento);
            Date sqlData = Date.valueOf(data);
            cmd.setDate(4, sqlData);
            
            cmd.setInt(5, a.getId());
            
            return cmd.executeUpdate() > 0 ? a.getId() : -1;
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }
    }
    
    public List<Aluno> listar() {
        try {
            
            String sql = "select * from tb_aluno order by nome";
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            
            List<Aluno> lista = new ArrayList<>();
            while (rs.next()) {
                
                // Recupera como java.sql.Date e converte para LocalDate
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                
                // Formata dataNascimento para String
                String data = dataNascimento.toString();
                
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        data
                );
                lista.add(a);
            }
            
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aluno> pesquisarPorId(String id) {
        try {
            int Id = Integer.parseInt(id);
            
            String sql = "select * from tb_aluno where id = ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setInt(1, Id);
            
            ResultSet rs = cmd.executeQuery();
            List<Aluno> lista = new ArrayList<>();
            while (rs.next()) {
                
                // Recupera como java.sql.Date e converte para LocalDate
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                
                // Formata dataNascimento para String
                String data = dataNascimento.toString();
                
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        data
                );
                lista.add(a);
            }
            
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aluno> pesquisarPorNome(String nome) {
        try {
            String sql = "select * from tb_aluno where nome ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nome + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Aluno> lista = new ArrayList<>();
            while (rs.next()) {
                
                // Recupera como java.sql.Date e converte para LocalDate
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                
                // Formata dataNascimento para String
                String data = dataNascimento.toString();
                
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        data
                );
                lista.add(a);
            }
            
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aluno> pesquisarPorEmail(String email) {
        try {
            String sql = "select * from tb_aluno where email ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + email + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Aluno> lista = new ArrayList<>();
            while (rs.next()) {
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                String data = dataNascimento.toString();
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        data
                );
                lista.add(a);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aluno> pesquisarPorTelefone(String telefone) {
        try {
            String sql = "select * from tb_aluno where telefone ilike ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + telefone + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Aluno> lista = new ArrayList<>();
            while (rs.next()) {
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                String data = dataNascimento.toString();
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        data
                );
                lista.add(a);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<Aluno> pesquisarPorData(String dataParametro) {
        try {
            String sql = "select * from tb_aluno where data_nascimento = ? order by nome";
            cmd = con.prepareStatement(sql);
            cmd.setString(1, dataParametro);
            
            ResultSet rs = cmd.executeQuery();
            List<Aluno> lista = new ArrayList<>();
            while (rs.next()) {
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                String data = dataNascimento.toString();
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        data
                );
                lista.add(a);
            }
            return lista;
                
        } catch(Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
