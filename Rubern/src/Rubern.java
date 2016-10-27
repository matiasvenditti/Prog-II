import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matias on 11/10/2016.
 */
public class Rubern {

    private ArrayList<Chofer> choferes;
    private ArrayList<Cliente> clientes;
    private double distanciaMinima;

    private ArrayList<Tupla> costosDeImagen;

    public static void main (String[] args){
        //Hace que se escriba en el fichero de texto los cobros y pagos. Aún quedaría meterlo para que directamente cuando el cliente pague se ejecute.
        EscritorFichero escritor=new EscritorFichero();
        //escritor.escribir();
    }



    public Rubern(double distanciaMinima){
        choferes = new ArrayList<Chofer>();
        clientes = new ArrayList<Cliente>();
        costosDeImagen = new ArrayList<Tupla>();
        this.distanciaMinima = distanciaMinima;

    }

    public void iniciarViaje(Solicitud solicitud){
        // Por cada chofer disponible, y dentro de la distancia minima, se calcula el costo de imagen y se añade a un hashmap que
        // contiene choferes con sus respectivos costos de imagen para despues ordenar dicho mapa respecto de los costos de imagen asi
        // poder obtener el chofer cuyo costo sea menor.
        for(Chofer c: choferes){
            if (c.estaDisponible(solicitud.getFecha()) && (c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()) <= distanciaMinima)){
                calcularCantidadAutos(solicitud.getPasajeros(),c);
                costosDeImagen.add(new Tupla (c,calcularCantidadAutos(solicitud.getPasajeros(),c)*((c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()))/250)));
                //Faltaria agregar la calidad del auto en el costo de imagen.
            }
        }
        Collections.sort(costosDeImagen,new ComparadorDeCostos());
        for (int i = 0; i< costosDeImagen.size(); i++){
            Tupla minimo = costosDeImagen.get(i);
            minimo.getChofer().enviarViaje(solicitud);
            if (costosDeImagen.get(i).getChofer().isAceptaViaje()){
                double comision = minimo.getChofer().costo*0.1;
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
