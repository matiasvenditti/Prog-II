import org.junit.Test;

import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Matias on 14/10/2016.
 */
public class RubernTest {

    @Test
    public void calcularCantidadAutos(){
        Rubern uber = new Rubern(5);
        Auto auto = new Auto("Audi", "A3", "Azul", "ABC-123", 4);
        Interval intervalo = new Interval(new GregorianCalendar(2016,10,14,1,0),new GregorianCalendar(2016,10,12,1,30));
        TarjetaCredito tarjeta = new TarjetaCredito("123113",100);
        Chofer juan = new Chofer (auto,intervalo,"juan", "12345678", "asdasd", tarjeta);

        int cantidad = uber.calcularCantidadAutos(8,juan);
        assertEquals(cantidad,2,0);

    }
}
