package Control;

import Model.Categoria;
import Model.Gerenciadores.GerenciaCategoria;
import Model.Gerenciadores.GerenciaProduto;
import Model.PDF;
import Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class RPController {
    public ComboBox categorias;
    public Button btFiltrar;
    public TextField tfProduto;
    public Button btVoltar;
    public TableView tabelinha;
    public TableColumn nome;
    public TableColumn descricao;
    public TableColumn valor;
    public Button btPDF;
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

    public void TextFilter(KeyEvent keyEvent) throws SQLException {
        tabelinha.setItems(GerenciaProduto.getInstance().listaProdutos(tfProduto.getText()));
    }

    public void Voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/View.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ARTE'S DRI");
        stage.show();
    }

    public void gerarPDF(ActionEvent av) {
        PDF  geradorPDF = new PDF();

        Button bt = (Button) av.getSource();

        FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);


        if(f != null){
            String arq = f.getAbsolutePath();

                geradorPDF.criaPdf_3(arq);
            }
    }
}

