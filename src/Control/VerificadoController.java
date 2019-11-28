package Control;

import Model.Categoria;
import Model.Gerenciadores.GerenciaCategoria;
import Model.Gerenciadores.GerenciaProduto;
import Model.Gerenciadores.GerenciaVenda;
import Model.Produto;
import Model.Usuario;
import Model.Venda;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class VerificadoController {
    public ComboBox categorias;
    public Button btFiltrar;
    public TextField tfProduto;
    public TableView tabelinha;
    public TableColumn valor;
    public TableColumn nome;
    public TableColumn descricao;
    public Button btFinaliza;
    public Button btVolta;
    public Button btLogout;
    Stage stage = null;
    Parent myNewScene = null;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

    public void initialize(){
        try {
            nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
            descricao.setCellValueFactory(new PropertyValueFactory<>("Descrição"));
            valor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
            categorias.setItems(GerenciaCategoria.getInstance().listaCategorias());
            tabelinha.setItems(GerenciaProduto.getInstance().listaProdutos());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Filtrar(ActionEvent actionEvent) throws SQLException {

        Categoria categoria = (Categoria) categorias.getSelectionModel().getSelectedItem();
        tabelinha.setItems(GerenciaProduto.getInstance().buscaCategoria(categoria));
        categorias.getSelectionModel().clearSelection();
    }

    public void TextFilter(KeyEvent keyEvent) throws SQLException {
        tabelinha.setItems(GerenciaProduto.getInstance().listaProdutos(tfProduto.getText()));
    }

    public void Voltar(ActionEvent actionEvent) throws IOException {
        stage = (Stage) btVolta.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/View.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ARTE'S DRI");
        stage.show();
    }


    public void Logout(ActionEvent actionEvent) throws IOException {
        ControleController.setUser(null);
        stage = (Stage) btLogout.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("../View/View.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("ARTE'S DRI");
        stage.show();

    }

    public void Comprar(ActionEvent actionEvent) {
       Date date = new Date(System.currentTimeMillis());
       Produto a = (Produto) tabelinha.getSelectionModel().getSelectedItem();
       Venda b = new Venda();
       String data = formatter.format(date);
        System.out.println(data);
       double desconto = 0.0;
       int quantidade  = 1;
       Usuario usuario = ControleController.getUser();
       double valor = a.getValor();

       try{
           GerenciaVenda.getInstance().cadastrarVenda(desconto,valor,quantidade,data,usuario);
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Compra Realizada \n");
           alert.showAndWait();
       } catch (SQLException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR,"Sem sucesso \n"+e.getMessage());
           alert.showAndWait();
       }
    }
}
