package Control;

import Model.Locacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EncomendaController {
    @FXML public DatePicker dataLocacao;
    @FXML public DatePicker dataEntrega;
    @FXML public TextField tfTema;
    @FXML public Button encomenda;
    @FXML public Button btVoltar;

    public void encomenda(ActionEvent actionEvent) {
        String DataLocacao = dataLocacao.getEditor().getText();
        String DataEntrega = dataEntrega.getEditor().getText();

    }

    public void Voltar(ActionEvent actionEvent) {
    }
}
