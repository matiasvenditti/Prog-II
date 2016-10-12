import java.awt.geom.Point2D;
import java.util.GregorianCalendar;

/**
 * Created by Matias on 12/10/2016.
 */
public class Viaje {

    private Point2D origen;
    private Point2D destino;
    private Cliente cliente;
    private Chofer chofer;
    private int pasajeros;
    private GregorianCalendar fecha;
    private double costo;
    private double distancia;

    public Viaje (Point2D unOrigen, Point2D unDestino, Cliente unCliente, Chofer unChofer, int numeroPasajeros, GregorianCalendar unaFecha){

        origen=unOrigen;
        destino=unDestino;
        cliente=unCliente;
        chofer=unChofer;
        pasajeros=numeroPasajeros;
        fecha=unaFecha;
        //Calcula la distancia del trayecto y la setea;
        distancia=Math.sqrt(Math.pow(destino.getX()-origen.getX(),2)+(Math.pow(destino.getY()-origen.getY(),2)));
        //Calcula y setea el costo del viaje;
        costo=15 + (distancia/100);
    }
}
