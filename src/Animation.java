import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation implements ActionListener {

    private Sprite sprite;
    private JLabel component;
    private int colunaAtual;
    private int linhaAtual;

    public Animation(Sprite sprite, int delay) {

        // Define a propriedade sprite como o objeto passado como parâmetro.
        this.sprite = sprite;

        // Cria o componente e define como o primeiro frame.
        component = new JLabel();
        component.setIcon(new ImageIcon(sprite.getSprite(0,0)));
        colunaAtual = 0;
        linhaAtual = 0;

        // Cria e inicia o temporizador responsável por controlar o delay da animação.
        Timer timer = new Timer(delay, this);
        timer.start();

    }

    public JLabel getComponent() {
        return component;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Incrementa o frame atual
        colunaAtual++;

        // Se o frame atual já é da próxima linha, incrementar.
        if ((colunaAtual + 1) / (linhaAtual + 1) > sprite.getFramesPorLinha()) {
            linhaAtual++;
            colunaAtual = 0;
        }

        // Se o frame atual for menor que a quantidade de frames, atualizar. Se não, volte ao começo.
        if (colunaAtual + 1 <= sprite.getFramesPorLinha() && linhaAtual + 1 <= sprite.getQtdLinhas()) {
            component.setIcon(new ImageIcon(sprite.getSprite(colunaAtual,linhaAtual)));
        } else {
            component.setIcon(new ImageIcon(sprite.getSprite(0,0)));
            colunaAtual = 0;
            linhaAtual = 0;
        }

    }
}
