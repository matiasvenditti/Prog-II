import java.util.Random;

/**
 * Created by Matias on 11/10/2016.
 */

public class Chofer extends Persona{

    private Auto auto;
    private Estado estado;
    private boolean aceptaViaje = false;
    public double distancia;
    public double costo;

    public Chofer(String nombre, TarjetaCredito tarjeta, Auto auto){
        super(nombre, 2112 + "", nombre + "@Rubern.com", tarjeta);
        this.auto = auto;
        estado = new Offline();
    }


    public void enviarViaje(Solicitud solicitud){
        /**
         * Le asigno un 50% de chances de que el chofer acepte o no el viaje con un numero random.
         * si el cliente no puede pagar el viaje o el chofer lo rechaza, no se realiza el viaje.
         */
        Random random = new Random();
        int number = random.nextInt(2);


        if (number == 0 && solicitud.getCliente().getTarjetaCredito().getSaldo() >= costo){
            viajar(solicitud);
            System.out.println("El chofer "+ this.getNombre() + " acepto el viaje: \n" + solicitud.toString());
            System.out.println("Con una distancia de: " + distancia + " Y con un costo de: " + costo);
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
        distancia = Math.sqrt(Math.pow(solicitud.getFin().getxPosition()-solicitud.getInicio().getxPosition(),2)+(Math.pow(solicitud.getFin().getyPosition()-solicitud.getInicio().getyPosition(),2)));
        costo = 15 + (distancia/100);
        aceptaViaje = true;
        cambiarEstado(new Working());
        this.getAuto().actualizarCoordenadas(solicitud.getFin());
        solicitud.getCliente().pagarViaje(costo,solicitud,this);
        solicitud.getCliente().setViajando(true);
    }

    public void finalizarViaje(){
        if (estado.isWorking()){
            cambiarEstado(new Online());
            aceptaViaje = false;
        }
        throw new RuntimeException("El chofer no se encuentra en ningun viaje.");
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
