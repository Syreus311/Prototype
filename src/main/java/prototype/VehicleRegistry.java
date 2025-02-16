package prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    // Este mapa actúa como un registro donde se guardan diferentes prototipos de vehículos
    private Map<String, VehiclePrototype> prototypes = new HashMap<>();

    // Método que permite agregar un prototipo de vehículo al registro
    public void addPrototype(String key, VehiclePrototype vehicle) {
        prototypes.put(key, vehicle);
    }

    // Método que permite obtener una copia clonada de un prototipo de vehículo a partir de su clave
    public VehiclePrototype getClone(String key) {
        return prototypes.get(key).clone();
    }
}
