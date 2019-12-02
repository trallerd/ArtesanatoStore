package Model.Gerenciadores;

import Model.Locacao;
import Model.Produto;
import Model.SQL.LocacaoSQL;
import Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class GerenciaLocacao {
    private ObservableList<Locacao> locacoes;
    private LocacaoSQL locacaoSQL = new LocacaoSQL();

    private static GerenciaLocacao instance = new GerenciaLocacao();


    private GerenciaLocacao(){
        locacoes = FXCollections.observableArrayList();
    }

    public static GerenciaLocacao getInstance(){
        return instance;
    }


    public void cadastrarLocacao(String dataLocacao, String dataEntrega,  int produto, Usuario usuario) throws SQLException {
        Locacao a = new Locacao();
        a.setDataLocacao(dataLocacao);
        a.setDataEntrega(dataEntrega);
        a.setProduto(produto);
        a.setUsuario(usuario.getIdUsuario());


        long id = locacaoSQL.locar(a);
        a.setIdLocacao((int)id);
        locacoes.add(a);
    }
    public ObservableList listarLocacoes() throws SQLException {
        locacoes.clear();
        List<Locacao> lista = locacaoSQL.listarLocacoes();
        locacoes.addAll(lista);
        return locacoes;
    }
}
