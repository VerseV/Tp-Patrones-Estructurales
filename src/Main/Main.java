package Main;

import Main.Java.Adapter.Impresora;
import Main.Java.Adapter.ImpresoraPDF;
import Main.Java.Adapter.ImpresoraTexto;
import Main.Java.Adapter.ImpresoraTextoAdapter;
import Main.Java.Adapter.ImpresoraPDFAdapter;
import Main.Java.Bridge.*;

public class Main {
    public static void main(String[] args) {
        // ==============================
        // EJERCICIO 1- Adapter
        // ==============================
        System.out.println("\n=== EJERCICIO 1: Adapter ===");

        // Texto
        ImpresoraTexto impTexto = new ImpresoraTexto();
        Impresora impresoraTextoAdapter = new ImpresoraTextoAdapter(impTexto);

        // PDF
        ImpresoraPDF impPdf = new ImpresoraPDF();
        Impresora impresoraPdf = new ImpresoraPDFAdapter(impPdf);

        // Uso
        impresoraPdf.imprimir("Informe_final.pdf (contenido simulado)");
        impresoraTextoAdapter.imprimir("Informe_final.txt (contenido simulado)");

        // ==============================
        // EJERCICIO 2- Bridge
        // ==============================
        System.out.println("\n=== EJERCICIO 2: Bridge ===");

        //Creo canal de envio de tipo Email
        CanalDeEnvio email = new Email();

        //Creo canal de envio de tipo SMS
        CanalDeEnvio sms = new Sms();

        //Creo notificación de tipo Alerta ya sea para email o sms
        TipoNotificacion alertaEmail = new Alerta(email);
        TipoNotificacion alertaSMS = new Alerta(sms);

        //Creo notificación de tipo Promocion ya sea para email o sms
        TipoNotificacion promoEmail = new Promocion(email);
        TipoNotificacion promoSMS = new Promocion(sms);

        //Creo notificación de tipo Recordatorio ya sea para email o sms
        TipoNotificacion recEmail = new Recordatorio(email);
        TipoNotificacion recSMS = new Recordatorio(sms);

        //Enviar mensaje
        alertaEmail.enviar("Nuevo acceso en el dispositivo");
        alertaSMS.enviar("Sismo cercano, se espera un ligero temblor");
        promoEmail.enviar("Cyberweek, descuentos del 15%, 30% y más...");
        promoSMS.enviar("Cupon para que vuelvas a pedir en Mercados");
        recEmail.enviar("Todavia no recibimos el pago de tu suscripción ");
        recSMS.enviar("Tu turno médico es en una semana");

    }

}