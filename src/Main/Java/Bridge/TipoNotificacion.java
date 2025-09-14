package Main.Java.Bridge;

public abstract class TipoNotificacion {
    protected CanalDeEnvio canalDeEnvio;

    //constructor de la clase abstracta
    public TipoNotificacion(CanalDeEnvio canalDeEnvio){
        this.canalDeEnvio = canalDeEnvio;
    }
    public abstract void enviar(String mensaje);
}
