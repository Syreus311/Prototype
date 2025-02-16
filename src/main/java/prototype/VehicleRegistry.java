package prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private Map<String, VehiclePrototype> prototypes = new HashMap<>();

    public void addPrototype(String key, VehiclePrototype vehicle) {
        prototypes.put(key, vehicle);
    }

    public VehiclePrototype getClone(String key) {
        return prototypes.get(key).clone();
    }
}
