import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Matias on 14/10/2016.
 */
public class Main {

    public static void main (String[] args){
//        EscritorFichero escritura = new EscritorFichero();
//        escritura.escribir("Cobro", "25/10/2016", "14:40", 1234, "Cobro del viaje mediante tarjeta", 2000);
//
//        int opcion;
//        opcion = Integer.parseInt(JOptionPane.showInputDialog("rUberN\n1. Insertar nuevo cliente.\n2.Insertar nuevo chófer."));
//        switch(opcion){
//            case 1:
//                String nombreC = (JOptionPane.showInputDialog("Introduzca nombre: "));
//                String telefonoC = (JOptionPane.showInputDialog("Introduzca telefono: "));
//                String emailC = (JOptionPane.showInputDialog("Introduzca email: "));
//                String numTarjetaC = (JOptionPane.showInputDialog("Introduzca número de la tarjeta de pago: "));
//                TarjetaCredito tarjetaC = new TarjetaCredito(numTarjetaC,1000);
//                Cliente cliente= new Cliente(nombreC, telefonoC, emailC, tarjetaC);
//                System.out.println("Datos almacenados correctamente");
//                break;
//            case 2:
//                String nombre = (JOptionPane.showInputDialog("Introduzca nombre: "));
//                String telefono = (JOptionPane.showInputDialog("Introduzca telefono: "));
//                String email = (JOptionPane.showInputDialog("Introduzca email: "));
//                String numTarjeta = (JOptionPane.showInputDialog("Introduzca número de la tarjeta de pago: "));
//                String marca = (JOptionPane.showInputDialog("Introduzca marca del auto: "));
//                String modelo = (JOptionPane.showInputDialog("Introduzca el modelo del auto: "));
//                String color = (JOptionPane.showInputDialog("Introduzca el color del auto: "));
//                String matricula = (JOptionPane.showInputDialog("Introduzca matrícula del auto: "));
//                int capacidadMaxima = Integer.parseInt(JOptionPane.showInputDialog("Introduzca capacidad máxima del auto: "));
//                Auto auto = new Auto(marca, modelo, color, matricula, capacidadMaxima);
//                TarjetaCredito tarjeta = new TarjetaCredito(numTarjeta,1000);
//                Chofer chofer= new Chofer(auto, nombre, telefono, email, tarjeta);
//                System.out.println("Datos almacenados correctamente");
//        }


        Rubern r;
        ArrayList<Chofer> list = new ArrayList<>();
        int quantity = Scanner.getInt("Escribir la cantidad de Choferes: ");
        for (int i = 0; i < quantity; i++) {
            list.add(new Chofer(new Auto("VolksWagen",
                    "Ka",
                    "Indigo",
                    "FBO703",
                    Scanner.getInt("Ingrese la capacidad maxima del auto: ")),
                    new Interval(Scanner.getDouble("Ingrese un inicio: "),
                    Scanner.getDouble("Ingrese un fin: ")),
                    Scanner.getString("Escribir el nombre del Chofer: "),
                    new TarjetaCredito(Scanner.getLong("Ingrese un numero de tarjeta: "),
                    Scanner.getInt("Ingrese una saldo: "))));
        }
        r = new Rubern(100, list);
        int command = 1;
        while(command != 0){
            System.out.println("1. Para agregar cliente\nOtra tecla. Para salir del programa");
            command = Scanner.getInt("Ingrese un comando: ");
            switch(command){
                case 1:
                    
                    break;
                default:
                    command = 0;
            }
        }

        /**
         * Statistics
         */
    }
}
