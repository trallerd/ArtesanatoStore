package Model.Gerenciadores;

import Model.SQL.UsuarioSQL;
import Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class GerenciaUsuario {
    private ObservableList<Usuario> usuarios;
    private UsuarioSQL usuarioSQL = new UsuarioSQL();

    private static GerenciaUsuario instance = new GerenciaUsuario();


    private GerenciaUsuario(){
        usuarios = FXCollections.observableArrayList();
    }

    public static GerenciaUsuario getInstance(){
        return instance;
    }


    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException {
        Usuario a = new Usuario();
        a.setNome(nome);
        a.setEmail(email);
        a.setSenha(senha);
        //a.setAdmStatus(false);

        long id = usuarioSQL.inserirUsuario(a);
        a.setIdUsuario((int)id);
        usuarios.add(a);
    }
    public void deletaUsuario(Usuario a)throws SQLException{
        usuarioSQL.deletarUsuario(a);

    }
    public void verificaAdm(Usuario a) throws SQLException{
        usuarioSQL.verificarAdm(a);
    }
    public Usuario verifica(Usuario u) throws SQLException{

        boolean valido;
        Usuario user = null;
        user = usuarioSQL.Login(u);
        if(user!=null){
            return user;
        }

        return null;
    }
}
