import java.util.Random;

public class guerreiro {
    String Nome;
    int qtdVidas;

    public guerreiro(String nome, int qtdvidas) {
        this.Nome = nome;
        this.qtdVidas = qtdvidas;

    }

 //   String vidaExtra(){
 //       return setVidas(qtdvidas);
 //   }
    Random random = new Random();

   int setVidas(int qtdvidas){
       this.qtdVidas = qtdvidas;
       int numeroSorteado = 0;

       if(qtdvidas >= 9 && qtdvidas <=12){

           int min = 0;
           int max = 20;
            numeroSorteado = random.nextInt(max - min + 1) + min;
       }

       System.out.println("Você recebeu " + numeroSorteado + " pontos de vida extra!!");
       return numeroSorteado;
   }

}
