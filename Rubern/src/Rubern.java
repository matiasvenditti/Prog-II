import java.util.ArrayList;

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



    public Rubern(double distanciaMinima, ArrayList<Chofer> choferes){
        this.choferes = choferes;
        clientes = new ArrayList<>();
        costosDeImagen = new ArrayList<>();
        this.distanciaMinima = distanciaMinima;

    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Por cada chofer disponible, y dentro de la distancia minima, se calcula el costo de imagen y se añade a un hashmap que
     * contiene choferes con sus respectivos costos de imagen para despues ordenar dicho mapa respecto de los costos de imagen asi
     * poder obtener el chofer cuyo costo sea menor.
     */
    public void iniciarViaje(Solicitud solicitud){
        int quantity = solicitud.getPasajeros();
        while(quantity > 0)
           quantity -= iniciar(solicitud);
    }

    private int iniciar(Solicitud solicitud){
        Tupla aux;
        Tupla current = null;
        for(Chofer c: choferes){
            if (c.estaDisponible(solicitud.getFecha()) && (c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()) <= distanciaMinima)){
                aux = new Tupla (c,calcularCantidadAutos(solicitud.getPasajeros(),c)*((c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()))/250));
                if(current == null || current.getCostoDeImagen() > aux.getCostoDeImagen())
                    current = aux;
                //Faltaria agregar la calidad del auto en el costo de imagen.
            }
        }
        return current.getChofer().getAuto().getCapacidadMax();
    }

    public int calcularCantidadAutos(int numPasajeros, Chofer chofer){
        //Calcula cuantos autos van a ser necesarios para transportar un dado numero de pasajeros dada la capacidad del auto.

        int capacidad = chofer.getAuto().getCapacidadMax();
        int cantidadDeAutos = ((numPasajeros % capacidad) != 0) ? (int)(numPasajeros/capacidad) + 1 : (int)(numPasajeros/capacidad);
        return cantidadDeAutos;

    }

}
