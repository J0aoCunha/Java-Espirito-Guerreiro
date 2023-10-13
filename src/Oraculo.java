import java.util.Objects;
import java.util.Random;

public class Oraculo {
    private String nome;
    private Guerreiro warrior;

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

    private boolean prologoIntroducao() {

        String[] opcoes = {"Não", "Sim"};
        int escolha = InOut.leOpcoes("Introdução",this.nome + ": Bem-vindo, Guerreiro "  + warrior.getNome() + "! Eu sou o " + this.nome + ".\n" + this.nome + ": No Espírito Guerreiro, você passará por alguns desafios. Cuidado! Você possui apenas " + warrior.getQtdVidas() + " vidas para enfrentar esta jornada épica!\nSe você ganhar o desafio, revelarei algo sobre seu futuro.\nVamos Jogar?", opcoes);

        return escolha != 0;

    }

    private void prologoVencedor() {
        InOut.MsgDeInformacao("Fim de Jogo", this.nome + ": Guerreiro "  + warrior.getNome() + ", parabéns! Com muita determinação, você ganhou.\n" + this.nome + ": Parabéns pela coragem e perspicácia! Seu caminho é muito promissor e seu futuro é brilhante.");
    }

    private void prologoPerdedor() {
        InOut.MsgDeInformacao("Fim de Jogo", this.nome + ": Guerreiro "  + warrior.getNome() + ", que pena! Infelizmente, você perdeu o jogo.\n" + this.nome + ": Tente novamente.");
    }

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

   public boolean decidirVidaExtra() {
        String apelo = warrior.vidaExtra();
        int contagemPalavras = apelo.split(" ").length;
        warrior.aumentarVida();
        return contagemPalavras > 5;
   }

}

