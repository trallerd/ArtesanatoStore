package Model.Gerenciadores;

import Model.Endereco;
import Model.SQL.EnderecoSQL;
import Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class GerenciaEndereco {
    private ObservableList<Endereco> enderecos;
    private EnderecoSQL enderecoSQL = new EnderecoSQL();

    private static GerenciaEndereco instance = new GerenciaEndereco();


    private GerenciaEndereco(){
        enderecos = FXCollections.observableArrayList();
    }

    public static GerenciaEndereco getInstance(){
        return instance;
    }


    public void cadastrarEndereco(String estado, String cidade, String bairro, String rua, int numero, Usuario usuario) throws SQLException {
        Endereco a = new Endereco();
        a.setEstado(estado);
        a.setCidade(cidade);
        a.setBairro(bairro);
        a.setRua(rua);
        a.setNumero(numero);
        a.setUsuario(usuario);

        long id = enderecoSQL.inserirEndereco(a);
        a.setIdEndereco((int)id);
        enderecos.add(a);
    }
    public void deletaUsuario(Endereco a)throws SQLException{
        enderecoSQL.deletarEndereco(a);

    }
    public void atualizaEndereco(String estado, String cidade, String bairro, String rua, int numero, Usuario usuario) throws SQLException {
        Endereco a = new Endereco();
        a.setEstado(estado);
        a.setCidade(cidade);
        a.setBairro(bairro);
        a.setRua(rua);
        a.setNumero(numero);
        a.setUsuario(usuario);
        enderecoSQL.atualizarEndereco(a,a.getIdEndereco());
        enderecos.add(a);
    }
}
