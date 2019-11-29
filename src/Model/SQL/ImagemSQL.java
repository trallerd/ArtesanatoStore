package Model.SQL;

import Model.FabricaConexao;
import Model.Imagem;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImagemSQL {
    private static ImagemSQL instance;

    private ImagemSQL(){

    }

    public static ImagemSQL getInstance(){
        if(instance == null){
            instance = new ImagemSQL();
        }
        return instance;
    }

    public void salvarDiretoNoBanco(Imagem img) throws SQLException,IOException{
        Connection con = FabricaConexao.getConnection();
        PreparedStatement pStmt = con.prepareStatement("insert into imagens (nomeArquivo,imagem) values (?,?)");

        pStmt.setString(1, img.getNomeArquivo());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedImage bImg = SwingFXUtils.fromFXImage(img.getImage(),null);

        ImageIO.write(bImg, "jpg", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());

        pStmt.setBinaryStream(2, is,is.available());
        pStmt.executeUpdate();

        pStmt.close();
        con.close();
    }



}
