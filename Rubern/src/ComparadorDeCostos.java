import java.util.Comparator;

/**
 * Created by Matias on 28/10/2016.
 */
public class ComparadorDeCostos implements Comparator<Tupla> {


    @Override
    public int compare(Tupla o1, Tupla o2) {
        return (int)(o1.getCostoDeImagen() - o2.getCostoDeImagen());
    }
}
