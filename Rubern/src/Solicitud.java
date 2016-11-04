import java.util.Date;

/**
 * Created by Matias on 11/10/2016.
 */
public class Solicitud {

    private int pasajeros;
    private Point2D inicio;
    private Point2D fin;
    private double hora;
    private Cliente cliente;
    private double distancia;
    private double costo;
    private Date fecha;

    public Solicitud(int pasajeros, Point2D inicio, Point2D fin, Cliente cliente, Date fecha, double hora){
        this.pasajeros = pasajeros;
        this.inicio = inicio;
        this.fin = fin;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        distancia = Math.sqrt(Math.pow(fin.getxPosition()- inicio.getxPosition(),2)+(Math.pow(fin.getyPosition() - inicio.getyPosition(),2)));
        costo = 15 + (distancia/100);


    }

    public Date getFecha(){
        return fecha;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getCosto() {
        return costo;
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

    public Cliente getCliente() {
        return cliente;
    }

    public String toString(){
        String result = "Desde: \n" + inicio.toString() +"\nHasta: \n" + fin.toString() + "\nCantidad de pasajeros: " + pasajeros + "\nHora: " + hora;
        return result;
    }
}
