
/**
 * Created by Matias on 11/10/2016.
 */
public class Cliente extends Persona{


    private boolean viajando;

    public void setViajando(boolean estado) {
        viajando = estado;
    }

    /**
     * Cambiar los parametros
     *
     */
    public Cliente(String nombre, TarjetaCredito tarjeta) {
        super(nombre, 2020 + "", nombre + "@austra.edu.ar", tarjeta);
        viajando = false;

    }

    public void solicitarViaje(int pasajeros,Point2D coordenadasInicio, Point2D coordenadasDestino, double hora) {
        if (!coordenadasDestino.equals(coordenadasInicio)) {
            Solicitud solicitudDeViaje = new Solicitud(pasajeros,coordenadasInicio, coordenadasDestino, hora, this);
        } else {
            throw new RuntimeException("El cliente ya se encuentra en el destino.");
        }
    }

    public void pagarViaje(double costo, Solicitud viaje, Chofer chofer){

        getTarjetaCredito().disminuir(costo);
        chofer.getTarjetaCredito().cargarSaldo(costo - 0.1*costo);
    }
}
