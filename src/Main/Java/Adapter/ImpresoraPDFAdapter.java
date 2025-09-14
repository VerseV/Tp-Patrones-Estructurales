package Main.Java.Adapter;

public class ImpresoraPDFAdapter implements Impresora {
    private ImpresoraPDF pdf;

    public ImpresoraPDFAdapter(ImpresoraPDF pdf) {
        this.pdf = pdf;
    }

    @Override
    public void imprimir(String contenido) {
        pdf.imprimirPDF(contenido);
    }
}
