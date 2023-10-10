import java.util.Random;

public class oraculo {
    String Nome;
    guerreiro Warrior;
    public oraculo(String nome, guerreiro guerreiro) {
        this.Nome = nome;
        this.Warrior= guerreiro;
    }

 public  String setNome() {
     return Nome;
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

        int min = 1;
        int max = 100;

        numeroSorteado = random.nextInt(max - min + 1) + min;

        System.out.println("Eu sorteei um número aleatório entre 1 e 100, PorFavor tente adivinhar.");

        

        return numeroSorteado;
    }
}
