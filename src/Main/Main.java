package Main;

import Main.Java.Adapter.*;
import Main.Java.Bridge.*;
import Main.Java.Decorator.*;
import Main.Java.Facade.*;
import Main.Java.Flyweight.FabricaDeArboles;
import Main.Java.Flyweight.TipoArbol;
import Main.Java.Proxy.*;
import Main.Java.Composite.*;


public class Main {
    public static void main(String[] args) {
        // ==============================
        // EJERCICIO 1- Adapter
        // ==============================
        System.out.println("\n=== EJERCICIO 1: Adapter ===");

        // Usamos PDF directo
        ImpresoraPDF pdf = new ImpresoraPDF();
        pdf.imprimirPDF("Informe_final.pdf");

        // Usamos Texto con Adapter
        ImpresoraTextoAdapter impresoraTexto = new ImpresoraTextoAdapter(new ImpresoraTexto());
        impresoraTexto.imprimir("Informe_final.txt");

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

        // ==============================
        // EJERCICIO 6: Proxy
        // ==============================
        System.out.println("\n=== EJERCICIO 6: Proxy ===");

        // Usuario con permisos
        Archivo archivo1 = new ArchivoProxy("documento_confidencial.txt", "admin");
        archivo1.abrir();

        // Usuario sin permisos
        Archivo archivo2 = new ArchivoProxy("documento_confidencial.txt", "cliente");
        archivo2.abrir();

        // ==============================
        // EJERCICIO 7: Composite
        // ==============================
        System.out.println("\n=== EJERCICIO 7: Composite ===");

        // Creamos platos individuales
        Plato p1 = new Plato("Milanesa", 1200);
        Plato p2 = new Plato("Ensalada", 900);

        // Creamos un menú y agregamos platos
        Menu menuPrincipal = new Menu("Principal");
        menuPrincipal.agregar(p1);
        menuPrincipal.agregar(p2);

        // Mostramos el menú completo
        menuPrincipal.mostrar("");

    }

}




