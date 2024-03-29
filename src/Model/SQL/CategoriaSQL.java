package Model.SQL;

import Model.Categoria;
import Model.FabricaConexao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoriaSQL {
    private static CategoriaSQL instance = new CategoriaSQL();

    public static CategoriaSQL getInstance(){
        return instance;
    }


    private QueryRunner dbAccess = new QueryRunner();

    public long addCategoria(Categoria t) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        long id = dbAccess.insert(connection,"INSERT INTO Categoria(nome) VALUES (?)",
                new ScalarHandler<BigInteger>(),t.getNome()).longValue();
        connection.close();

        return id;
    }
    public Categoria buscaCategoria(int id) throws SQLException {
        Connection connection = FabricaConexao.getConnection();

        Categoria p =dbAccess.query(connection,"SELECT * FROM Categoria WHERE idCategoria=?",
                new BeanHandler<Categoria>(Categoria.class),id);

        connection.close();
        return p;
    }
    public boolean deletCategoria(Categoria p) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection,"DELETE FROM Categoria where idCategoria=?",p.getIdCategoria());
        connection.close();
        return true;
    }
    public ObservableList<Categoria> listarCategoria() throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        ObservableList<Categoria> lista = FXCollections.observableArrayList();

        PreparedStatement busca = connection.prepareStatement("select * from Categoria");
        ResultSet bC = busca.executeQuery();

        while (bC.next()){
            int id = bC.getInt("idCategoria");
            String nome = bC.getString("nome");

            Categoria c = new Categoria(id, nome);
            lista.add(c);
        }
        connection.close();
        busca.close();
        bC.close();


        return lista;

    }

}
