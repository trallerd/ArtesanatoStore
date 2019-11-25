package Model.Gerenciadores;

import Model.Categoria;
import Model.SQL.CategoriaSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class GerenciaCategoria {
    private ObservableList<Categoria> categorias;
    private CategoriaSQL categoriaSQL = new CategoriaSQL();

    private static GerenciaCategoria instance = new GerenciaCategoria();


    private GerenciaCategoria(){
        categorias = FXCollections.observableArrayList();
    }

    public static GerenciaCategoria getInstance(){
        return instance;
    }


    public void cadastrarCategoria(String nome) throws SQLException {
        Categoria a = new Categoria();
        a.setNome(nome);

        long id = categoriaSQL.addCategoria(a);
        a.setIdCategoria((int)id);
        categorias.add(a);
    }
    public void deletaCategoria(Categoria a)throws SQLException{
        categoriaSQL.deletCategoria(a);

    }
    public ObservableList listaCategorias() throws SQLException{
        categorias.clear();
        categorias.addAll(categoriaSQL.listarCategoria());
        return categorias;
    }
}
