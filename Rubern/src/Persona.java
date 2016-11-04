/**
 * Created by Matias on 12/10/2016.
 */
public class Persona {
    private String nombre;
    private  String telefono;
    private String email;
    private TarjetaCredito tarjeta;

    public Persona(String unNombre, String unTelefono, String unEmail, TarjetaCredito unaTarjeta){

        nombre=unNombre;
        telefono=unTelefono;
        email=unEmail;
        tarjeta=unaTarjeta;
    }

    public String getNombre(){return nombre;}

    public TarjetaCredito getTarjetaCredito(){return tarjeta;}


}
