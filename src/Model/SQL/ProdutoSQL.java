package Model.SQL;

import Model.*;
import javafx.collections.ObservableList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
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
                new ScalarHandler<Integer>(),p.getNome(),p.getValor(),p.getDescricao(),p.getTamanho(),p.getCategoria()).longValue();
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
        List<Produto> lista = dbAccess.query(connection,"SELECT * from Produto where id=?",id,new BeanListHandler<Produto>(Produto.class));
        return lista;
    }
}
