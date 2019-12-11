package Control;

import Model.Gerenciadores.GerenciaLocacao;
import Model.Locacao;
import Model.Produto;
import Model.SQL.ProdutoSQL;
import Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class LocacaoController {
    @FXML public DatePicker dataLocacao;
    @FXML public DatePicker dataEntrega;
    @FXML public TextField tfTema;
    @FXML public Button encomenda;
    @FXML public Button btVoltar;
    Stage stage = null;
    Parent myNewScene = null;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");


    public void encomenda(ActionEvent actionEvent) throws IOException, SQLException {
            String DataLocacao = dataLocacao.getEditor().getText();
            String DataEntrega = dataEntrega.getEditor().getText();
            System.out.println(DataEntrega);

            Produto produto = (Produto) ProdutoSQL.getInstance().buscaCategoria(5);
            Usuario u = ControleController.getUser();

            try{
                GerenciaLocacao.getInstance().cadastrarLocacao(DataLocacao,DataEntrega,produto,u);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Solicitação Realizada \n");
                alert.showAndWait();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Sem sucesso \n"+e.getMessage());
                alert.showAndWait();
                System.out.println(e.getMessage());
            }


    }

    public void Voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVoltar.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/View.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ARTE'S DRI");
        stage.show();
    }
}
