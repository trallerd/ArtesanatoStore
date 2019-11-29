package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewController {
    @FXML public Button produto;
    @FXML public Button galeria;
    @FXML public Button logar;
    @FXML public Button contato;
    @FXML public Button out;
    @FXML public Button encomendas;
    public Button adm;
    Stage stage = null;
    Parent myNewScene = null;


    public void produtos(ActionEvent actionEvent) throws IOException {
        if(ControleController.getUser()==null){
            stage = (Stage) produto.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("../View/Produtos.fxml"));
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("PRODUTOS");
            stage.show();
        }else{
            stage = (Stage) produto.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("../View/ProdutosVerificado.fxml"));
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("PRODUTOS");
            stage.show();
        }


    }

    public void galeria(ActionEvent actionEvent) throws IOException {

        stage = (Stage) produto.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Galeria.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("GALERIA");
        stage.show();
    }

    public void logar(ActionEvent actionEvent) throws IOException {

        if(ControleController.getUser()==null){
            stage = (Stage) logar.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("../View/Logar.fxml"));
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("LOGAR");
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Você já esta logado!! \n");
            alert.showAndWait();
        }


    }

    public void contato(ActionEvent actionEvent) throws IOException {

        stage = (Stage) contato.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Contato.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("CONTATO");
        stage.show();
    }

    public void sair(ActionEvent actionEvent) {
        ControleController.setUser(null);
        System.exit(0);
    }

    public void encomendas(ActionEvent actionEvent) throws IOException {
        if(ControleController.getUser()!=null){
            stage = (Stage) encomendas.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("../View/Locacao.fxml"));
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("LOCAÇÃO");
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Você precisa estar Logado!! \n");
            alert.showAndWait();
        }

    }


    public void loginAdm(ActionEvent actionEvent) throws IOException {
        stage = (Stage) adm.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Logar.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("LOGAR");
        stage.show();
    }
}

