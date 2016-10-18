import java.util.GregorianCalendar;

/**
 * Created by Matias on 11/10/2016.
 */
public class Solicitud {

    private int pasajeros;
    private Point2D inicio;
    private Point2D fin;
    private GregorianCalendar fecha;
    private Cliente cliente;

    public Solicitud(int pasajeros, Point2D inicio, Point2D fin, GregorianCalendar fecha, Cliente cliente){
        this.pasajeros = pasajeros;
        this.inicio = inicio;
        this.fin = fin;
        this.fecha = fecha;
        int identificador= (int) (Math.random()*1000000);
        this.cliente = cliente;

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
