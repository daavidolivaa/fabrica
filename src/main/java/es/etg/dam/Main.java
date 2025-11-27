package es.etg.dam;

public class Main {
    public static void main(String[] args) {

        Fabrica fabrica = new Fabrica();

        Mecanico mecanico = new Mecanico(fabrica);
        Pintor pintor1 = new Pintor(fabrica, "Pintor 1");
        Pintor pintor2 = new Pintor(fabrica, "Pintor 2");

        Thread hiloMecanico = new Thread(mecanico);
        Thread hiloPintor1 = new Thread(pintor1);
        Thread hiloPintor2 = new Thread(pintor2);

        hiloMecanico.start();
        hiloPintor1.start();
        hiloPintor2.start();
    }
}