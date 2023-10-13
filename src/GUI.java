import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {

    JFrame janela;
    JLayeredPane painel;
    JLabel imagemFundo;
    Dimension dimensoesTela;

    public GUI(String caminhoBackground) {

        // Instancia uma nova janela (JFrame) e define como maximizada.
        janela = new JFrame();
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setTitle("Espírito Guerreiro");

        // Define o encerramento do programa quando se a janela for fechada.
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtêm as dimensões da tela.
        dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();

        // Cria o componente que irá ficar com a imagem de fundo.
        imagemFundo = new JLabel();
        ImageIcon imagem = criarImageIcon(caminhoBackground);
        ImageIcon imagemRedimensionada = redimensionarImagemParaTela(imagem, dimensoesTela);
        imagemFundo.setIcon(imagemRedimensionada);
        imagemFundo.setBounds(0,0,dimensoesTela.width, dimensoesTela.height);

        // Cria um novo container e adiciona a imagem a ele.
        painel = new JLayeredPane();
        painel.add(imagemFundo,1);

        Animation animation = new Animation(new Sprite("resources/oraculo-spritesheet.png"),100);
        painel.add(animation.component,0);
        int xOraculo = (int) Math.round(dimensoesTela.width * 0.275);
        int yOraculo = (int) Math.round(dimensoesTela.height * 0.58);
        animation.component.setBounds(xOraculo,yOraculo,128,128);

        // Adiciona o container a janela e deixa ela visível.
        janela.add(painel);
        janela.setVisible(true);

    }

    public static ImageIcon criarImageIcon(String caminhoArquivo) {

        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(caminhoArquivo));
        } catch (IOException e) {
            InOut.MsgDeErro("Erro na imagem","A imagem selecionada para o fundo não conseguiu ser localizada, confira o erro:\n" + e.getMessage());
        }

        return new ImageIcon(imagem);

    }

    public static ImageIcon redimensionarImagemParaTela(ImageIcon imagem, Dimension dimensoes) {

        Image imgRedimensionada = imagem.getImage().getScaledInstance(dimensoes.width, dimensoes.height, Image.SCALE_DEFAULT);

        return new ImageIcon(imgRedimensionada);
    }

    public void fecharJanela() {
        janela.dispatchEvent(new WindowEvent(janela, WindowEvent.WINDOW_CLOSING));
    }

}