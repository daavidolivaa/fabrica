package es.etg.dam;

public class Main {

    private final static String PINTOR1 = "Pintor 1";
    private final static String PINTOR2 = "Pintor 2";

    public static void main(String[] args) {

        Fabrica fabrica = new Fabrica();

        Mecanico mecanico = new Mecanico(fabrica);
        Pintor pintor1 = new Pintor(fabrica, PINTOR1);
        Pintor pintor2 = new Pintor(fabrica, PINTOR2);

        Thread hiloMecanico = new Thread(mecanico);
        Thread hiloPintor1 = new Thread(pintor1);
        Thread hiloPintor2 = new Thread(pintor2);

        hiloMecanico.start();

        hiloPintor1.start();

        hiloPintor2.start();
    }
}
