import java.util.GregorianCalendar;

/**
 * Created by Matias on 11/10/2016.
 */
public class Solicitud {

    private int pasajeros;
    private Point2D inicio;
    private Point2D fin;
    private GregorianCalendar fecha;

    public Solicitud(int pasajeros, Point2D inicio, Point2D fin, GregorianCalendar fecha){
        this.pasajeros = pasajeros;
        this.inicio = inicio;
        this.fin = fin;
        this.fecha = fecha;

    }

    public int getPasajeros() {
        return pasajeros;
    }

    public Point2D getInicio() {
        return inicio;
    }

    public Point2D getFin() {
        return fin;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public String toString(){
        String result = "Inicio: " + inicio +"\nDestino: " + fin + "\nCantidad de pasajeros: " + pasajeros + "Fecha: " + fecha.toString();
        return result;
    }
}
