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

        String introducao = "Bem-vindo, Guerreiro " + Nome + "!\n";
        introducao += "Você possui " + Warrior.qtdVidas + " vidas para enfrentar esta jornada épica.";

        System.out.println(introducao);

        return introducao;
    }

}
