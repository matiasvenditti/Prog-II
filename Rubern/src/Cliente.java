//import java.awt.geom.Point2D;
import java.util.GregorianCalendar;

/**
 * Created by Matias on 11/10/2016.
 */
public class Cliente extends Persona{


    private Point2D coordenadasCliente;

    public Cliente(String nombre, String telefono, String email, TarjetaCredito tarjeta, Point2D coordenadasCliente, double saldo) {
        super(nombre, telefono, email, tarjeta);
        this.coordenadasCliente = coordenadasCliente;
    }

    public void solicitarViaje(int pasajeros, Point2D coordenadasDestino, GregorianCalendar fecha) {
        if (!coordenadasDestino.equals(coordenadasCliente)) {
            Solicitud solicitudDeViaje = new Solicitud(pasajeros, coordenadasDestino, coordenadasCliente, fecha, this);
        } else {
            throw new RuntimeException("El cliente ya se encuentra en el destino.");
        }
    }

    public void pagarViaje(double costo, Solicitud viaje, Chofer chofer){

        getTarjetaCredito().disminuir(costo);
        chofer.getTarjetaCredito().cargarSaldo(costo - 0.1*costo);
    }
}
