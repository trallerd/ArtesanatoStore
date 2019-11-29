package Model.SQL;

import Model.FabricaConexao;
import Model.Usuario;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioSQL {
    private static UsuarioSQL instance = new UsuarioSQL();

    public static UsuarioSQL getInstance() {
        return instance;
    }


    private QueryRunner dbAccess = new QueryRunner();

    public long inserirUsuario(Usuario u) throws SQLException {
        Connection connection = FabricaConexao.getConnection();

        long id = dbAccess.insert(connection, "INSERT INTO Usuario(nome,email,senha,AdmStatus) VALUES (?,?,?,?)",
                new ScalarHandler<Integer>(), u.getNome(), u.getEmail(), u.getSenha(),u.isAdmStatus()).longValue();
        connection.close();

        return id;
    }

    public boolean deletarUsuario(Usuario u) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection, "DELETE FROM Usuario where id=?", u.getIdUsuario());
        connection.close();
        return true;
    }

    public boolean verificarAdm(Usuario u) throws SQLException {
        Connection connection = FabricaConexao.getConnection();

        String busca = "select * from Usuario where id=?";
        PreparedStatement psm = connection.prepareStatement(busca);
        psm.setInt(1, u.getIdUsuario());

        ResultSet bC = psm.executeQuery();

        while (bC != null) {
            Usuario user = null;
            while (bC.next()) {
                int id = bC.getInt("idUsuario");
                String nome = bC.getString("nome");
                String email = bC.getString("email");
                String senha = bC.getString("senha");
                boolean admStatus = bC.getBoolean("AdmStatus");

                user = new Usuario(id, nome, email, senha, admStatus);
            }
            if (user.isAdmStatus()) {

                return true;
            }


        }
        connection.close();
        psm.close();
        bC.close();
        return false;
    }
    public List<Usuario> listarUsuarios() throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        List<Usuario> lista = dbAccess.query(connection,"SELECT * FROM Usuario ",
                new BeanListHandler<Usuario>(Usuario.class));

        connection.close();

        return lista;
    }
    public Usuario Login(Usuario u) throws SQLException {
        Connection connection = FabricaConexao.getConnection();

        String busca = "select * from Usuario where email=? and senha=?";
        PreparedStatement psm = connection.prepareStatement(busca);
        psm.setString(1, u.getEmail());
        psm.setString(2, u.getSenha());

        ResultSet bC = psm.executeQuery();

        while (bC != null) {
            Usuario user = null;
            while (bC.next()) {
                int id = bC.getInt("idUsuario");
                String nome = bC.getString("nome");
                String email = bC.getString("email");
                String senha = bC.getString("senha");
                boolean admStatus = bC.getBoolean("AdmStatus");

                user = new Usuario(id, nome, email, senha,admStatus);
            }
            return user;
        }
        connection.close();
        psm.close();
        bC.close();
        return null;
    }

}
