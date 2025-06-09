package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Nivel;

public class NivelDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public NivelDAO() {
        con = Conexao.conectar();
    }
    
    public int inserir(Nivel n) {
        try {
            String sql = "insert into tb_nivel(nome, descricao, requisitos)"
                    + "values (?, ?, ?)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            cmd.setString(1, n.getNome());
            cmd.setString(2, n.getDescricao());
            cmd.setString(3, n.getRequisitos());
            
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
    
    public List<Nivel> listar() {
        try {
            String sql = "select * from tb_nivel order by nome";
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List<Nivel> lista = new ArrayList<>();
            while (rs.next()) {
                Nivel n = new Nivel(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("requisitos")
                );
                lista.add(n);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
}
