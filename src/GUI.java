import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {

    JFrame janela;
    JPanel painel;
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

        // Cria um novo container e adiciona a imagem a ele.
        painel = new JPanel();
        painel.add(imagemFundo);

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
