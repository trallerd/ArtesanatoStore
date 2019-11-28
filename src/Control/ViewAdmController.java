package Control;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ViewAdmController {
    public Button cadastrarP;
    public Button relatorioVenda;
    public Button relatorioP;
    public Button relatorioUsuario;
    public Button out;
    public Button encomendas;

    public void cadastraP(ActionEvent actionEvent) {
    }

    public void relatorioVenda(ActionEvent actionEvent) {
    }

    public void relatorioP(ActionEvent actionEvent) {
    }

    public void relatorioUsuario(ActionEvent actionEvent) {
    }

    public void sair(ActionEvent actionEvent) {
        ControleController.setUser(null);
        System.exit(0);
    }

    public void encomendas(ActionEvent actionEvent) {
    }
}
