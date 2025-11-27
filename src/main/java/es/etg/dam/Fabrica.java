package es.etg.dam;

//region critica / objeto compartido

public class Fabrica {

    private Bicicleta bicicleta; // objetos
    private boolean terminada = false;

    public boolean isTerminada() { // getter
        return terminada;
    }

    public synchronized void colocar(Bicicleta bicicleta) throws InterruptedException { // metodo
                                                                                        // lo que esta dentro del
                                                                                        // parentesis es lo que le pasas
                                                                                        // al metodo
                                                                                        // void va a ser cuando no
                                                                                        // devuelga algo
        while (bicicleta != null && !terminada) { // exclamacion = es que es disinto
            wait();
        }
        this.bicicleta = bicicleta;
        System.out.println("Se ha colocado la " + bicicleta.getNumeroSerie());
        notifyAll();
    }

    public synchronized Bicicleta recoger() throws InterruptedException { // metodo
        while (bicicleta == null && !terminada) { // && !terminada es para cuando tengo bicicletas y no va a haber mas
                                                  // bicicletas
            wait();
        }
        Bicicleta bicicleta = this.bicicleta;
        this.bicicleta = null;
        notifyAll();
        return bicicleta;
    }

    public synchronized void terminar() { // metodo
        terminada = true;
        notifyAll();
    }
}
