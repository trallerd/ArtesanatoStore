package Model.Gerenciadores;

import Model.SQL.VendaSQL;
import Model.Usuario;
import Model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class GerenciaVenda {
    private ObservableList<Venda> vendas;
    private VendaSQL vendaSQL = new VendaSQL();

    private static GerenciaVenda instance = new GerenciaVenda();


    private GerenciaVenda(){
        vendas = FXCollections.observableArrayList();
    }

    public static GerenciaVenda getInstance(){
        return instance;
    }

    public void cadastrarVenda(double desconto, double valorTotal, int quantidade, String data, Usuario usuario) throws SQLException {
        Venda a = new Venda();
        a.setDesconto(desconto);
        a.setValorTotal(valorTotal);
        a.setQuantidade(quantidade);
        a.setData(data);
        a.setUsuario(usuario.getIdUsuario());

        long id = vendaSQL.registrarVenda(a);
        a.setIdVenda((int)id);
        vendas.add(a);
    }
    public ObservableList<Venda> listaVendas()throws SQLException{
        vendas.clear();
        List<Venda> lista = vendaSQL.listarVendas();
        vendas.addAll(lista);
        return vendas;
    }



    public ObservableList listarVendasU(Usuario user) throws SQLException {
        vendas.clear();
        List<Venda> lista = vendaSQL.listarVendasU(user);
        vendas.addAll(lista);
        return vendas;
    }
}
