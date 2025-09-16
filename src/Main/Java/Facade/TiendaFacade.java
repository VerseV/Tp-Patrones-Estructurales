package Main.Java.Facade;

public class TiendaFacade {
    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade(Carrito carrito, Pago pago, Envio envio) {
        this.carrito = carrito;
        this.pago = pago;
        this.envio = envio;
    }

    public void comprar(String nombreProducto, double precio, String direccion) {
        Producto p = new Producto(nombreProducto, precio);
        carrito.agregarProducto(p);

        double total = carrito.calcularTotal();
        System.out.println("Total a pagar: $" + total);

        if (!pago.procesar(total)) {
            System.out.println("Error en el pago. Compra cancelada.");
            return;
        }

        String tracking = envio.coordinarEnvio(direccion);
        System.out.println("Compra realizada con éxito. Tracking: " + tracking);

        carrito.vaciar();
    }
}
