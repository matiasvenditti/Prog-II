
/**
 * Created by Matias on 11/10/2016.
 */
public class Auto {

    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private int capacidadMax;
    private Point2D coordenadasAuto;

    public Auto(String unaMarca, String unModelo, String unColor, String unaMatricula, int unaCapacidadMaxima){

        marca=unaMarca;
        modelo=unModelo;
        color=unColor;
        matricula=unaMatricula;
        capacidadMax=unaCapacidadMaxima;
    }


    public String getMarca(){
        return marca;
    }

    public String getMoedelo(){
        return modelo;
    }

    public String getColor(){
        return color;
    }

    public String getMatricula(){
        return matricula;
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
