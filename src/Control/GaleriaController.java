package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class GaleriaController {
    public Button btVoltar;
    public Button btEnviarFoto;
    Stage stage = null;
    Parent myNewScene = null;

    public void Voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/View.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ARTE'S DRI");
        stage.show();
    }

    public void EnviaFoto(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btEnviarFoto.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/CarregaFoto.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ENVIAR FOTO");
        stage.show();


    }
}
