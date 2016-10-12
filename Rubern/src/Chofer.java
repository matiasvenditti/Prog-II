import java.util.GregorianCalendar;

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

    public Auto getAuto() {
        return auto;
    }
}
