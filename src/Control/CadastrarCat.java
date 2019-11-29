package Control;

import Model.Gerenciadores.GerenciaCategoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastrarCat {
    public Button btCadastrar;
    public Button btVoltar;
    public TextField tfNome;
    Stage stage = null;
    Parent myNewScene = null;

    public void Cadastrar(ActionEvent actionEvent) {
        String nome = tfNome.getText();
        try{
            GerenciaCategoria.getInstance().cadastrarCategoria(nome);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Cadastrado com Sucesso \n");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Problema ao Cadastrar Categoria \n"+e.getMessage());
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
}
