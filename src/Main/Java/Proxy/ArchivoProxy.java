package Main.Java.Proxy;

import java.util.Arrays;
import java.util.List;

public class ArchivoProxy implements Archivo{
    private String nombreArchivo;
    private String usuario;
    private ArchivoReal archivoReal;

    // Lista de usuarios permitidos
    private static final List<String> USUARIOS_PERMITIDOS = Arrays.asList("admin", "soporte", "nombre");

    public ArchivoProxy(String nombreArchivo, String usuario) {
        this.nombreArchivo = nombreArchivo;
        this.usuario = usuario;
    }

    @Override
    public void abrir() {
        // Convertimos a minúsculas para evitar problemas de mayúsculas
        if (USUARIOS_PERMITIDOS.contains(usuario.toLowerCase())) {
            if (archivoReal == null) {
                archivoReal = new ArchivoReal(nombreArchivo);
            }
            archivoReal.abrir();
        } else {
            System.out.println("Acceso denegado para el usuario: " + usuario);
        }
    }
}

