package model;

public class Aluno {
    
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;

    public Aluno() {
        this("","","","");
    }

    public Aluno(String nome, String email, String telefone, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
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
        return String.format("Nome: %s\nEmail: %s\nTelefone: %s\nData de Nascimento: %s\n", nome, email, telefone, dataNascimento);
    }
}
