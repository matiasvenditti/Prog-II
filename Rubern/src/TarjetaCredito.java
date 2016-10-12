/**
 * Created by Matias on 12/10/2016.
 */
public class TarjetaCredito {

    private String numero;
    private double saldo;

    public TarjetaCredito(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public double getSaldo(){
        return saldo;
    }

    public void disminuir(double cantidad){
        if (cantidad < 0 || cantidad> saldo){
            throw new IllegalArgumentException("No se puede disminuir esta cantidad.");
        }
        else{
            saldo -= cantidad;
        }
    }

    public void cargarSaldo(double cantidad){
        if (cantidad >= 0) {
            saldo += cantidad;
        }
        else{
            throw new IllegalArgumentException("Se debe cargar una cantidad positiva de dinero.");
        }
    }
}
