package model;

public class Turma {
    
    private int id;
    private String nome;
    private int cursoId;
    private int nivelId;
    private int professorId;
    private String horario;

    public Turma() {
    }

    public Turma(int id, String nome, int cursoId, int nivelId, int professorId, String horario) {
        this.id = id;
        this.nome = nome;
        this.cursoId = cursoId;
        this.nivelId = nivelId;
        this.professorId = professorId;
        this.horario = horario;
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

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nNome: %s\n Curso Id: %d\nNível Id: %d\nProfessor Id: %d\nHorario: %s\n", 
                id, nome, cursoId, nivelId, professorId, horario
        );
    }
    
}
