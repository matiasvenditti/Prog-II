import java.util.GregorianCalendar;

/**
 * Created by Matias on 11/10/2016.
 */

public class Chofer {

    private Auto auto;
    private Interval jornada;
    private String name;

    private boolean disponible;

    public Chofer(Auto auto, Interval jornada, String name){
        this.auto = auto;
        this.jornada = jornada;
        this.name = name;
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
