/**
 * Created by Matias on 12/10/2016.
 */
public class Persona {
    private String nombre;
    private  String telefono;
    private String email;
    private TarjetaCredito tarjeta;
    private boolean libre;

    public Persona(String unNombre, String unTelefono, String unEmail, TarjetaCredito unaTarjeta){

        nombre=unNombre;
        telefono=unTelefono;
        email=unEmail;
        tarjeta=unaTarjeta;
    }

    public String getNombre(){

        return nombre;
    }

    public String getTelefono(){

        return telefono;
    }

    public String getEmail(){

        return email;
    }

    public TarjetaCredito getTarjetaCredito(){

        return tarjeta;
    }

    public void setLibre(boolean estado){

        libre=estado;
    }
    public boolean estaLibre(){

        return libre;
    }
}
