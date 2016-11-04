import java.util.Random;

/**
 * Created by Matias on 11/10/2016.
 */

public class Chofer extends Persona{

    private Auto auto;
    private Estado estado;
    private boolean aceptaViaje;
    private Solicitud solicitudActual;

    public Chofer(String nombre, TarjetaCredito tarjeta, Auto auto){
        super(nombre, 2112 + "", nombre + "@Rubern.com", tarjeta);
        this.auto = auto;
        estado = new Offline();
        aceptaViaje = false;
        solicitudActual = null;
    }


    public void enviarViaje(Solicitud solicitud){
        /**
         * Le asigno un 50% de chances de que el chofer acepte o no el viaje con un numero random.
         * si el cliente no puede pagar el viaje o el chofer lo rechaza, no se realiza el viaje.
         */
        Random random = new Random();
        int number = random.nextInt(2);


        if (number == 0 && solicitud.getCliente().getTarjetaCredito().getSaldo() >= solicitud.getCosto()){
            viajar(solicitud);
            solicitudActual = solicitud;
            System.out.println("El chofer "+ this.getNombre() + " acepto el viaje: \n" + solicitud.toString());
            System.out.println("Con una distancia de: " + solicitud.getDistancia() + " Y con un costo de: " + solicitud.getCosto());
        }
        else{
            System.out.println("El chofer "+ this.getNombre()+ " no acepto el viaje: \n" + solicitud.toString());
            aceptaViaje = false;
        }

    }

    public void viajar(Solicitud solicitud){
        /**
         * acepta el viaje, no esta mas disponible, se actualizan las coordenadas del auto, y se cobra al cliente.
         */

        aceptaViaje = true;
        cambiarEstado(new Working());
        solicitud.getCliente().setViajando(true);
    }

    public void finalizarViaje(Solicitud solicitud){
        if (!this.getEstado().isWorking()){
            System.out.println("El chofer no se encuentra en ningun viaje.");
        }
        cambiarEstado(new Online());
        aceptaViaje = false;
        solicitud.getCliente().setViajando(false);
        this.getAuto().actualizarCoordenadas(solicitud.getFin());
        solicitud.getCliente().pagarViaje(solicitud,this);
        System.out.println("Rubern tuvo una ganancia de: " + solicitud.getCosto()*0.1);


    }

    public Solicitud getSolicitudActual() {
        return solicitudActual;
    }

    public Auto getAuto() {
        return auto;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getStatus(){
        return "Nombre: " + this.getNombre() + "\nNumero de Tarjeta: " + this.getTarjetaCredito().getNumero() + "\nSaldo: " + this.getTarjetaCredito().getSaldo() + "\nEstado: " + estado.toString();
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public boolean isAceptaViaje() {
        return aceptaViaje;
    }

}
