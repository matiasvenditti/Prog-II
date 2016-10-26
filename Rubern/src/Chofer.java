import java.util.Random;

/**
 * Created by Matias on 11/10/2016.
 */

public class Chofer extends Persona{

    private Auto auto;
    private Interval jornada;
    private String name;
    private boolean disponible;
    private boolean aceptaViaje = false;
    public double distancia = 0;
    public double costo = 0;

    public Chofer(Auto auto, Interval jornada, String nombre, String telefono, String email, TarjetaCredito tarjeta){
        super(nombre, telefono, email, tarjeta);
        this.auto = auto;
        this.jornada = jornada;
    }

    public boolean estaDisponible(double hora){
        if (jornada.containsHour(hora) && disponible ){
            return true;
        }
        return false;
    }

    public void enviarViaje(Solicitud solicitud){
        //Le asigno un 50% de chances de que el chofer acepte o no el viaje con un numero random.
        // si el cliente no puede pagar el viaje o el chofer lo rechaza, no se realiza el viaje.
        Random random = new Random();
        int number = random.nextInt(2);

        if (number == 0 && solicitud.getCliente().getTarjetaCredito().getSaldo() > costo){
            System.out.println("El chofer acepto el viaje: " + solicitud.toString());

            System.out.println("Con un costo de: " + distancia);
            viajar(solicitud);
        }
        else{
            System.out.println("El chofer no acepto el viaje: " + solicitud.toString());
            aceptaViaje = false;
        }

    }

    public void viajar(Solicitud solicitud){
        //acepta el viaje, no esta mas disponible, se actualizan las coordenadas del auto, y se cobra al cliente.
        double distancia = Math.sqrt(Math.pow(solicitud.getFin().getxPosition()-solicitud.getInicio().getxPosition(),2)+(Math.pow(solicitud.getFin().getyPosition()-solicitud.getInicio().getyPosition(),2)));
        costo = 15 + (distancia/100);
        aceptaViaje = true;
        disponible = false;
        this.getAuto().actualizarCoordenadas(solicitud.getFin());
        solicitud.getCliente().pagarViaje(costo,solicitud,this);
        solicitud.getCliente().setViajando(true);
    }

    public boolean isAceptaViaje() {
        return aceptaViaje;
    }

    public Auto getAuto() {
        return auto;
    }

//    public void finalizarViaje(Solicitud solicitud){
//        disponible = true;
//    }
}
