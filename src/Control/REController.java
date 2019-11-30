package Control;

import Model.Gerenciadores.GerenciaLocacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class REController {
    public Button btVoltar;
    public TableView tabelinha;
    public TableColumn dataLocacao;
    public TableColumn dataEntrega;
    public TableColumn produto;
    public TableColumn usuario;
    Stage stage = null;
    Parent myNewScene = null;

    public void initialize(){
        try {
            dataLocacao.setCellValueFactory(new PropertyValueFactory<>("dataLocacao"));
            dataEntrega.setCellValueFactory(new PropertyValueFactory<>("dataEntrega"));
            produto.setCellValueFactory(new PropertyValueFactory<>("produto"));
            usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            tabelinha.setItems(GerenciaLocacao.getInstance().listarLocacoes());
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
}
