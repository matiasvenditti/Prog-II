import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Naiara on 17/10/2016.
 */
public class EscritorFichero {


    public void escribir(String unTipo, String unaFecha, String unaHora, int unNumero, String unaDescripcion, double unMonto){

        int identificador= (int) (Math.random()*1000000);
        String tipo=unTipo;
        String fecha=unaFecha;
        String hora=unaHora;
        int numero=unNumero;
        String descripcion=unaDescripcion;
        double monto=unMonto;

        String frase="Tercer movimiento.";

        try {
            FileWriter escritura = new FileWriter("C:/Users/Administrador.000/Desktop/movimientos.txt", true);
            for (int i=0;i<frase.length();i++){
                escritura.write(frase.charAt(i));
            }
            escritura.write("\r\n");
            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


