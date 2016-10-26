import java.util.GregorianCalendar;

/**
 * Created by Matias on 26/10/2016.
 */
public class Viaje {

    private int identificador;
    private Point2D origen;
    private Point2D destino;
    private Cliente cliente;
    private Chofer chofer;
    private int pasajeros;
    private GregorianCalendar fecha;
    private double costo;
    private double comision;
    private double distancia;

    public Viaje (Point2D unOrigen, Point2D unDestino, Cliente unCliente, Chofer unChofer, int numeroPasajeros, GregorianCalendar unaFecha){

        int identificador= (int) (Math.random()*1000000);
        origen=unOrigen;
        destino=unDestino;
        cliente=unCliente;
        chofer=unChofer;
        pasajeros=numeroPasajeros;
        fecha=unaFecha;
        //Calcula la distancia del trayecto y la setea;
        distancia=Math.sqrt(Math.pow(destino.getxPosition()-origen.getxPosition(),2)+(Math.pow(destino.getyPosition()-origen.getyPosition(),2)));
        //Calcula y setea el costo del viaje;
        costo=15 + (distancia/100);
        comision= 0.1*costo;
    }

    public int dameIdentificador(){
        return identificador;
    }

    public Point2D dameOrigen(){
        return origen;
    }

    public Point2D dameDestino(){
        return destino;
    }

    public Cliente dameCliente(){
        return cliente;
    }

    public Chofer dameChofer(){
        return chofer;
    }

    public int dameNumeroPasajeros(){
        return pasajeros;
    }

    public GregorianCalendar dameFecha(){
        return fecha;
    }

    public double dameDistancia(){
        return distancia;
    }

    public double dameCosto(){
        return costo;
    }

    public double dameComision(){
        return comision;
    }

}
