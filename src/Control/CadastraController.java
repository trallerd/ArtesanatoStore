package Control;

import Model.Gerenciadores.GerenciaUsuario;
import Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastraController {
    @FXML public TextField tfNome;
    @FXML public TextField tfEmail;
    @FXML public PasswordField tfSenha;
    @FXML public Button btCadastrar;
    @FXML public Button btVoltar;

    Stage stage = null;
    Parent myNewScene = null;


    public void voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Logar.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("LOGAR");
        stage.show();
    }

    public void Cadastrar(ActionEvent actionEvent) {
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();


        try{
            GerenciaUsuario.getInstance().cadastrarUsuario(nome,email,senha);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Cadastrado com Sucesso \n");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Problema ao inserir a Usuario \n"+e.getMessage());
            alert.showAndWait();
            System.out.println(e.getMessage());
        }

    }
}
