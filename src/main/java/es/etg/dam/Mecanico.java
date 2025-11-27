package es.etg.dam;

public class Mecanico implements Runnable {

    private Fabrica fabrica;

    public Mecanico(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            Bicicleta bicicleta = new Bicicleta(Integer.toString(i));
            try {
                Thread.sleep(700);
                fabrica.colocar(bicicleta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fabrica.terminar();
        System.out.println("MECÁNICO -> Producción finalizada.");
    }

}
