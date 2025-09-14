package Main;

import Main.Java.Adapter.Impresora;
import Main.Java.Adapter.ImpresoraPDF;
import Main.Java.Adapter.ImpresoraTexto;
import Main.Java.Adapter.ImpresoraTextoAdapter;
import Main.Java.Adapter.ImpresoraPDFAdapter;

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
    }
}