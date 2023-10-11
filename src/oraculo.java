import java.util.Random;
import java.util.Scanner;

public class oraculo {
    String Nome;
    guerreiro Warrior;
    Scanner Teclado = new Scanner(System.in);
    public oraculo(String nome, guerreiro guerreiro) {
        this.Nome = nome;
        this.Warrior = guerreiro;
    }

    public void prologoIntroducao() {

        InOut.MsgDeInformacao("Introduçao:", "Bem-vindo, Guerreiro " + Warrior.Nome + "Eu sou o  " + this.Nome + "Você possui " + Warrior.qtdVidas + " pontos vidas para enfrentar esta jornada épica.Vamos Jogar!");

}


    public int loadLevel1() {
        Random random = new Random();
        int numeroSorteado;
        int chuteNumeroAleatorio = 0;
        int min = 1;
        int max = 100;

        numeroSorteado = random.nextInt(max - min + 1) + min;

        for (int tentativas = 1; tentativas != numeroSorteado; tentativas++) {


            chuteNumeroAleatorio = InOut.leInt("Eu sorteei um número aleatório entre 1 e 100, PorFavor tente adivinhar.");

            if (chuteNumeroAleatorio < numeroSorteado) {
                InOut.MsgDeInformacao("Informaçao", "Voce chutou " + chuteNumeroAleatorio + " Chute um numero maior");
            } else if (chuteNumeroAleatorio > numeroSorteado) {
                InOut.MsgDeInformacao("Informaçao", "Voce chutou " + chuteNumeroAleatorio + " Chute um numero menor");
            } else {
                InOut.MsgDeInformacao("Informaçao", "Voce ganhou!!");
                break;
            }


            Warrior.diminuirVida();

        }
          return numeroSorteado;
    }


   public boolean loadLevel2(int opcao){

       Random random = new Random();
       int numeroGuerreiro, numeroOraculo, soma;
       int min = 0;
       int max = 5;

       numeroGuerreiro = random.nextInt(max - min + 1) + min;
       numeroOraculo = random.nextInt(max - min + 1) + min;

       soma = numeroGuerreiro + numeroOraculo;

       if((soma % 2 == 0 && opcao == 1)||(soma % 2 != 0 && opcao == 2)){
    InOut.MsgDeInformacao("Informaçao", "Você Ganhou!!");
       }else {
           InOut.MsgDeInformacao("Informaça", "Voce perdeu!!");
       }

        return true;
   }
}

