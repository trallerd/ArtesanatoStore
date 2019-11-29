package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewAdmController {
    public Button cadastrarP;
    public Button relatorioVenda;
    public Button relatorioP;
    public Button relatorioUsuario;
    public Button out;
    public Button encomendas;
    Stage stage = null;
    Parent myNewScene = null;

    public void cadastraP(ActionEvent actionEvent) throws IOException {
        stage = (Stage) cadastrarP.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/CadastrarProduto.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("CADASTRAR PRODUTO");
        stage.show();
    }

    public void relatorioVenda(ActionEvent actionEvent) throws IOException {
        stage = (Stage) cadastrarP.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/RelatorioVenda.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("RELATORIO DE VENDA");
        stage.show();
    }

    public void relatorioP(ActionEvent actionEvent) throws IOException {
        stage = (Stage) cadastrarP.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/RelatorioProduto.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("RELATORIO DE PRODUTOS");
        stage.show();
    }

    public void relatorioUsuario(ActionEvent actionEvent) throws IOException {
        stage = (Stage) cadastrarP.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/RelatorioUsuario.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("RELATORIO DE USUARIOS");
        stage.show();
    }

    public void sair(ActionEvent actionEvent) {
        ControleController.setUser(null);
        System.exit(0);
    }

    public void encomendas(ActionEvent actionEvent) throws IOException {
        stage = (Stage) cadastrarP.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/RelatorioEncomendas.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("RELATORIO DE ENCOMENDAS");
        stage.show();
    }
}
