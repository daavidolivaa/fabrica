package es.etg.dam;

public class Mecanico implements Runnable {

    private Fabrica fabrica;

    public Mecanico(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Bicicleta bicicleta = new Bicicleta(Integer.toString(i));
            try {
                Thread.sleep(1000);
                fabrica.colocar(bicicleta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fabrica.terminar();
        System.out.println("El mecanico ha terminado ");
    }

}
