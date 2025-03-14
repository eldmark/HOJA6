package pokemon;
import java.util.*;

public class FactoryMap {
    public static Map<String, Pokemon> createMap(int option) {
        return switch (option) {
            case 1 -> new HashMap<>();
            case 2 -> new TreeMap<>();
            case 3 -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }
}
