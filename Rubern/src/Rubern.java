import java.util.ArrayList;

/**
 * Created by Matias on 11/10/2016.
 */
public class Rubern {

    private ArrayList<Chofer> choferes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private double distanciaMinima;

    public void iniciarViaje(Solicitud solicitud){
        for(Chofer c: choferes){
            if (c.estaDisponible(solicitud.getFecha())){  //AGREGAR EL TEMA DE QUE TIENEN QUE ESTAR DENTRO DE LA DISTANCIA MINIMA
                calcularCantidadAutos(solicitud.getPasajeros(),c);

            }
        }
    }

    public int calcularCantidadAutos(int numPasajeros, Chofer chofer){
        //Calcula cuantos autos van a ser necesarios para transportar un dado numero de pasajeros dada la capacidad del auto.

        int capacidad = chofer.getAuto().getCapacidadMax();
        int cantidadDeAutos = ((numPasajeros % capacidad) != 0) ? (int)(numPasajeros/capacidad) + 1 : (int)(numPasajeros/capacidad);
        return cantidadDeAutos;

    }

}
