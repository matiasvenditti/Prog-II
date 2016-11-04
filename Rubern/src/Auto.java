import java.awt.geom.*;

/**
 * Created by Matias on 11/10/2016.
 */
public class Auto {


    private int capacidadMax;
    private Point2D coordenadasAuto;
    private CategoriaAuto categoria;

    public Auto(int unaCapacidadMaxima, Point2D coordenadasAuto, CategoriaAuto categoria){

        capacidadMax=unaCapacidadMaxima;
        this.coordenadasAuto = coordenadasAuto;
        this.categoria = categoria;
    }

    public CategoriaAuto getCategoria() {
        return categoria;
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
