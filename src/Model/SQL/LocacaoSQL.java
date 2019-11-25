package Model.SQL;

import Model.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LocacaoSQL {
    private static LocacaoSQL instance = new LocacaoSQL();

    public static LocacaoSQL getInstance(){
        return instance;
    }


    private QueryRunner dbAccess = new QueryRunner();

    public long locar(Locacao l) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        long id = dbAccess.insert(connection,"INSERT INTO Locacao(dataLocacao,dataEntrega,valor,produto,usuario) VALUES (?,?,?,?,?)",
                new ScalarHandler<Integer>(),l.getDataLocacao(),l.getDataEntrega(),l.getValor(),l.getProduto(),l.getUsuario()).longValue();
        connection.close();

        return id;
    }
    public List<Locacao> listarVendas() throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        List<Locacao> lista = dbAccess.query(connection,"SELECT * FROM Locacao",
                new BeanListHandler<Locacao>(Locacao.class));

        connection.close();

        return lista;
    }
}