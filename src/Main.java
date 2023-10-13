public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI("resources/background.jpg");

        Guerreiro guerreiro1 = new Guerreiro("João");
        Oraculo oraculo1 = new Oraculo("Oráculo Master",guerreiro1 );

        boolean level1 = oraculo1.loadLevel1();

        if (level1 || oraculo1.decidirVidaExtra()) {
            oraculo1.loadLevel2();
        }

        gui.fecharJanela();

    }

}