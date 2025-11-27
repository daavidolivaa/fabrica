package es.etg.dam;

public class Pintor implements Runnable {

    private Fabrica fabrica;
    private String nombre;

    public Pintor(Fabrica fabrica, String nombre) {
        this.fabrica = fabrica;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (!fabrica.isTerminada()) {
            try {
                Bicicleta bicicleta = fabrica.recoger();
                Thread.sleep(1000);
                System.out.println("El pintor " + nombre + " ha terminado " + bicicleta.getNumeroSerie());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El pintor " + nombre + " ha terminado");
    }

}
