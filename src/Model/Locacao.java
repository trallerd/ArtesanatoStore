package Model;

import java.io.Serializable;

public class Locacao implements Serializable {
    private int idLocacao;
    private String dataLocacao;
    private String dataEntrega;
    private int produto;
    private int usuario;

    public Locacao() {

    }

    public Locacao(int idLocacao, String dataLocacao, String dataEntrega,  int produto, int usuario) {
        this.idLocacao = idLocacao;
        this.dataLocacao = dataLocacao;
        this.dataEntrega = dataEntrega;
        this.produto = produto;
        this.usuario = usuario;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
