package model;

public class Nivel {
    
    private int id;
    private String nome;
    private String descricao;
    private String requisitos;

    public Nivel() {
        this(0, "", "", "");
    }

    public Nivel(int id, String nome, String descricao, String requisitos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.requisitos = requisitos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
