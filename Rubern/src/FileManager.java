import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Matias on 3/11/2016.
 */
public class FileManager {
    private File archivo;
    private BufferedWriter bw;

    public FileManager(String ruta)throws IOException{
        archivo = new File(ruta);
        bw = new BufferedWriter(new FileWriter(archivo));

    }

    public void write(String mensaje)throws IOException{
        bw.write(mensaje);
    }

    public void close()throws IOException{
        bw.close();
    }


}
