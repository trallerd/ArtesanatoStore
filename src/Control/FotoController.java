package Control;

import Model.Gerenciadores.GerenciaLocacao;
import Model.Imagem;
import Model.SQL.ImagemSQL;
import Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FotoController {
    public Button btAbrir;
    public Button btSalvar;
    public Button btVoltar;
    public ImageView imgView;
    private Imagem img;
    Stage stage = null;
    Parent myNewScene = null;

    public void Abrir(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");

        File f = fileChooser.showOpenDialog(null);
        if(f !=null){
            Image im = new Image(f.toURI().toString(),100,150,true,false);
            img = new Imagem();
            img.setImage(im);
            img.setNomeArquivo("imgs/"+f.getName()+".jpg");
            imgView.setImage(img.getImage());
        }
    }

    public void Salvar(ActionEvent actionEvent) throws IOException {
        if(ControleController.getUser()!=null){
            try{
                ImagemSQL.getInstance().salvarDiretoNoBanco(img);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Enviado com Sucesso \n");
                alert.showAndWait();
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Problema ao Carregar Foto \n"+e.getMessage());
                alert.showAndWait();
                System.out.println(e.getMessage());
            }

        }else{
            stage = (Stage) btSalvar.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("../View/CarregaFoto.fxml"));
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("ENVIAR FOTO");
            stage.show();

        }


    }

    public void Voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/Galeria.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("GALERIA");
        stage.show();
    }
}
