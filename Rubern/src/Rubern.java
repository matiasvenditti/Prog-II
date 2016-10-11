import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matias on 11/10/2016.
 */
public class Rubern {

    private ArrayList<Chofer> choferes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private double distanciaMinima;
    private Map<Chofer, Double> costosDeImagen = new HashMap<>();

    public void iniciarViaje(Solicitud solicitud){
        // Por cada chofer disponible, y dentro de la distancia minima, se calcula el costo de imagen y se añade a un hashmap que
        // contiene choferes con sus respectivos costos de imagen para despues ordenar dicho mapa respecto de los costos de imagen asi
        // poder obtener el chofer cuyo costo sea menor.
        for(Chofer c: choferes){
            if (c.estaDisponible(solicitud.getFecha()) && (c.getAuto().getCoordenadasAuto().distance(solicitud.getInicio()) <= distanciaMinima)){
                calcularCantidadAutos(solicitud.getPasajeros(),c);
                costosDeImagen.put(c,calcularCantidadAutos(solicitud.getPasajeros(),c)*((c.getAuto().getCoordenadasAuto().distance(solicitud.getInicio()))/250));
            }
        }
        for (Map.Entry<Chofer, Double> entry: costosDeImagen.entrySet()){
            //OBTENER EL MENOR COSTO DE IMAGEN.
        }
    }

    public int calcularCantidadAutos(int numPasajeros, Chofer chofer){
        //Calcula cuantos autos van a ser necesarios para transportar un dado numero de pasajeros dada la capacidad del auto.

        int capacidad = chofer.getAuto().getCapacidadMax();
        int cantidadDeAutos = ((numPasajeros % capacidad) != 0) ? (int)(numPasajeros/capacidad) + 1 : (int)(numPasajeros/capacidad);
        return cantidadDeAutos;

    }

}
