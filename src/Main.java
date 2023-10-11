public class Main {
    public static void main(String[] args) {

        guerreiro guerreiro1 = new guerreiro("João", 11);
        oraculo oraculo1 = new oraculo("Mago Supremo",guerreiro1 );

        oraculo1.prologoIntroducao();
        guerreiro1.setVidas();
        oraculo1.loadLevel1();
    }

}