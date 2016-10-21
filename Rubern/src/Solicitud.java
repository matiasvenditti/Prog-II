

/**
 * Created by Matias on 11/10/2016.
 */
public class Solicitud {

    private int pasajeros;
    private Point2D inicio;
    private Point2D fin;
    private double hora;
    private Cliente cliente;

    public Solicitud(int pasajeros, Point2D inicio, Point2D fin, double hora, Cliente cliente){
        this.pasajeros = pasajeros;
        this.inicio = inicio;
        this.fin = fin;
        this.hora = hora;
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

    public double getFecha() {
        return hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String toString(){
        String result = "Inicio: " + inicio +"\nDestino: " + fin + "\nCantidad de pasajeros: " + pasajeros + "\nFecha: " + hora;
        return result;
    }
}
