package Control;


import javafx.event.ActionEvent;
import java.io.IOException;

import static Control.JanelaController.changeScreen;


public class ViewController {


    public void produtos(ActionEvent actionEvent) throws IOException {
        changeScreen("PRODUTO");
    }

    public void galeria(ActionEvent actionEvent) {
        System.out.println("CARALHO");
    }

    public void logar(ActionEvent actionEvent) {
        System.out.println("FPD");
    }

    public void contato(ActionEvent actionEvent) {
        System.out.println("ZE");
    }

    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void encomendas(ActionEvent actionEvent) {
        System.out.println("ORRA");
    }
}

