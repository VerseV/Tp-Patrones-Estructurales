package Main.Java.Proxy;

public class ArchivoReal implements Archivo{
    private String nombreArchivo;

    public ArchivoReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void abrir() {
        System.out.println("Abriendo archivo: " + nombreArchivo);
    }
}

