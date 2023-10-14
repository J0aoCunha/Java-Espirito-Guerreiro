import java.util.Objects;
import java.util.Random;

/**
 * A classe Oraculo permite a criação de um novo jogo.
 * Essa classe encapsula os atributos e métodos
 * necessários para a execução dos níveis do jogo.
 */
public class Oraculo {
    private String nome;
    private Guerreiro warrior;

    /**
     * Instancia um novo objeto da classe, inicializando seus principais atributos.
     * Além de executar a história e os níveis do jogo.
     * @param nome do oráculo
     * @param guerreiro jogador associado ao oráculo.
     */
    public Oraculo(String nome, Guerreiro guerreiro) {
        this.nome = nome;
        this.warrior = guerreiro;
        boolean level1 = false, level2 = false;
        boolean desejaJogar = prologoIntroducao();

        if (desejaJogar) {
            level1 = loadLevel1();
            if (warrior.getQtdVidas() == 0){
                decidirVidaExtra();
            }
        } else {
            return;
        }

        if (level1 && warrior.getQtdVidas() > 0) {
            level2 = loadLevel2();
        }

        if (level1 && level2) {
            prologoVencedor();
        } else {
            prologoPerdedor();
        }

    }

    /**
     * Exibe a história introdutória do jogo e pergunta se o jogador
     * deseja iniciar o jogo.
     * @return booleano que define se o jogador quer ou não jogar
     */
    private boolean prologoIntroducao() {

        String[] opcoes = {"Sim", "Não"};
        int escolha = InOut.leOpcoes("Introdução",this.nome + ": Bem-vindo, Guerreiro "  + warrior.getNome() + "! Eu sou o " + this.nome + ".\n" + this.nome + ": No Espírito Guerreiro, você passará por alguns desafios. Cuidado! Você possui apenas " + warrior.getQtdVidas() + " vidas para enfrentar esta jornada épica!\nSe você ganhar o desafio, revelarei algo sobre seu futuro.\nVamos Jogar?", opcoes);

        return escolha != 1;

    }

    /**
     * Exibe a história final caso o jogador vença ambos os níveis.
     */
    private void prologoVencedor() {
        InOut.MsgDeInformacao("Fim de Jogo", this.nome + ": Guerreiro "  + warrior.getNome() + ", parabéns! Com muita determinação, você ganhou.\n" + this.nome + ": Parabéns pela coragem e perspicácia! Seu caminho é muito promissor e seu futuro é brilhante.");
    }

    /**
     * Exibe a história final caso o jogador perca um ou mais níveis.
     */
    private void prologoPerdedor() {
        InOut.MsgDeInformacao("Fim de Jogo", this.nome + ": Guerreiro "  + warrior.getNome() + ", que pena! Infelizmente, você perdeu o jogo.\n" + this.nome + ": Tente novamente.");
    }

    /**
     * Executa a fase 1 do jogo, que consiste em um
     * jogo de adivinhação, onde o jogador precisa
     * adivinhar o número de 1 a 100 sorteado pelo oráculo.
     * @return booleano se o jogador venceu ou não a fase.
     */
    public boolean loadLevel1() {
        Random random = new Random();
        int numeroSorteado;
        int min = 1;
        int max = 100;

        numeroSorteado = random.nextInt(max - min + 1) + min;

        InOut.MsgDeAviso("Nível 1","Tente adivinhar o número de 1 a 100 que eu sorteei aleatoriamente!\nLembre-se que a cada tentativa errada, uma vida será perdida.");

        while (warrior.getQtdVidas() > 0) {

            int chuteNumeroAleatorio = InOut.leInt("Insira sua tentativa:");

            if (chuteNumeroAleatorio < numeroSorteado) {
                InOut.MsgDeInformacao("Nível 1", "Seu chute foi " + chuteNumeroAleatorio + ". Chute um número maior.");
            } else if (chuteNumeroAleatorio > numeroSorteado) {
                InOut.MsgDeInformacao("Nível 1", "Seu chute foi " + chuteNumeroAleatorio + ". Chute um número menor.");
            } else {
                InOut.MsgDeInformacao("Nível 1", "Parabéns, você acertou!");
                return true;
            }

            warrior.diminuirVida();

        }

        return false;
    }

    /**
     * Executa a fase 2 do jogo, que consiste em
     * um jogo de ímpar ou par em que o jogador
     * precisa selecionar sua opção e verificar
     * se a soma dos números sorteados será correspondente
     * a sua opção inicial.
     * @return booleano se o jogador venceu ou não a fase.
     */
   public boolean loadLevel2(){

        while (warrior.getQtdVidas() > 0) {
            String[] opcoes = {"Par","Ímpar"};
            int opcao = InOut.leOpcoes("Nível 2","Selecione par ou ímpar.", opcoes);

            Random random = new Random();
            int numeroGuerreiro, numeroOraculo, soma;
            int min = 0;
            int max = 5;

            numeroGuerreiro = random.nextInt(max - min + 1) + min;
            numeroOraculo = random.nextInt(max - min + 1) + min;

            soma = numeroGuerreiro + numeroOraculo;

            if((soma % 2 == 0 && Objects.equals(opcoes[opcao], "Par"))||(soma % 2 != 0 && Objects.equals(opcoes[opcao], "Ímpar"))){
                InOut.MsgDeInformacao("Nível 2", "Parabéns, você acertou!\nA soma dos números era " + soma + ".");
                return true;
            } else {
                warrior.diminuirVida();
            }
        }

        return false;

   }

    /**
     * Define se o jogador terá direito a uma vida extra
     * ou não baseado em seu apelo. Caso ele possua mais de
     * 5 palavras, seu apelo será aceito.
     * @return booleano se o jogador obteve ou não a vida extra.
     */
   public boolean decidirVidaExtra() {
        String apelo = warrior.vidaExtra();
        int contagemPalavras = apelo.split(" ").length;
        if (contagemPalavras > 5) {
            warrior.aumentarVida();
        }
        return contagemPalavras > 5;
   }

}

