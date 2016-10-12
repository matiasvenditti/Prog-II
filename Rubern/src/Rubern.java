import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matias on 11/10/2016.
 */
public class Rubern {

    private ArrayList<Chofer> choferes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private double distanciaMinima;
    private Map<Chofer, Double> costosDeImagen = new HashMap<>();

    public static void main (String[] args){

        //Inicializacion de una persona para la prueba;
        TarjetaCredito tarjeta1 = new TarjetaCredito("777", 1000);
        Point2D coordenadasNaiara = new Point2D(1,2);
        Cliente naiara = new Cliente("Naiara", "+34644444397", "naiara@naiara.com", tarjeta1, coordenadasNaiara, 100);

        //Inicializacion de dos chófer para la prueba;
        Auto auto1=new Auto("BMW", "familiar", "negro", "3703BFX",6);
        Auto auto2=new Auto("Mercedes", "deportivo", "rojo", "1256BHB",4);
        Interval jornada1= new Interval();
        TarjetaCredito tarjeta2=new TarjetaCredito("444", 1000);
        TarjetaCredito tarjeta3=new TarjetaCredito("333", 1000);
        Chofer Juan= new Chofer(auto1, jornada1, "Juan", "+34644444444", "juan@juan.com", tarjeta2);
        Chofer Iker= new Chofer(auto2, jornada1, "Iker", "+34677777777", "iker@iker.com", tarjeta3);

        int operacion;
        operacion = Integer.parseInt(JOptionPane.showInputDialog("rUberN\n1. Solicitar viaje.\n2.Consultar viajes."));
        switch(operacion){
            case 1:
                double numPersonas = Integer.parseInt(JOptionPane.showInputDialog("Inserte número de viajeros: "));
                double puntoOrigenX = Double.parseDouble(JOptionPane.showInputDialog("Inserte coordenada X del origen: "));
                double puntoOrigenY = Double.parseDouble(JOptionPane.showInputDialog("Inserte coordenada Y del origen: "));
                double puntoDestinoX = Double.parseDouble(JOptionPane.showInputDialog("Inserte coordenada X del destino: "));
                double puntoDestinoY = Double.parseDouble(JOptionPane.showInputDialog("Inserte coordenada Y del destino: "));;
                Point2D puntoOrigen = new Point2D(puntoOrigenX,puntoOrigenY);
                Point2D puntoDestino;
                puntoOrigen = (2,2);
                puntoOrigen.setLocation(puntoOrigenX, puntoOrigenY);
                puntoDestino.setLocation(puntoOrigenX, puntoOrigenY);
                Solicitud solicitud=new Solicitud(numPersonas, puntoOrigen, puntoDestino, fecha);


            case 2:

        }
    }

    public void iniciarViaje(Solicitud solicitud){
        // Por cada chofer disponible, y dentro de la distancia minima, se calcula el costo de imagen y se añade a un hashmap que
        // contiene choferes con sus respectivos costos de imagen para despues ordenar dicho mapa respecto de los costos de imagen asi
        // poder obtener el chofer cuyo costo sea menor.
        for(Chofer c: choferes){
            if (c.estaDisponible(solicitud.getFecha()) && (c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()) <= distanciaMinima)){
                calcularCantidadAutos(solicitud.getPasajeros(),c);
                costosDeImagen.put(c,calcularCantidadAutos(solicitud.getPasajeros(),c)*((c.getAuto().getCoordenadasAuto().getDistance(solicitud.getInicio()))/250));
            }
        }
        for (Map.Entry<Chofer, Double> entry: costosDeImagen.entrySet()){
            //OBTENER EL MENOR COSTO DE IMAGEN.
        }
    }

    public int calcularCantidadAutos(int numPasajeros, Chofer chofer){
        //Calcula cuantos autos van a ser necesarios para transportar un dado numero de pasajeros dada la capacidad del auto.

        int capacidad = chofer.getAuto().getCapacidadMax();
        int cantidadDeAutos = ((numPasajeros % capacidad) != 0) ? (int)(numPasajeros/capacidad) + 1 : (int)(numPasajeros/capacidad);
        return cantidadDeAutos;

    }

}
