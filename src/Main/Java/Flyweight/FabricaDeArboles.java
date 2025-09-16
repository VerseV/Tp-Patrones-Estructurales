package Main.Java.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeArboles {
    private Map<String, TipoArbol> cache = new HashMap<>();

    public TipoArbol obtenerTipoArbol(String tipo, String textura, String color) {
        String clave = tipo + "-" + textura + "-" + color;
        if (!cache.containsKey(clave)) {
            cache.put(clave, new TipoArbolConcreto(tipo, textura, color));
        }
        return cache.get(clave);
    }

    public int tiposCreados() {
        return cache.size();
    }
}
