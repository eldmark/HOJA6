package pokemon;

import java.io.*;
import java.util.*;

public class CSVController {
    public Map<String, Pokemon> loadPokemonData(String filePath, int mapType) throws IOException {
        Map<String, Pokemon> pokemonMap = FactoryMap.createMap(mapType);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Pokemon pokemon = new Pokemon(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]);
                pokemonMap.put(data[0], pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            throw e;
        }
        return pokemonMap;
    }
}
