/**
 * Created by Matias on 21/10/2016.
 */
public class Tupla {

    private Chofer chofer;
    private double costoDeImagen;

    public Tupla(Chofer chofer, Double costo){
        this.chofer = chofer;
        costoDeImagen = costo;
    }

    public double getCostoDeImagen() {
        return costoDeImagen;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void printAlgo(){
        System.out.println("hola");
    }
}
