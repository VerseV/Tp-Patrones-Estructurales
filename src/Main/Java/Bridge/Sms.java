package Main.Java.Bridge;

public class Sms implements CanalDeEnvio {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Tienes un mensaje por SMS: " + mensaje);

    }
}
