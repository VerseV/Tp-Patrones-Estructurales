package Main.Java.Facade;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();
    public void agregarProducto(Producto p) { productos.add(p); }
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) total += p.getPrecio();
        return total;
    }
    public void vaciar() { productos.clear(); }
    public boolean estaVacio() { return productos.isEmpty(); }
}
