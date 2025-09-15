package Main;

import Main.Java.Adapter.Impresora;
import Main.Java.Adapter.ImpresoraPDF;
import Main.Java.Adapter.ImpresoraTexto;
import Main.Java.Adapter.ImpresoraTextoAdapter;
import Main.Java.Adapter.ImpresoraPDFAdapter;
import Main.Java.Bridge.*;
import Main.Java.Decorator.*;

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


        // ==============================
        // EJERCICIO 3- Decorator
        // ==============================

        System.out.println("\n=== EJERCICIO 3: Decorator ===");


        //Plan 1: plan básico con HD y descargas
        Plan plan1 = new PlanBasico();
        System.out.println(plan1.descripcion() + " cuesta $" + plan1.costo());

        plan1 = new HD(plan1); //Plan básico + HD
        System.out.println(plan1.descripcion() + " cuesta $" + plan1.costo());

        plan1= new DescargasOffline(plan1); //Plan Básico + HD + DescargasOffline
        System.out.println(plan1.descripcion() + " cuesta $" + plan1.costo());

    //Plan 2: plan básico con UltraHD y descargas
        Plan plan2 = new PlanBasico();
        System.out.println(plan2.descripcion() + " cuesta $" + plan2.costo());

        plan2 = new UltraHD(plan2); //Plan básico + HD
        System.out.println(plan2.descripcion() + " cuesta $" + plan2.costo());

        plan2= new DescargasOffline(plan2); //Plan Básico + HD + DescargasOffline
        System.out.println(plan2.descripcion() + " cuesta $" + plan2.costo());
    }

}