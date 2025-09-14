package Main.Java.Adapter;

public class ImpresoraTextoAdapter implements Impresora {
    private ImpresoraTexto impresoraTexto;

    public ImpresoraTextoAdapter(ImpresoraTexto impresoraTexto) {
        this.impresoraTexto = impresoraTexto;
    }
    @Override
    public void imprimir(String contenido) {
        // Aquí podrías convertir/transformar contenido si fuera necesario
        impresoraTexto.imprimirTextoPlano(contenido);
    }
}