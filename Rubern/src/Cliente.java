import java.awt.geom.Point2D;
import java.util.GregorianCalendar;

/**
 * Created by Matias on 11/10/2016.
 */
public class Cliente {

    private String name;
    private Point2D coordenadasCliente;
    private double saldo;

    public Cliente(String name, Point2D coordenadasCliente, double saldo) {
        this.name = name;
        this.coordenadasCliente = coordenadasCliente;
        this.saldo = saldo;
    }

    public void solicitarViaje(int pasajeros, Point2D coordenadasDestino, GregorianCalendar fecha) {
        if (!coordenadasDestino.equals(coordenadasCliente)) {
            Solicitud solicitudDeViaje = new Solicitud(pasajeros, coordenadasDestino, coordenadasCliente, fecha);
        } else {
            throw new RuntimeException("El cliente ya se encuentra en el destino.");
        }
    }
}
