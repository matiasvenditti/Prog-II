import java.util.Date;

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

    public Solicitud solicitarViaje(int pasajeros,Point2D coordenadasInicio, Point2D coordenadasDestino,Date fecha, double hora) {
        if (coordenadasDestino.equals(coordenadasInicio) || this.isViajando()) {
            throw new RuntimeException("El cliente ya se encuentra en el destino o esta actualmente en u viaje.");

        } else {
            return new Solicitud(pasajeros,coordenadasInicio, coordenadasDestino,this,fecha,hora);
        }
    }

    public void pagarViaje(Solicitud viaje, Chofer chofer){

        getTarjetaCredito().disminuir(viaje.getCosto());
        chofer.getTarjetaCredito().cargarSaldo(viaje.getCosto()- 0.1*viaje.getCosto());
    }

    public String getStatus(){
        String estado = viajando? "Viajando." : "No se encuentra viajando.";
        return "Nombre: " + this.getNombre() + "\nNumero de Tarjeta: " + this.getTarjetaCredito().getNumero() + "\nSaldo: " + this.getTarjetaCredito().getSaldo() + "\nEstado: " + estado;
    }

    public boolean isViajando() {
        return viajando;
    }
}
