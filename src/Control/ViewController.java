package Control;


import Model.Categoria;
import Model.Gerenciadores.GerenciaCategoria;
import Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ViewController {


    private static Usuario user;
    private static Categoria Cat;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        ViewController.user = user;
    }

    public static Categoria getCat() {
        return Cat;
    }

    public static void setCat(Categoria cat) {
        Cat = cat;
    }


    public void produtos(ActionEvent actionEvent) {
        System.out.println("PORRA");
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
        System.out.println("BU");
    }

    public void encomendas(ActionEvent actionEvent) {
        System.out.println("ORRA");
    }
}

