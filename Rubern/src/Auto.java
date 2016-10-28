import java.awt.geom.*;

/**
 * Created by Matias on 11/10/2016.
 */
public class Auto {





    private int capacidadMax;
    private Point2D coordenadasAuto;

    public Auto(int unaCapacidadMaxima, Point2D coordenadasAuto){

        capacidadMax=unaCapacidadMaxima;
        this.coordenadasAuto = coordenadasAuto;
    }


    public int getCapacidadMax(){
        return capacidadMax;
    }

    public Point2D getCoordenadasAuto(){
        return coordenadasAuto;
    }

    public void actualizarCoordenadas(Point2D coordenadas){
        coordenadasAuto=coordenadas;
    }
}
