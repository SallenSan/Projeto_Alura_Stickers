import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradorDeFigurinhas {

    public void create (InputStream inputStream, String nomeArquivo) throws Exception {


        // leitura da imagem
        // InputStream inputStream =
        //  new FileInputStream(new File("input/image.jpg"));
        // InputStream inputStream =
        // new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        // .openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        // criar nova imagem em memória com transparência e com novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a nova imagem para a original (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        String texto = "Topzera";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D  retangulo = fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int) retangulo.getWidth();
        int posicaoTexto = (largura - larguraTexto) / 2;
        graphics.drawString(texto, posicaoTexto, novaAltura - 100);

        //graphics.drawString(texto, 100, novaAltura - 100);

        // escrever a nova imagem num arquivo
        ImageIO.write(novaImagem, "png", new File("nomeArquivo"));


    }
}
