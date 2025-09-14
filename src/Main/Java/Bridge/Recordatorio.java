package Main.Java.Bridge;

public class Recordatorio extends TipoNotificacion{
    //constructor de una subclase, con super()

    public Recordatorio(CanalDeEnvio canalDeEnvio) {
        super(canalDeEnvio);
    }

    @Override
    public void enviar(String mensaje) {
        canalDeEnvio.enviar("RECORDATORIO!" +" "+ mensaje);

    }
}
