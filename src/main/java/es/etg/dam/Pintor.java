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

                if (bicicleta == null)

                    break;

                Thread.sleep(500);
                System.out.println(nombre.toUpperCase() + " -> Pintando bicicleta " + bicicleta.getNumeroSerie());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre.toUpperCase() + " -> Última bicicleta pintada. Fin del trabajo.");

    }

}
