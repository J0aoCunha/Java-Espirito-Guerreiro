import java.util.Random;

public class guerreiro {
    String Nome;
    int qtdVidas;

    public guerreiro(String nome, int qtdvidas) {
        this.Nome = nome;
        this.qtdVidas = qtdvidas;

    }
  //  String vidaExtra(){
  //  return setVidas(this.qtdVidas);
  // }
    Random random = new Random();

   int setVidas(){
       int numeroSorteado = 0;

       if(qtdVidas >= 9 && qtdVidas <=12){

           int min = 9;
           int max = 12;
            numeroSorteado = random.nextInt(max - min + 1) + min;

            this.qtdVidas += numeroSorteado;

           System.out.println("Você recebeu " + numeroSorteado + " pontos de vida extra!!\nAgora você tem " + this.qtdVidas+ " \n");
       }

       return qtdVidas;

   }


   public  void diminuirVida(){
       this.qtdVidas --;

       if(this.qtdVidas > 0){
           InOut.MsgDeAviso("Alerta", "Você perdeu um ponto de vida. Agora você tem " + this.qtdVidas);
       }else {
           InOut.MsgDeErro("Alerta", "Você Perdeu o jogo");
       }

   }


}
