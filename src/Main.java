public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI("resources/background.jpg");

        Guerreiro guerreiro1 = new Guerreiro(InOut.leString("Informe seu nome."));
        Oraculo oraculo1 = new Oraculo("Oráculo Master",guerreiro1);

        gui.fecharJanela();

    }

}