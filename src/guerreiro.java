import java.util.Random;

public class guerreiro {
    String Nome;
    int qtdVidas;

    public guerreiro(String nome) {
        this.Nome = nome;
    }


   int setVidas(){
        Random random = new Random();
           int min = 9;
           int max = 12;
           this.qtdVidas = random.nextInt(max - min + 1) + min;

       return this.qtdVidas;
   }


   public  void diminuirVida(){
       this.qtdVidas --;

       if(this.qtdVidas > 0){
           InOut.MsgDeAviso("Alerta", "Você perdeu um ponto de vida. Agora você tem " + this.qtdVidas);
       }else {
           InOut.MsgDeErro("Alerta", "Você Perdeu o jogo");
       }

   }


   public String vidaExtra(){

        String  implorandoVida = InOut.leString("Implore pela sua VIDA HAHAHAHA");
        this.qtdVidas += 1;

        return implorandoVida;
   }

}
