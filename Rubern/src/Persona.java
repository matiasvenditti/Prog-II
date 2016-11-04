/**
 * Created by Matias on 12/10/2016.
 */
public class Persona {
    private String nombre;
    private TarjetaCredito tarjeta;

    public Persona(String unNombre, TarjetaCredito unaTarjeta){

        nombre=unNombre;
        tarjeta=unaTarjeta;
    }

    public String getNombre(){return nombre;}

    public TarjetaCredito getTarjetaCredito(){return tarjeta;}


}
