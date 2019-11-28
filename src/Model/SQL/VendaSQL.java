package Model.SQL;

import Model.FabricaConexao;
import Model.Usuario;
import Model.Venda;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VendaSQL {
    private static VendaSQL instance = new VendaSQL();

    public static VendaSQL getInstance(){
        return instance;
    }


    private QueryRunner dbAccess = new QueryRunner();

    public long registrarVenda(Venda v) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        long id = dbAccess.insert(connection,"INSERT INTO Venda(desconto,valorTotal,quantidade,data,usuario) VALUES (?,?,?,?,?)",
                new ScalarHandler<Integer>(),v.getDesconto(),v.getValorTotal(),v.getQuantidade(),v.getData(),v.getUsuario()).longValue();
        connection.close();
        return id;
    }
    public List<Venda> listarVendas() throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        List<Venda> lista = dbAccess.query(connection,"SELECT * FROM Venda ",
                new BeanListHandler<Venda>(Venda.class));

        connection.close();

        return lista;
    }
    public List<Venda> listarVendasU(Usuario u) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        List<Venda> lista = dbAccess.query(connection,"SELECT * FROM Venda where usuario=? ",u.getIdUsuario(),
                new BeanListHandler<Venda>(Venda.class));

        connection.close();

        return lista;
    }


}
