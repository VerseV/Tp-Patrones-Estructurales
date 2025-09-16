package Main;

import Main.Java.Adapter.Impresora;
import Main.Java.Adapter.ImpresoraPDF;
import Main.Java.Adapter.ImpresoraTexto;
import Main.Java.Adapter.ImpresoraTextoAdapter;
import Main.Java.Adapter.ImpresoraPDFAdapter;
import Main.Java.Bridge.*;
import Main.Java.Decorator.*;
import Main.Java.Facade.Carrito;
import Main.Java.Facade.Envio;
import Main.Java.Facade.Pago;
import Main.Java.Facade.TiendaFacade;
import Main.Java.Flyweight.FabricaDeArboles;
import Main.Java.Flyweight.TipoArbol;

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

        // ==============================
        // EJERCICIO 4- Facade
        // ==============================
        System.out.println("\n=== EJERCICIO 4: Facade ===");
        Carrito carrito = new Carrito();
        Pago pago = new Pago();
        Envio envio = new Envio();
        TiendaFacade tienda = new TiendaFacade(carrito, pago, envio);
        tienda.comprar("Camisa blanca", 2500, "Avenida Siempreviva 742");
        // ==============================
        // EJERCICIO 5- Flyweight
        // ==============================
        System.out.println("\n=== EJERCICIO 5: Flyweight ===");

        FabricaDeArboles fabrica = new FabricaDeArboles();

        String[] tipos = {"Pino", "Roble", "Eucalipto"};
        String textura = "textura-hojas";
        String color = "VerdeOscuro";

        int totalArboles = 1_000_000;

        for (int i = 0; i < totalArboles; i++) {
            String tipo = tipos[i % tipos.length]; // Alternamos tipos
            TipoArbol arbol = fabrica.obtenerTipoArbol(tipo, textura, color);

            // Solo dibujamos los primeros 5 para mostrar que funciona
            if (i < 5) {
                arbol.dibujar(i * 10, i * 20);
            }
        }

        System.out.println("Árboles creados en memoria (tipos únicos): " + fabrica.tiposCreados());
        System.out.println("Árboles simulados en el mapa: " + totalArboles);

    }

}