package Main.Java.Facade;

public class Pago {
    public boolean procesar(double monto) {
        System.out.println("Procesando pago de $" + monto);
        return true;
    }
}
