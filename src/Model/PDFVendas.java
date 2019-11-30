package Model;

import Model.Gerenciadores.GerenciaVenda;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import java.io.IOException;
import java.sql.SQLException;

public class PDFVendas {

    private static PDFVendas instance = new PDFVendas();



    public static PDFVendas getInstance(){
        return instance;
    }

    //este método cria um documento para receber o conteúdo
    private Document abreDocumento(String arq) throws IOException {
        PdfWriter writer = new PdfWriter(arq);
        PdfDocument pdf  = new PdfDocument(writer);
        Document document = new Document(pdf);

        return  document;
    }





    //cria um pdf com uma tabela. Iremos simular
    //uma consulta ao banco de dados que retorna
    //uma lista de pessoas e iremos mostrar o resultados
    //em um pdf.
    public void criaPdf_3(String arq){
        try{

            //utilizado para buscar a lista de pessoas
            Venda venda = new Venda();
            java.util.List<Venda> lista = GerenciaVenda.getInstance().listaVendas();
            //cria o documento
            Document document = abreDocumento(arq);

            //coloca um parágrafo de cabeçalho, com alinhamento centralizado
            Paragraph paragrafo = new Paragraph("Usuários Cadastrados");
            //alinha contéudo do parágrafo no centro da página
            paragrafo.setTextAlignment(TextAlignment.CENTER);

            //indica que o parágrafo é negrito
            paragrafo.setBold();

            //inclui o paragrafo no documento
            document.add(paragrafo);


            //cria a tabela
            Table table = new Table(UnitValue.createPercentArray(new float[]{5,20,5,5,10}))
                    .useAllAvailableWidth();


            //utilizado para criar o cabeçalho da tabela
            String[] cabecalho = {"id","Data","Quantidade","User","Valor"};

            //percore o vetor colocando cada elemento dentro de uma célula
            for(String s:cabecalho){
                //cria uma célula ue irá conter o conteúdo
                Cell cell = new Cell();
                //o conteúdo é coloca em um parágrafo
                cell.add(new Paragraph(s));
                //ajusta a cor de fundo da célula
                cell.setBackgroundColor(ColorConstants.LIGHT_GRAY);
                //ajusta a linha de borda da célula
                //https://api.itextpdf.com/iText7/7.1.7/com/itextpdf/layout/borders/SolidBorder.html
                cell.setBorder(new SolidBorder(ColorConstants.BLACK,2));
                //inclui a célula como cabeçalho, que irá se repetir por todas páginas em que a tabela aparecer (caso a quantidade
                //de dados for muito grande e precise de várias páginas)
                table.addHeaderCell(cell);

            }

            //cria uma fonte
            //https://api.itextpdf.com/iText7/7.1.7/com/itextpdf/io/font/constants/StandardFonts.html
            PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
            //ajusta a fonte da tabela, será utilizada por todas as células
            table.setFont(font);
            //ajusta o tamanho da fonte
            table.setFontSize(12);
            //percorre a lista e inclui as células. Cada atributo da pessoa
            //vai em uma célula separada
            for(Venda p:lista){
                table.addCell(String.valueOf(p.getIdVenda()));
                table.addCell(p.getData());
                table.addCell(String.valueOf(p.getQuantidade()));
                table.addCell(String.valueOf(p.getUsuario()));
                table.addCell(String.valueOf(p.getValorTotal()));
            }

            //adiciona a tabela ao documento
            document.add(table);



            document.close();




        }catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
