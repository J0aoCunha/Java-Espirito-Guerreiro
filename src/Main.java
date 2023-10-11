public class Main {
    public static void main(String[] args) {

        guerreiro guerreiro1 = new guerreiro("João", 11);
        oraculo oraculo1 = new oraculo("Oráculo Master",guerreiro1 );

        oraculo1.prologoIntroducao();
       // guerreiro1.setVidas();
        //oraculo1.loadLevel1();
        oraculo1.loadLevel2(InOut.leInt(" 1 = Par e 2 = Impar"));

    }

}