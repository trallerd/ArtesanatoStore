package Model;

import java.io.Serializable;

public class Produto implements Serializable {
    private int idProduto;
    private String nome;
    private double valor;
    private String descricao;
    private String tamanho;
    private Categoria categoria;

    public Produto() {

    }

    public Produto(int idProduto, String nome, double valor, String descricao, String tamanho, Categoria categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome + valor + categoria.getIdCategoria();
    }
}
