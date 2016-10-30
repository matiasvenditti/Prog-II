
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

    public Solicitud solicitarViaje(int pasajeros,Point2D coordenadasInicio, Point2D coordenadasDestino, double hora) {
        if (!coordenadasDestino.equals(coordenadasInicio)) {
            return new Solicitud(pasajeros,coordenadasInicio, coordenadasDestino, hora, this);
        } else {
            throw new RuntimeException("El cliente ya se encuentra en el destino.");
        }
    }

    public void pagarViaje(double costo, Solicitud viaje, Chofer chofer){

        getTarjetaCredito().disminuir(costo);
        chofer.getTarjetaCredito().cargarSaldo(costo - 0.1*costo);
    }

    public String getStatus(){
        String estado = viajando? "Viajando." : "Viaje terminado.";
        return "Nombre: " + this.getNombre() + "\nNumero de Tarjeta: " + this.getTarjetaCredito().getNumero() + "\nSaldo: " + this.getTarjetaCredito().getSaldo() + "\nEstado: " + estado;
    }
}
