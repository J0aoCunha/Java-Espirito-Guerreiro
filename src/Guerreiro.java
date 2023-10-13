import java.util.Random;

public class Guerreiro {
    String nome;
    int qtdVidas;

    public Guerreiro(String nome) {
        this.nome = nome;
        setVidas();
    }


   void setVidas(){
        Random random = new Random();
           int min = 9;
           int max = 12;
           this.qtdVidas = random.nextInt(max - min + 1) + min;
   }


   public  void diminuirVida(){
       this.qtdVidas --;

       if(this.qtdVidas > 0){
           InOut.MsgDeAviso("Alerta", "Você perdeu um ponto de vida. Agora você tem " + this.qtdVidas + ".");
       }else {
           InOut.MsgDeErro("Alerta", "Que pena! Você perdeu.");
       }

   }

   public String vidaExtra(){

       return InOut.leString("Implore pela sua VIDA HAHAHAHA!");

   }

}
