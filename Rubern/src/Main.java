import javax.swing.*;

/**
 * Created by Matias on 14/10/2016.
 */
public class Main {

    public static void main (String[] args){
        EscritorFichero escritura = new EscritorFichero();
        escritura.escribir("Cobro", "25/10/2016", "14:40", "1234", "Cobro del viaje mediante tarjeta", 2000);

        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("rUberN\n1. Insertar nuevo cliente.\n2.Insertar nuevo chófer."));
        switch(opcion){
            case 1:
                String nombreC = (JOptionPane.showInputDialog("Introduzca nombre: "));
                String telefonoC = (JOptionPane.showInputDialog("Introduzca telefono: "));
                String emailC = (JOptionPane.showInputDialog("Introduzca email: "));
                String numTarjetaC = (JOptionPane.showInputDialog("Introduzca número de la tarjeta de pago: "));
                TarjetaCredito tarjetaC = new TarjetaCredito(numTarjetaC,1000);
                Cliente cliente= new Cliente(nombreC, telefonoC, emailC, tarjetaC);
                System.out.println("Datos almacenados correctamente");
                break;
            case 2:
                String nombre = (JOptionPane.showInputDialog("Introduzca nombre: "));
                String telefono = (JOptionPane.showInputDialog("Introduzca telefono: "));
                String email = (JOptionPane.showInputDialog("Introduzca email: "));
                String numTarjeta = (JOptionPane.showInputDialog("Introduzca número de la tarjeta de pago: "));
                String marca = (JOptionPane.showInputDialog("Introduzca marca del auto: "));
                String modelo = (JOptionPane.showInputDialog("Introduzca el modelo del auto: "));
                String color = (JOptionPane.showInputDialog("Introduzca el color del auto: "));
                String matricula = (JOptionPane.showInputDialog("Introduzca matrícula del auto: "));
                int capacidadMaxima = Integer.parseInt(JOptionPane.showInputDialog("Introduzca capacidad máxima del auto: "));
                Auto auto = new Auto(marca, modelo, color, matricula, capacidadMaxima);
                TarjetaCredito tarjeta = new TarjetaCredito(numTarjeta,1000);
                Chofer chofer= new Chofer(auto, nombre, telefono, email, tarjeta);
                System.out.println("Datos almacenados correctamente");
        }
    }
}
