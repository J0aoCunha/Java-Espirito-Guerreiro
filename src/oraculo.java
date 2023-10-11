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

    public String prologoIntroducao() {

        String introducao = "Bem-vindo, Guerreiro " + Warrior.Nome + "!\n";
        introducao += "Eu sou o "   +this.Nome+  "!\n";
        introducao += "Você possui " + Warrior.qtdVidas + " pontos vidas para enfrentar esta jornada épica.\n \n";
        introducao += "Vamos Jogar!";
        
        System.out.println(introducao);

        return introducao;
    }
    public int loadLevel1() {
        Random random = new Random();
        int numeroSorteado = 0;

        int chuteNumeroAleatorio;
        int i = 0;
        int min = 1;
        int max = 100;

        numeroSorteado = random.nextInt(max - min + 1) + min;

        System.out.println("Eu sorteei um número aleatório entre 1 e 100, PorFavor tente adivinhar.");

        for(int tentativas = 1; tentativas != numeroSorteado; tentativas++){

            chuteNumeroAleatorio = Teclado.nextInt();

          if (chuteNumeroAleatorio < numeroSorteado){
              System.out.println("chute um numero maior");
          } else if (chuteNumeroAleatorio > numeroSorteado) {
              System.out.println("chute um numero menor\n");
          }else {
              System.out.println("parabens voce acertou o numero!!");
              break;
          }

          Warrior.qtdVidas --;

          if(Warrior.qtdVidas > 0){
              System.out.println("Você perdeu um ponto de vida. Agora você tem " + Warrior.qtdVidas);
          }else {
              System.out.println("Suas Vidas acabaram. Você perdeu!!");
          }

        }

        return numeroSorteado;
    }
}
