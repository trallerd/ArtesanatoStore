package Control;

import Model.Categoria;
import Model.Usuario;

public class ControleController {
    private static Usuario user;
    private static Categoria Cat;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        ControleController.user = user;
    }

    public static Categoria getCat() {
        return Cat;
    }

    public static void setCat(Categoria cat) {
        Cat = cat;
    }

}
