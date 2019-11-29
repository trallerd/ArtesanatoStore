package Model.SQL;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

public class ProdutoSQL {
    private static ProdutoSQL instance = new ProdutoSQL();

    public static ProdutoSQL getInstance(){
        return instance;
    }


    private QueryRunner dbAccess = new QueryRunner();

    public long cadastrarProduto(Produto p) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        long id = dbAccess.insert(connection,"INSERT INTO Produto(nome,valor,descricao,tamanho,categoria) VALUES (?,?,?,?,?)",
                new ScalarHandler<BigInteger>(),p.getNome(),p.getValor(),p.getDescricao(),p.getTamanho(),p.getCategoria()).longValue();
        connection.close();
        return id;
    }
    public boolean deletarProduto(Produto p) throws SQLException{
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection,"DELETE FROM Produto where id=?",p.getIdProduto());
        connection.close();
        return true;
    }
    public List<Produto> buscaAtributo(ProdutoAtributoBusca atributo, Object valor) throws SQLException {
        String where = "";
        String valorWhere = "";

        switch (atributo) {
            case NOME:
                where = "where nome like ?";
                valorWhere = "%" + valor.toString() + "%";
                break;
        }

        Connection connection = FabricaConexao.getConnection();
        List<Produto> lista = dbAccess.query(connection, "SELECT * FROM Produto " + where,
                new BeanListHandler<Produto>(Produto.class), valorWhere);

        connection.close();

        return lista;
    }
    public List<Produto> buscaCategoria (int id)throws SQLException{
        Connection connection = FabricaConexao.getConnection();
        List<Produto> lista = dbAccess.query(connection,"SELECT * from Produto where categoria=?",id,new BeanListHandler<Produto>(Produto.class));
        return lista;
    }
    public ObservableList<Produto> listarProdutos() throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        ObservableList<Produto> lista = FXCollections.observableArrayList();

        PreparedStatement busca = connection.prepareStatement("select * from Produto");
        ResultSet bC = busca.executeQuery();

        while (bC.next()){
            int id = bC.getInt("idProduto");
            String nome = bC.getString("nome");
            double valor = bC.getDouble("valor");
            String descricao = bC.getString("descricao");
            String tamanho = bC.getString("tamanho");
            int categoria = bC.getInt("categoria");

            Produto c = new Produto(id,nome,valor,descricao,tamanho,categoria);
            lista.add(c);
        }
        connection.close();
        busca.close();
        bC.close();


        return lista;

    }
}
