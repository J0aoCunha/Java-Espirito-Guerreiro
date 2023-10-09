import java.util.Random;

public class guerreiro {
    String Nome;
    int qtdVidas;

    void vidaExtra(){
        String vidaExtra;
    }
    Random random = new Random();
    int min = 1;
    int max = 20;

   int setVidas(int qtdvidas){
       this.qtdVidas = qtdvidas;
       if(qtdvidas >= 9 && qtdvidas <=12){
           int numeroSorteado = random.nextInt(max - min + 1) + min;
       }
       return setVidas(qtdvidas);
   }

}
