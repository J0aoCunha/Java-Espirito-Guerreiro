import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation implements ActionListener {

    Sprite sprite;
    Timer timer;
    JLabel component;
    int frameAtual;

    public Animation(Sprite sprite, int delay) {

        // Define a propriedade sprite como o objeto passado como parâmetro.
        this.sprite = sprite;

        // Cria o componente e define como o primeiro frame.
        component = new JLabel();
        component.setIcon(new ImageIcon(sprite.getSprite(0,0)));
        frameAtual = 0;

        // Cria e inicia o temporizador responsável por controlar o delay da animação.
        timer = new Timer(delay, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Incrementa o frame atual
        frameAtual++;

        /* Se o frame atual for maior do que a quantidade disponível, volte para o ínicio.
         * Se não, altere para a imagem a seguir.
         */
        if (frameAtual >= sprite.qtdFrames - 1) {
            component.setIcon(new ImageIcon(sprite.getSprite(0,0)));
            frameAtual = 0;
        } else {
            component.setIcon(new ImageIcon(sprite.getSprite(frameAtual,0)));
        }

    }
}
