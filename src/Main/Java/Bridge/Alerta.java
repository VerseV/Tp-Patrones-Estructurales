package Main.Java.Bridge;

public class Alerta extends TipoNotificacion{
    //constructor de una subclase, con super()
    public Alerta(CanalDeEnvio canalDeEnvio) {
        super(canalDeEnvio);
    }

    @Override
    public void enviar(String mensaje) {
        canalDeEnvio.enviar("ALERTA!" +" "+ mensaje);

    }
}
