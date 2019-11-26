package Control;

import Model.Categoria;
import Model.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaController {
    private static Stage cena;
    private static Scene login;
    private static Scene home;
    private static Scene despesa;
    private static Scene categoria;
    private static Scene usuario;

    private static Usuario user;
    private static Categoria Cat;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        JanelaController.user = user;
    }

    public static Categoria getCat() {
        return Cat;
    }

    public static void setCat(Categoria cat) {
        Cat = cat;
    }


    public static void changeScreen(String screen) throws IOException {
        switch (screen){
            case "PRODUTO":
                cena.close();
                Parent fxProdutos= FXMLLoader.load(JanelaController.class.getResource("../View/Produtos.fxml"));
                cena.setTitle("PRODUTOS");

                login = new Scene(fxProdutos);
                cena.setScene(login);
                cena.show();
                break;

            case "GALERIA":
                cena.close();
                Parent fxHome= FXMLLoader.load(JanelaController.class.getResource("../View/Galeria.fxml"));
                cena.setTitle("GALERIA");

                home = new Scene(fxHome);
                cena.setScene(home);
                cena.show();
                break;

            case "ENCOMENDAS":
                cena.close();
                Parent fxDespesa= FXMLLoader.load(JanelaController.class.getResource("../View/Encomendas.fxml"));
                cena.setTitle("ENCOMENDAS");

                despesa = new Scene(fxDespesa);
                cena.setScene(despesa);
                cena.show();
                break;
            case "LOGAR":
                cena.close();
                Parent fxCategoria= FXMLLoader.load(JanelaController.class.getResource("../View/Logar.fxml"));
                cena.setTitle("LOGAR");

                categoria = new Scene(fxCategoria);
                cena.setScene(categoria);
                cena.show();
                break;
            case "CADASTRAR":
                cena.close();
                Parent fxUsuario= FXMLLoader.load(JanelaController.class.getResource("../View/CadastrarUsuario.fxml"));
                cena.setTitle("Cadastrar Usuario");

                usuario = new Scene(fxUsuario);
                cena.setScene(usuario);
                cena.show();
                break;


        }

    }
}
