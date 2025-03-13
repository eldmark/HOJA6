package pokemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Map;

public class CSVcontrollerTest {
    @Test
    public void testCreatePokemonListEmptyFile() {
        CSVController controller = new CSVController();
        String filePath = "src/test/resources/empty_test.csv";
        int option = 1; 

        Map<String, ArrayList<String>> result = controller.createPokemonList(filePath, option);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreatePokemonListInvalidFile() {
        CSVController controller = new CSVController();
        String filePath = "invalid_path.csv";
        int option = 1;

        Map<String, ArrayList<String>> result = controller.createPokemonList(filePath, option);

        assertTrue(result.isEmpty());
    }
}
