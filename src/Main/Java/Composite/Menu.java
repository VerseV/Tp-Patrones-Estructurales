package Main.Java.Composite;

import java.util.ArrayList;
import java.util.List;

public class Menu implements ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ElementoMenu e) { elementos.add(e); }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "+ Menú: " + nombre);
        for (ElementoMenu e : elementos) {
            e.mostrar(indent + "   ");
        }
    }
}

