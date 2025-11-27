package es.etg.dam;

public class Fabrica {

    private final String MENSAJE_MECANICO = "Mecánico -> Bicicleta ensamblada: ";
    private Bicicleta bicicleta;
    private boolean terminada = false;

    public boolean isTerminada() {
        return terminada;
    }

    public synchronized void colocar(Bicicleta bicicleta) throws InterruptedException {

        while (this.bicicleta != null) {
            wait();
        }
        this.bicicleta = bicicleta;
        System.out.println(MENSAJE_MECANICO + bicicleta.getNumeroSerie());
        notifyAll();
    }

    public synchronized Bicicleta recoger() throws InterruptedException {
        while (bicicleta == null && !terminada) {
            wait();
        }

        if (bicicleta == null && !terminada) {
            return null;
        }

        Bicicleta bici = this.bicicleta;
        this.bicicleta = null;
        notifyAll();
        return bici;

    }

    public synchronized void terminar() {
        terminada = true;
        notifyAll();
    }
}
