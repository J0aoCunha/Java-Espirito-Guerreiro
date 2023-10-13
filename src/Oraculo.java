import java.util.Objects;
import java.util.Random;

public class Oraculo {
    private String nome;
    private Guerreiro warrior;

    public Oraculo(String nome, Guerreiro guerreiro) {
        this.nome = nome;
        this.warrior = guerreiro;
        prologoIntroducao();
    }

    private void prologoIntroducao() {

        InOut.MsgDeInformacao("Introdução", "Bem-vindo, Guerreiro "  + warrior.getNome() + "!\nEu sou o " + this.nome + ".\nVocê possui " + warrior.getQtdVidas() + " vidas para enfrentar esta jornada épica!\n\nVamos Jogar?");

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
       } else {
           warrior.diminuirVida();
           return false;
       }

       return true;
   }

   public boolean decidirVidaExtra() {
        String apelo = warrior.vidaExtra();
        int contagemPalavras = apelo.split(" ").length;
        return contagemPalavras > 5;
   }

}

