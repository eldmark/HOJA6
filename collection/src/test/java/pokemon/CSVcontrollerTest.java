package pokemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVcontrollerTest {

    @Test
    public void testCreatePokemonList() {
        CSVController controller = new CSVController();
        String filePath = "src/test/resources/pokemon_test.csv";
        int option = 1; // Assuming 1 is a valid option for FactoryMap.createMap

        Map<String, ArrayList<String>> expected = new HashMap<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Pikachu");
        list1.add("Charmander");
        expected.put("Electric", list1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Squirtle");
        list2.add("Bulbasaur");
        expected.put("Water", list2);

        Map<String, ArrayList<String>> result = controller.createPokemonList(filePath, option);

        assertEquals(expected, result);
    }

    @Test
    public void testCreatePokemonListEmptyFile() {
        CSVController controller = new CSVController();
        String filePath = "src/test/resources/empty_test.csv";
        int option = 1; // Assuming 1 is a valid option for FactoryMap.createMap

        Map<String, ArrayList<String>> result = controller.createPokemonList(filePath, option);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreatePokemonListInvalidFile() {
        CSVController controller = new CSVController();
        String filePath = "invalid_path.csv";
        int option = 1; // Assuming 1 is a valid option for FactoryMap.createMap

        Map<String, ArrayList<String>> result = controller.createPokemonList(filePath, option);

        assertTrue(result.isEmpty());
    }
}
