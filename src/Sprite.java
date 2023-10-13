import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    BufferedImage spritesheet;
    int qtdFrames;
    int qtdLinhas;
    static int tileSize = 128;

    public Sprite(String caminhoArquivo) {

        // Importa a imagem correspondente ao spritesheet
        spritesheet = null;
        try {
            spritesheet = ImageIO.read(new File(caminhoArquivo));
        } catch (IOException e) {
            InOut.MsgDeErro("Erro na imagem","Erro durante a importação da imagem:\n" + e.getMessage());
        }

        // Define a quantidade de frames disponíveis para animação.
        qtdLinhas = spritesheet.getHeight() / tileSize;
        qtdFrames = spritesheet.getWidth() / tileSize * qtdLinhas;

    }

    public BufferedImage getSprite(int xGrid, int yGrid) {

        return spritesheet.getSubimage(xGrid * tileSize, yGrid * tileSize, tileSize, tileSize);

    }

}
