package Model;

import java.io.Serializable;

public class Venda implements Serializable {
    private int idVenda;
    private double desconto;
    private double valorTotal;
    private int quantidade;
    private String data;
    private Usuario usuario;

    public Venda() {

    }

    public Venda(int idVenda, double desconto, double valorTotal, int quantidade, String data, Usuario usuario) {
        this.idVenda = idVenda;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
        this.data = data;
        this.usuario = usuario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
