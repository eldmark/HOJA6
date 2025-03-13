
package pokemon;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class FactoryMapTest {
    @Test
    public void testCreateMapWithOption1() {
        Map<String, ArrayList<String>> map = FactoryMap.createMap(1);
        assertTrue(map instanceof HashMap);
    }

    @Test
    public void testCreateMapWithOption2() {
        Map<String, ArrayList<String>> map = FactoryMap.createMap(2);
        assertTrue(map instanceof TreeMap);
    }

    @Test
    public void testCreateMapWithOption3() {
        Map<String, ArrayList<String>> map = FactoryMap.createMap(3);
        assertTrue(map instanceof LinkedHashMap);
    }

    @Test
    public void testCreateMapWithInvalidOption() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactoryMap.createMap(4);
        });
        assertEquals("Opción inválida", exception.getMessage());
    }


}
