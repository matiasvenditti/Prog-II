import java.util.Comparator;

/**
 * Created by Matias on 21/10/2016.
 */
public class ComparadorDeCostos implements Comparator<Tupla> {

    public int compare(Tupla d1, Tupla d2){
        if (d1.getCostoDeImagen() > d2.getCostoDeImagen()){
            return 1;
        }
        if (d1.getCostoDeImagen() < d2.getCostoDeImagen()){
            return -1;
        }
        return 0;
    }
}
