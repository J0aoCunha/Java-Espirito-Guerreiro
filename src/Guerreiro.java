import java.util.Random;

/**
 * A classe Guerreiro permite a criação de um
 * jogador. Essa classe é responsável por encapsular
 * os atributos em métodos necessários para o gerenciamento
 * da gameplay do jogador, como seu nome e sua quantidade de vidas.
 */
public class Guerreiro {

    private String nome;
    private int qtdVidas;

    /**
     * Instancia um novo objeto da classe, inicializando
     * seus principais atributos e definindo sua quantidade
     * de vida por sorteio.
     * @param nome do guerreiro
     */
    public Guerreiro(String nome) {
        this.nome = nome;
        setVidas();
    }

    /**
     * Retorna o nome do guerreiro.
     * @return nome do guerreiro
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a quantidade de vidas do guerreiro.
     * @return quantidade de vidas do guerreiro.
     */
    public int getQtdVidas() {
        return qtdVidas;
    }

    /**
     * Define a quantidade de vidas do guerreiro entre [9, 12]
     * por meio de um sorteio utilizando um número randômico.
     */
    private void setVidas(){
        Random random = new Random();
        int min = 9;
        int max = 12;
        this.qtdVidas = random.nextInt(max - min + 1) + min;
    }

    /**
     * Aumenta a quantidade de vidas do guerreiro em 1 unidade.
     */
    public void aumentarVida() {
        this.qtdVidas++;
    }

    /**
     * Diminui a quantidade de vidas do guerreiro em 1 unidade e
     * alerta essa mudança ao jogador.
     */
    public void diminuirVida(){
       this.qtdVidas --;

       if(this.qtdVidas > 0){
           InOut.MsgDeAviso("Alerta", "Você perdeu um ponto de vida. Agora você tem " + this.qtdVidas + ".");
       }else {
           InOut.MsgDeErro("Alerta", "Que pena! Você perdeu.");
       }
    }

    /**
     * Lê uma String do apelo do jogador por uma vida extra.
     * @return o apelo do jogador
     */
    public String vidaExtra(){

       return InOut.leString("Implore pela sua VIDA HAHAHAHA!");

    }

}
