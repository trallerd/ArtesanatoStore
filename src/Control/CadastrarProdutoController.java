package Control;

import Model.Categoria;
import Model.Gerenciadores.GerenciaCategoria;
import Model.Gerenciadores.GerenciaProduto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastrarProdutoController {
    public TextField tfNome;
    public TextField tfValor;
    public TextField tfDescricao;
    public TextField tfTamanho;
    public ComboBox cbCategoria;
    public Button btCadastrar;
    public Button btVoltar;
    public Button btCadastrarCat;
    Stage stage = null;
    Parent myNewScene = null;

    public void initialize(){
        try {
            cbCategoria.setItems(GerenciaCategoria.getInstance().listaCategorias());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Cadastrar(ActionEvent actionEvent) {
        String nome = tfNome.getText();
        double valor  = Double.parseDouble(tfValor.getText());
        String descricao = tfDescricao.getText();
        String tamanho = tfTamanho.getText();
        Categoria categoria = (Categoria) cbCategoria.getSelectionModel().getSelectedItem();

        try{
            GerenciaProduto.getInstance().cadastrarProduto(nome,valor,descricao,tamanho,categoria);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Cadastrado com Sucesso \n");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Problema ao Cadastrar Produto \n"+e.getMessage());
            alert.showAndWait();
            System.out.println(e.getMessage());
        }

    }

    public void Voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/ViewAdm.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ARTE'S DRI");
        stage.show();
    }

    public void CadastrarCat(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/CadastrarCat.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("CADASTRAR CATEGORIA");
        stage.show();
    }
}
