package Control;

import Model.Categoria;
import Model.Gerenciadores.GerenciaCategoria;
import Model.Gerenciadores.GerenciaProduto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ProdutosControll {
    @FXML public TableView tabelinha;
    @FXML public TableColumn nome;
    @FXML public TableColumn descricao;
    @FXML public TableColumn valor;
    @FXML public ComboBox categorias;
    @FXML public Button btFiltrar;
    @FXML public TextField tfProduto;
    @FXML public Button logar;
    Stage stage = null;
    Parent myNewScene = null;

    public void initialize(){
        try {
            nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
            descricao.setCellValueFactory(new PropertyValueFactory<>("Descrição"));
            valor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
            categorias.setItems(GerenciaCategoria.getInstance().listaCategorias());
            tabelinha.setItems(GerenciaProduto.getInstance().listaProdutos());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Filtrar(ActionEvent actionEvent) throws SQLException {

        Categoria categoria = (Categoria) categorias.getSelectionModel().getSelectedItem();
        tabelinha.setItems(GerenciaProduto.getInstance().buscaCategoria(categoria));
        categorias.getSelectionModel().clearSelection();
    }

    public void TextFilter(KeyEvent inputMethodEvent) throws SQLException {
        tabelinha.setItems(GerenciaProduto.getInstance().listaProdutos(tfProduto.getText()));
    }

    public void logar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) logar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Logar.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("LOGAR");
        stage.show();
    }
}
