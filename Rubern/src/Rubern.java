import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matias on 11/10/2016.
 */
public class Rubern {

    private ArrayList<Chofer> choferes;
    private ArrayList<Cliente> clientes;
    private double distanciaMinima;
    private Map<Chofer, Double> costosDeImagen;

    public static void main (String[] args){
        //Hace que se escriba en el fichero de texto los cobros y pagos. Aún quedaría meterlo para que directamente cuando el cliente pague se ejecute.
        EscritorFichero escritor=new EscritorFichero();
        //escritor.escribir();
    }



    public Rubern(double distanciaMinima){
        choferes = new ArrayList<Chofer>();
        clientes = new ArrayList<Cliente>();
        costosDeImagen = new HashMap<Chofer,Double>();
        this.distanciaMinima = distanciaMinima;

    }

    public void iniciarViaje(Solicitud solicitud){
        // Por cada chofer disponible, y dentro de la distancia minima, se calcula el costo de imagen y se añade a un hashmap que
        // contiene choferes con sus respectivos costos de imagen para despues ordenar dicho mapa respecto de los costos de imagen asi
        // poder obtener el chofer cuyo costo sea menor.
        for(Chofer c: choferes){
            if (c.estaDisponible(solicitud.getFecha()) && (c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()) <= distanciaMinima)){
                calcularCantidadAutos(solicitud.getPasajeros(),c);
                costosDeImagen.put(c,calcularCantidadAutos(solicitud.getPasajeros(),c)*((c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()))/250));
                //Faltaria agregar la calidad del auto en el costo de imagen.
            }
        }
        Map.Entry<Chofer, Double> minimo = null;
        for (Map.Entry<Chofer, Double> entry: costosDeImagen.entrySet()){
            if (minimo == null || minimo.getValue() > entry.getValue()){
                minimo = entry;
            }

        }
        minimo.getKey().enviarViaje(solicitud);
        if (minimo.getKey().isAceptaViaje()){
            double comision = minimo.getKey().costo*0.1;
        }
    }

    public int calcularCantidadAutos(int numPasajeros, Chofer chofer){
        //Calcula cuantos autos van a ser necesarios para transportar un dado numero de pasajeros dada la capacidad del auto.

        int capacidad = chofer.getAuto().getCapacidadMax();
        int cantidadDeAutos = ((numPasajeros % capacidad) != 0) ? (int)(numPasajeros/capacidad) + 1 : (int)(numPasajeros/capacidad);
        return cantidadDeAutos;

    }

}
