import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A classe GUI é responsável pela interface gráfica
 * do programa. Ela encapsula os métodos responsáveis pela
 * exibição de elemento, além de possuir alguns métodos
 * estáticos utilitários.
 */
public class GUI {

    private JFrame janela;
    private JLayeredPane container = new JLayeredPane();
    protected static Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Instancia um novo objeto da classe e inicializa seus principais atributos.
     * @param caminhoBackground caminho do arquivo para a imagem do plano de fundo.
     */
    public GUI(String caminhoBackground) {

        // Cria a janela e define seu background.
        setJanela("Espírito Guerreiro");
        JLabel imagemFundo = criarImagemFundo(caminhoBackground);

        // Cria a animação do oráculo e define sua posição.
        Animation animation = new Animation(new Sprite("resources/oraculo-spritesheet.png"),100);
        JComponent animationComponent = animation.getComponent();
        int xOraculo = (int) Math.round(dimensoesTela.width * 0.275);
        int yOraculo = (int) Math.round(dimensoesTela.height * 0.58);
        animationComponent.setBounds(xOraculo,yOraculo,128,128);

        // Adiciona os elementos criados ao container.
        container.add(imagemFundo,999);
        container.add(animationComponent,0);

        // Adiciona o container a janela e deixa ela visível.
        janela.add(container);
        janela.setVisible(true);

    }

    /**
     * Define o atributo janela da interface gráfica.
     * Além de deixá-la maximizada por padrão e finalizar
     * o programa ao fechá-la.
     * @param titulo da janela
     */
    private void setJanela(String titulo) {

        janela = new JFrame();
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setTitle(titulo);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Fecha a janela.
     */
    public void fecharJanela() {
        janela.dispatchEvent(new WindowEvent(janela, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Retorna um objeto ImageIcon a partir de um caminho de arquivo de imagem.
     * @param caminhoArquivo caminho do arquivo da imagem.
     * @return o ImageIcon correspondente a imagem.
     * @see ImageIcon
     */
    public static ImageIcon criarImageIcon(String caminhoArquivo) {

        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(caminhoArquivo));
        } catch (IOException e) {
            InOut.MsgDeErro("Erro na imagem","A imagem selecionada para o fundo não conseguiu ser localizada, confira o erro:\n" + e.getMessage());
        }

        return new ImageIcon(imagem);

    }

    /**
     * Retorna um ImageIcon redimensionado de acordo com os parâmetros repassados.
     * @param imagem o objeto ImageIcon da imagem a ser redimensionada.
     * @param dimensoes as dimensões para qual a imagem será redimensionada.
     * @return o objeto ImageIcon da imagem redimensionada.
     * @see Dimension
     * @see ImageIcon
     */
    public static ImageIcon redimensionarImagemParaTela(ImageIcon imagem, Dimension dimensoes) {

        Image imgRedimensionada = imagem.getImage().getScaledInstance(dimensoes.width, dimensoes.height, Image.SCALE_DEFAULT);

        return new ImageIcon(imgRedimensionada);
    }

    /**
     * Retorna um componente de imagem de fundo a partir de um caminho de arquivo.
     * @param caminhoArquivo caminho do arquivo da imagem de fundo.
     * @return o componente que contêm a imagem de fundo.
     * @see JLabel
     */
    private static JLabel criarImagemFundo (String caminhoArquivo) {

        JLabel imagemFundo = new JLabel();
        ImageIcon imagem = criarImageIcon(caminhoArquivo);
        ImageIcon imagemRedimensionada = redimensionarImagemParaTela(imagem, dimensoesTela);
        imagemFundo.setIcon(imagemRedimensionada);
        imagemFundo.setBounds(0,0,dimensoesTela.width, dimensoesTela.height);

        return imagemFundo;
    }

}
