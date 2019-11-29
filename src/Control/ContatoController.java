package Control;

import Model.Gerenciadores.GerenciaUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ContatoController {
    Stage stage = null;
    Parent myNewScene = null;

    @FXML public Button btVoltar;

    public void Voltar(ActionEvent actionEvent) throws IOException {
        try{

            stage = (Stage) btVoltar.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("../View/View.fxml"));
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("ARTE'S DRI");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
