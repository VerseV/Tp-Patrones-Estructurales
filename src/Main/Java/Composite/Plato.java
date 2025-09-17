package Main.Java.Composite;

public class Plato implements ElementoMenu {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "- Plato: " + nombre + " ($" + precio + ")");
    }
}

