package pokemon;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        CSVController csvController = new CSVController();
        System.out.println((csvController.createPokemonList("./collection/src/main/java/pokemon/resources/pokemon_data_pokeapi.csv", 1)).size());
    }
}
