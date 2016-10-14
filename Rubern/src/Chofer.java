import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by Matias on 11/10/2016.
 */

public class Chofer extends Persona{

    private Auto auto;
    private Interval jornada;
    private String name;
    private boolean disponible;

    public Chofer(Auto auto, Interval jornada, String nombre, String telefono, String email, TarjetaCredito tarjeta){
        super(nombre, telefono, email, tarjeta);
        this.auto = auto;
        this.jornada = jornada;
    }

    public boolean estaDisponible(GregorianCalendar fechaActual){
        if (jornada.containsHour(fechaActual) && disponible == true){
            return true;
        }
        return false;
    }

    public void enviarViaje(Solicitud solicitud){
        //Le asigno un 50% de chances de que el chofer acepte o no el viaje con un numero random.
        Random random = new Random();
        int number = random.nextInt(2);
        String result = number == 0 ? "El chofer acepto el viaje: " : "El chofer no acepto el viaje: ";
        System.out.println(result + solicitud.toString());
    }

    public Auto getAuto() {
        return auto;
    }

//    public void finalizarViaje(Solicitud solicitud){
//        disponible = true;
//    }
}
