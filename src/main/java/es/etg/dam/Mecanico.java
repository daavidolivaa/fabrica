package es.etg.dam;

public class Mecanico implements Runnable {

    private final String MENSAJE_MECANICO = "Mecánico -> Producción finalizada.";
    private final int TIEMPO = 700;
    private final int CANTIDAD = 10;

    private Fabrica fabrica;

    public Mecanico(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        for (int i = 1; i <= CANTIDAD; i++) {
            Bicicleta bicicleta = new Bicicleta(Integer.toString(i));
            try {
                Thread.sleep(TIEMPO);
                fabrica.colocar(bicicleta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fabrica.terminar();
        System.out.println(MENSAJE_MECANICO);
    }

}
