package Model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private boolean AdmStatus;

    public Usuario() {

    }

    public Usuario(int id, String nome, String email, String senha, boolean admStatus) {
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        AdmStatus = admStatus;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmStatus() {
        return AdmStatus;
    }

    public void setAdmStatus(boolean admStatus) {
        AdmStatus = admStatus;
    }

    @Override
    public String toString() {
        return nome;
    }
}
