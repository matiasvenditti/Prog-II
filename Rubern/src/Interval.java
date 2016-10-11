import java.util.GregorianCalendar;

/**
 * Created by Matias on 11/10/2016.
 */
public class Interval {

    private GregorianCalendar fechaInicial, fechaFinal;

    private long inicial = fechaInicial.getTimeInMillis();
    private long fin = fechaFinal.getTimeInMillis();

    public Interval(GregorianCalendar fechaInicial, GregorianCalendar fechaFinal){
        long diferenciaEn_ms = fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis();
        long horas = diferenciaEn_ms/(1000*60*60);
        //Calcula el largo del intervalo en horas el cual tiene que estar entre [0,24]

        if (horas > 0 && Math.abs(horas) < 24){
            this.fechaInicial = fechaInicial;
            this.fechaFinal = fechaFinal;
        }
        else{
            throw new RuntimeException("Intervalo invalido.");
        }
    }



    public boolean containsHour(GregorianCalendar fechaActual){

        //Devuelve true si la fecha esta dentro del intervalo y false si no.
        boolean result = (fechaActual.getTimeInMillis() >= inicial && fechaActual.getTimeInMillis() <= fin)? true : false;
        return result;
    }
}
