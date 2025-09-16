package Main.Java.Flyweight;

public class TipoArbolConcreto implements TipoArbol {
    private final String tipo;
    private final String textura;
    private final String color;

    public TipoArbolConcreto(String tipo, String textura, String color) {
        this.tipo = tipo;
        this.textura = textura;
        this.color = color;
        System.out.println("Creando tipo de árbol: " + tipo);
    }

    @Override
    public void dibujar(int x, int y) {
    }
}

