package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
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
            String data_nascimento = a.getDataNascimento();
            LocalDate data = LocalDate.parse(data_nascimento);
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
    
}
