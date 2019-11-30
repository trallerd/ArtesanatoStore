package Control;

import Model.Gerenciadores.GerenciaUsuario;
import Model.PDFUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class RUController {
    public Button btVoltar;
    public TableView tabelinha;
    public TableColumn nome;
    public TableColumn Email;
    public Button btPDF;
    Stage stage = null;
    Parent myNewScene = null;

    public void initialize(){
        try {
            nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
            Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            tabelinha.setItems(GerenciaUsuario.getInstance().listaUsuarios());
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void gerarPDF(ActionEvent av) {
        PDFUsuario geradorPDF = new PDFUsuario();

        Button bt = (Button) av.getSource();

        FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);


        if(f != null){
            String arq = f.getAbsolutePath();

            geradorPDF.criaPdf_3(arq);
        }
    }
}
