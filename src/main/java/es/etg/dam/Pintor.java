package es.etg.dam;

public class Pintor implements Runnable {

    private final String MENSAJE = " -> Pintando bicicleta ";
    private final String MENSAJE_FINAL = " -> Última bicicleta pintada. Fin del trabajo.";
    private final int TIEMPO = 500;

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

                if (bicicleta == null) {
                    break;
                }

                Thread.sleep(TIEMPO);
                System.out.println(nombre + MENSAJE + bicicleta.getNumeroSerie());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + MENSAJE_FINAL);

    }

}
