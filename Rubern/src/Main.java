import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Matias on 14/10/2016.
 */
public class Main {

    public static void main (String[] args) {
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

        /**
         * Inicializa el programa agregando una lista de choferes y poniendolos en linea.
         */
        Rubern r;
        ArrayList<Chofer> list = new ArrayList<>();
        int quantity = Scanner.getInt("Escribir la cantidad de Choferes: ");
        for (int i = 0; i < quantity; i++) {
            System.out.println("----------------AGREGANDO CHOFER NUMERO " + (i+1) + " DE " + quantity + "----------------");
            Chofer chofer = new Chofer( Scanner.getString("Escribir el nombre del Chofer: "),new TarjetaCredito(Scanner.getLong("Ingrese un numero de tarjeta: "), Scanner.getInt("Ingrese una saldo: ")), new Auto(Scanner.getInt("Ingrese la capacidad maxima del auto: "), new Point2D(Scanner.getDouble("Posicion en X del auto: "), Scanner.getDouble("Posicion en Y del auto: "))));
            chofer.cambiarEstado(new Online());
            list.add(chofer);

        }
        r = new Rubern(100, list);
        int command = 1;
        while (command != 0) {
            System.out.println("1. Para agregar cliente\n2. Para crear una solicitud de viaje.\n3. Para obtener datos de algun cliente.\n4. Para opciones de Choferes.\n5. Para obtener datos de la agencia.\nOtra para salir del programa");
            command = Scanner.getInt("Ingrese un comando: ");
            switch (command) {
                case 1:
                    /**
                     * Agrego un cliente nuevo a la lista de clientes de rubern.
                     */
                    System.out.println("----------------AGREGANDO CLIENTE----------------");
                    Cliente client = new Cliente(Scanner.getString("Ingrese nombre del cliente: "), new TarjetaCredito(Scanner.getLong("Ingrese numero de tarjeta: "), Scanner.getDouble("Ingrese un saldo: ")));
                    r.getClientes().add(client);
                    System.out.println("--------------------------------");
                    break;

                case 2:
                    /**
                     * Busco un cliente para iniciar un viaje.
                     */
                    System.out.println("----------------SOLICITANDO UN VIAJE----------------");
                    ArrayList<String> nombresClientes = new ArrayList<>();
                    for(Cliente client2: r.getClientes()){
                        if (!client2.isViajando()){
                            nombresClientes.add(client2.getNombre());
                        }
                    }
                    System.out.println("Clientes que actualmente no estan en un viaje encontrados en la lista de Rubern : ");
                    System.out.println(nombresClientes);

                    Cliente clientDeBusqueda = null;
                    String result = "Y";
                    while (result.equals("Y")) {
                        String cliente = Scanner.getString("Ingrese el nombre del cliente que busca: ");
                        for (int i = 0; i < r.getClientes().size(); i++) {
                            if (r.getClientes().get(i).getNombre().equals(cliente)) {
                                System.out.println("----------------CREANDO SOLICITUD DE VIAJE----------------");
                                clientDeBusqueda = r.getClientes().get(i);
                                Solicitud nuevaSolicitud = clientDeBusqueda.solicitarViaje(Scanner.getInt("Cantidad de pasajeros: "), new Point2D(Scanner.getDouble("Posicion inicial en X: "), Scanner.getDouble("Posicion inicial en Y: ")), new Point2D(Scanner.getDouble("Posicion final en X: "), Scanner.getDouble("Posicion final en Y: ")), Scanner.getDouble("Hora de viaje: "));
                                System.out.println("--------------------------------");
                                r.iniciarViaje(nuevaSolicitud);
                                result = "N";
                            }

                        }
                        if (clientDeBusqueda == null){
                            System.out.println("Cliente no encontrado, le gustaria buscar otro?");
                            result = Scanner.getString("[Y/N]: ");


                        }
                        else{
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 3:
                    /**
                     * Busco un cliente para obtener sus datos.
                     */
                    System.out.println("----------------OBTENENIENDO DATOS DE CLIENTE----------------");
                    int size3 = r.getClientes().size();
                    String[] clientes3 = new String[size3];
                    for (int i = 0; i<r.getClientes().size(); i++){
                        clientes3[i] = r.getClientes().get(i).getNombre();
                    }
                    System.out.println("Clientes encontrados en la lista de Rubern: ");
                    System.out.println(java.util.Arrays.toString(clientes3));

                    Cliente Otrocliente = null;
                    String Otroresultado = "Y";
                    while (Otroresultado.equals("Y")) {
                        String cliente = Scanner.getString("Ingrese el nombre del cliente que busca: ");
                        for (int i = 0; i < r.getClientes().size(); i++) {
                            if (r.getClientes().get(i).getNombre().equals(cliente)) {
                                Otrocliente = r.getClientes().get(i);
                                System.out.println(Otrocliente.getStatus());
                                Otroresultado = "N";
                            }


                        }
                        if (Otrocliente == null){
                            System.out.println("Cliente no encontrado, le gustaria buscar otro?");
                            Otroresultado = Scanner.getString("[Y/N]: ");
                        }
                        else{
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 4:
                    /**
                     * Busca un chofer para finalizar el viaje si es que esta viajando, y ademas da su estado.
                     */

                    int comando = 1;
                    while(comando != 0) {
                        System.out.println("1. Para obtener los datos de algun Chofer\n2. Para finalizar el viaje de algun Chofer\nOtro comando para volver al menu principal.");
                        comando = Scanner.getInt("Ingrese un comando: ");
                        switch (comando) {
                            case 1:
                                System.out.println("----------------OBTENIENDO DATOS DE CHOFER----------------");
                                ArrayList<String> nombresChoferes1 = new ArrayList<>();
                                for (Chofer c : r.getChoferes()) {
                                    nombresChoferes1.add(c.getNombre());
                                }
                                System.out.println("Choferes en la lista de Rubern: " + nombresChoferes1);
                                Chofer choferDeBusqueda = null;
                                String otroResultado1 = "Y";
                                while (otroResultado1.equals("Y")) {
                                    String chofer = Scanner.getString("Ingrese el nombre del chofer que busca: ");
                                    for (int i = 0; i < r.getChoferes().size(); i++) {
                                        if (r.getChoferes().get(i).getNombre().equals(chofer)) {
                                            choferDeBusqueda = r.getChoferes().get(i);
                                            System.out.println(choferDeBusqueda.getStatus());
                                            otroResultado1 = "N";
                                        }


                                    }
                                    if (choferDeBusqueda == null) {
                                        System.out.println("Chofer no encontrado, le gustaria buscar otro?");
                                        otroResultado1 = Scanner.getString("[Y/N]: ");
                                    } else {
                                        System.out.println("--------------------------------");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("----------------FINALIZANDO VIAJE DE ALGUN CHOFER----------------");
                                ArrayList<String> nombresChoferes = new ArrayList<>();
                                for (Chofer chofer4 : r.getChoferes()) {
                                    if (chofer4.getEstado().isWorking()) {
                                        nombresChoferes.add(chofer4.getNombre());
                                    }
                                }
                                System.out.println("Choferes que actualmente se encuentran viajando en la lista de Rubern: ");
                                System.out.println(nombresChoferes);
                                Chofer choferDeBusqueda2 = null;
                                String otroResultado2 = "Y";
                                while (otroResultado2.equals("Y")) {
                                    String chofer = Scanner.getString("Ingrese el nombre del chofer que busca: ");
                                    for (int i = 0; i < r.getChoferes().size(); i++) {
                                        if (r.getChoferes().get(i).getNombre().equals(chofer)) {
                                            choferDeBusqueda2 = r.getChoferes().get(i);
                                            choferDeBusqueda2.finalizarViaje(choferDeBusqueda2.getSolicitudActual());
                                            otroResultado2 = "N";
                                        }


                                    }
                                    if (choferDeBusqueda2 == null) {
                                        System.out.println("Chofer no encontrado, le gustaria buscar otro?");
                                        otroResultado2 = Scanner.getString("[Y/N]: ");
                                    } else {
                                        System.out.println("--------------------------------");
                                    }

                                }
                                break;

                            default:
                                comando = 0;

                        }
                    }
                    break;

                case 5:
                    System.out.println("----------------ESTADO DE LA AGENCIA----------------");
                    System.out.println(r.getStatus());
                    System.out.println("--------------------------------");
                    break;



                default:
                    command = 0;
            }

        }

    }


}
