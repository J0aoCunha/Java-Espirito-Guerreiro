import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A classe Sprite é respponsável por armazenar
 * a imagem correspondente a folha de sprites
 * que pode ser utilizada em animações. Essa classe
 * encapsula os atributos e métodos necessários para
 * obter as texturas a partir de uma imagem PNG.
 * @see Animation
 */
public class Sprite {

    private BufferedImage spritesheet;
    private int qtdFrames;

    private int qtdLinhas;
    private static int tileSize = 128;

    /**
     * Instancia um novo objeto da classe e inicializa seus principais atributos.
     * @param caminhoArquivo caminho do arquivo de imagem da spritesheet.
     */
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

    /**
     * Retorna a imagem correspondente a uma das texturas disponíveis.
     * @param xGrid posição X do grid da spritesheet
     * @param yGrid posição Y do grid da spritesheet.
     * @return imagem correspondente a posição solicitada.
     * @see BufferedImage
     */
    public BufferedImage getSprite(int xGrid, int yGrid) {

        return spritesheet.getSubimage(xGrid * tileSize, yGrid * tileSize, tileSize, tileSize);

    }

    /**
     * Retorna a quantidade de linhas da spritesheet.
     * @return quantidade de linhas da spritesheet.
     */
    public int getQtdLinhas() {
        return qtdLinhas;
    }

    /**
     * Retorna a quantidade de frames por linha da spritesheet.
     * @return quantidade de frames por linha da spritesheet.
     */
    public int getFramesPorLinha() {
        return qtdFrames / qtdLinhas;
    }

}
