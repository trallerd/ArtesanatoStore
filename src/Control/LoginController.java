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

public class LoginController {
    public Button btVoltar;
    Stage stage = null;
    Parent myNewScene = null;

    @FXML public TextField tfEmail;
    @FXML public PasswordField tfSenha;
    public Button btentrar;


    public void Entrar(ActionEvent actionEvent) {
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
        Usuario u = new Usuario();
        Usuario user = null;
        u.setEmail(email);
        u.setSenha(senha);

        try{
            user = GerenciaUsuario.getInstance().verifica(u);
            if(user!=null){
                ControleController.setUser(user);
                if(!user.isAdmStatus()){
                    stage = (Stage) btentrar.getScene().getWindow();
                    myNewScene = FXMLLoader.load(getClass().getResource("../View/ProdutosVerificado.fxml"));
                    Scene scene = new Scene(myNewScene);
                    stage.setScene(scene);
                    stage.setTitle("PRODUTOS");
                    stage.show();
                }else {
                    stage = (Stage) btentrar.getScene().getWindow();
                    myNewScene = FXMLLoader.load(getClass().getResource("../View/ViewAdm.fxml"));
                    Scene scene = new Scene(myNewScene);
                    stage.setScene(scene);
                    stage.setTitle("ARTE'S DRI");
                    stage.show();
                }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Usuario não existe! \n");
            alert.showAndWait();
                ControleController.setUser(null);
        }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastro(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btentrar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/CadastrarUsuario.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("CADASTRAR");
        stage.show();
    }

    public void voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Produtos.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("PRODUTOS");
        stage.show();
    }
}
