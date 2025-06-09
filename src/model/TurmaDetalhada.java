package model;

public class TurmaDetalhada {
    
    private int id;
    private String nome;
    private String nomeCurso;
    private String nomeNivel;
    private String nomeProfessor;
    private String horario;

    public TurmaDetalhada(int id, String nome, String nomeCurso, String nomeNivel, String nomeProfessor, String horario) {
        this.id = id;
        this.nome = nome;
        this.nomeCurso = nomeCurso;
        this.nomeNivel = nomeNivel;
        this.nomeProfessor = nomeProfessor;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getNomeNivel() {
        return nomeNivel;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getHorario() {
        return horario;
    }
    
}
