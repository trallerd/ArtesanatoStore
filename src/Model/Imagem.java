package Model;

import javafx.scene.image.Image;

public class Imagem {
    private String nomeArquivo;
    private int id;
    private Image image;

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public String toString(){
        return ""+this.id;
    }

}
