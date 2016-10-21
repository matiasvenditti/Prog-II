

/**
 * Created by Matias on 11/10/2016.
 */
public class Interval {


    private double horaInicial, horaFinal;

    public Interval(double horaInicial,double horaFinal){
        double horas = horaFinal - horaInicial;
        //Calcula el largo del intervalo en horas el cual tiene que estar entre [0,24]

        if (horas > 0 && Math.abs(horas) < 24){
            this.horaInicial = horaInicial;
            this.horaFinal = horaFinal;
        }
        else{
            throw new RuntimeException("Intervalo invalido.");
        }
    }



    public boolean containsHour(double hora){

        //Devuelve true si la fecha esta dentro del intervalo y false si no.
        return  hora >= horaInicial && hora <= horaFinal;
    }
}
