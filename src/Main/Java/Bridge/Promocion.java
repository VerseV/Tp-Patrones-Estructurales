package Main.Java.Bridge;

public class Promocion extends TipoNotificacion{
    //constructor de una subclase, con super()
    public Promocion(CanalDeEnvio canalDeEnvio) {
        super(canalDeEnvio);
    }

    @Override
    public void enviar(String mensaje) {
        canalDeEnvio.enviar("PROMOCIÓN!" + " " + mensaje);

    }
}
