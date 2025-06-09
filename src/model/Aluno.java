package model;

public class Aluno {
    
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;

    public Aluno() {
        this(0,"","","","");
    }

    public Aluno(int id, String nome, String email, String telefone, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nNome: %s\nEmail: %s\nTelefone: %s\nData de Nascimento: %s\n", id, nome, email, telefone, dataNascimento);
    }
}
