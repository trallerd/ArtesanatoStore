package Model.SQL;

import Model.Endereco;
import Model.FabricaConexao;
import Model.Usuario;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

import static sun.security.krb5.Confounder.longValue;

public class EnderecoSQL {
    private static EnderecoSQL instance = new EnderecoSQL();

    public static EnderecoSQL getInstance(){
        return instance;
    }


    private QueryRunner dbAccess = new QueryRunner();

    public long inserirEndereco(Endereco e) throws SQLException{
        Connection connection = FabricaConexao.getConnection();
        long id = dbAccess.insert(connection,"INSERT INTO Endereco(estado,cidade,bairro,rua,numero,usuario) VALUES (?,?,?,?,?,?)",
                new ScalarHandler<Integer>(),e.getEstado(),e.getCidade(),e.getBairro(),e.getRua(),e.getNumero(),e.getUsuario()).longValue();
        connection.close();

        return id;
    }
    public boolean deletarEndereco(Endereco e) throws SQLException{
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection,"DELETE FROM Endereco where id=?",e.getIdEndereco());
        connection.close();
        return true;
    }
    public boolean atualizarEndereco(Endereco e,int id) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection, "UPDATE Endereco SET estado=?,cidade=?,bairro=?,rua=?,numero=?,usuario=? WHERE id=?",
                e.getEstado(),e.getCidade(),e.getBairro(),e.getRua(),e.getNumero(),e.getUsuario(), id);
        connection.close();
        return true;
    }

}
