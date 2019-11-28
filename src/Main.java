import Control.ControleController;
import Model.Categoria;
import Model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private static Stage cena;
    private static Scene principal;

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage primary) throws Exception {
        cena = primary;

        Parent fxPrincipal= FXMLLoader.load(Main.class.getResource("View/View.fxml"));
        cena.setTitle("ARTE'S DRI");

        principal = new Scene(fxPrincipal);
        cena.setScene(principal);
        cena.show();

    }


}