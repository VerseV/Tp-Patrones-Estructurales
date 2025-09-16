package Main.Java.Facade;

public class Envio {
    public String coordinarEnvio(String direccion) {
        System.out.println("Coordinando envío a: " + direccion);
        return "TRACK-" + Math.abs(direccion.hashCode() % 100000);
    }
}
