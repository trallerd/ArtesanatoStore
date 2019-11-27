package Model.Gerenciadores;

import Model.Categoria;
import Model.Produto;
import Model.ProdutoAtributoBusca;
import Model.SQL.ProdutoSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class GerenciaProduto {
    private ObservableList<Produto> produtos;
    private ProdutoSQL produtoSQL = new ProdutoSQL();

    private static GerenciaProduto instance = new GerenciaProduto();


    private GerenciaProduto(){
        produtos = FXCollections.observableArrayList();
    }

    public static GerenciaProduto getInstance(){
        return instance;
    }


    public void cadastrarProduto(String nome, double valor,String descricao, String tamanho, Categoria categoria) throws SQLException {
        Produto a = new Produto();
        a.setNome(nome);
        a.setValor(valor);
        a.setDescricao(descricao);
        a.setTamanho(tamanho);
        a.setCategoria(categoria.getIdCategoria());

        long id = produtoSQL.cadastrarProduto(a);
        a.setIdProduto((int)id);
        produtos.add(a);
    }
    public ObservableList<Produto> listaProdutos(String text)throws SQLException{
       produtos.clear();
       List<Produto> lista = produtoSQL.buscaAtributo(ProdutoAtributoBusca.NOME,text);
       produtos.addAll(lista);
       return produtos;
    }
    public ObservableList<Produto> buscaCategoria(Categoria c)throws SQLException{
        produtos.clear();
        List<Produto> lista = produtoSQL.buscaCategoria(c.getIdCategoria());
        produtos.addAll(lista);
        return produtos;
    }
    public ObservableList listaProdutos() throws SQLException{
        produtos.clear();
        produtos.addAll(produtoSQL.listarProdutos());
        return produtos;
    }

}
