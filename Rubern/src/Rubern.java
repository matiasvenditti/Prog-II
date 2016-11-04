import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Matias on 11/10/2016.
 */
public class Rubern {

    private ArrayList<Chofer> choferes;
    private ArrayList<Cliente> clientes;
    private double distanciaMinima;
    private double ganancias;
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
        ganancias = 0;

    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }



    /**
     * Por cada chofer disponible, y dentro de la distancia minima, se calcula el costo de imagen y se añade a una lista de tuplas que
     * contiene choferes con sus respectivos costos de imagen para despues ordenar dicha lista respecto de los costos de imagen asi
     * poder obtener el chofer cuyo costo sea menor.
     */

    public void iniciarViaje(Solicitud solicitud){
        for (Chofer c: choferes){
            if (c.getEstado().isOnline() && (c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()) <= distanciaMinima && solicitud.getPasajeros() <= c.getAuto().getCapacidadMax())){
                costosDeImagen.add(new Tupla(c,(c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()))/250));

            }
            else if (c.getEstado().isOnline() && solicitud.getPasajeros() <= c.getAuto().getCapacidadMax()){
                System.out.println("El chofer " + c.getNombre() + " no puede realizar el viaje ya que se encuentra fuera del rango minimo.");
            }
            else if (c.getEstado().isOnline() && (c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()) <= distanciaMinima)){
                System.out.println("El chofer " + c.getNombre() + " no puede realizar el viaje porque el numero de pasajeros excede la capacidad del auto.");
            }
            else{
                System.out.println("El chofer " + c.getNombre() + " no puede realizar el viaje dado que no se encuentra en linea.");
            }
        }
        if (!costosDeImagen.isEmpty()){
            Collections.sort(costosDeImagen, new ComparadorDeCostos());
            for (int i = 0; i < costosDeImagen.size(); i++){
                costosDeImagen.get(i).getChofer().enviarViaje(solicitud);
                if (costosDeImagen.get(i).getChofer().isAceptaViaje()) {
                    this.añadirGanancias(solicitud.getCosto()*0.1);
                    break;
                }
            }
        }
        else{
            System.out.println("El viaje fue rechazado.");
        }

    }

    public void añadirGanancias(double ganancias){
        this.ganancias += ganancias;
    }

    public String getStatus(){
        ArrayList<String> nombresChoferes = new ArrayList<>();
        for (Chofer chofer: choferes){
            nombresChoferes.add(chofer.getNombre());
        }

        ArrayList<String> nombresClientes = new ArrayList<>();
        for(Cliente client: clientes){
            nombresClientes.add(client.getNombre());
        }

        return "Agencia Rubern\nChoferes: " + nombresChoferes + "\nClientes: " + nombresClientes + "\nDistancia minima : " + this.distanciaMinima + "\nGanancias: " + this.ganancias;
    }




}

