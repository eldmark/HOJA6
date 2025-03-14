package pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> pokemonCollection = new LinkedHashSet<>();
        CSVController csvController = new CSVController();
        Map<String,Pokemon> allPokemons = null;
        boolean exit = false;
        while (!exit) {
            System.out.print("Seleccione el método de creación del mapa (1: HashMap, 2: TreeMap, 3:LinkedHashMap): ");
            int mapOption = scanner.nextInt();
            scanner.nextLine();
            if (mapOption > 0 && mapOption < 4) {

                String filePath = "./collection/recursos/pokemon.csv";
                try {
                    allPokemons = csvController.loadPokemonData(filePath, mapOption);
                } catch (IOException e) {
                    System.err.println("Error loading Pokemon data: " + e.getMessage());
                }
                if (allPokemons != null) {
                    System.out.println("Mapa creado exitosamente.");
                } else {
                    System.out.println("Error al crear el mapa. Intente de nuevo.");
                    continue;
                }
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            final Map<String, Pokemon> currentAllPokemons = allPokemons;
            System.out.println("\nMenú de Pokémon:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar Pokémon ordenados por Tipo 1");
            System.out.println("4. Mostrar todos los Pokémon de allPokemons ordenados por Tipo 1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = scanner.nextLine();
                    for(String i:currentAllPokemons.keySet()){
                        System.out.println(i);
                    }

                    
                    if (!currentAllPokemons.containsKey(name)) {
                        System.out.println("Error: Pokémon no encontrado en allPokemons.");
                    } else if (!pokemonCollection.add(name)) {
                        System.out.println("El Pokémon ya está en la colección.");
                    } else {
                        System.out.println("Pokémon agregado exitosamente.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    name = scanner.nextLine();

                    if (!pokemonCollection.contains(name)) {
                        System.out.println("Error: Pokémon no encontrado en la colección.");
                    } else {
                        Pokemon data = currentAllPokemons.get(name);
                        System.out.println("Datos del Pokémon: " + data.getName());
                        System.out.println("Número en la Pokédex: " + data.getPokedexNumber());
                        switch (data.getAbility2()) {
                            case "":
                                System.out.println("Habilidad: " + data.getAbility1());
                                break;
                            default:
                                System.out.println("Habilidades: " + data.getAbility1() + ", " + data.getAbility2());
                        }
                        System.out.println("Tipo 1: " + data.getType1());
                        System.out.println("Tipo 2: " + data.getType2());
                        System.out.println("Altura: " + data.getHeight());
                        System.out.println("Peso: " + data.getWeight());
                        System.out.println("Generacion: " + data.getGeneration());
                        System.out.println("Legendaria: " + data.getLegendaryStatus());
                    }
                    break;

                case 3:
                    List<String> sortedList = new ArrayList<>(pokemonCollection);
                    sortedList.sort(Comparator.comparing(n -> currentAllPokemons.get(n).getType1()));

                    System.out.println("Pokémon ordenados por Tipo 1:");
                    for (String n : sortedList) {
                        System.out.println(n + " - Tipo 1: " + currentAllPokemons.get(n).getType1());
                    }
                    break;

                case 4:
                    List<Map.Entry<String, Pokemon>> entries = new ArrayList<>(currentAllPokemons.entrySet());
                    entries.sort(Comparator.comparing(entry -> ((Pokemon) entry.getValue()).getType1()));

                    System.out.println("Todos los Pokémon ordenados por Tipo 1:");
                    for (Map.Entry<String, Pokemon> entry : entries) {
                        System.out.println(entry.getKey() + " - Tipo 1: " + entry.getValue().getType1());
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la habilidad deseada: ");
                    String ability = scanner.nextLine();

                    System.out.println("Pokémon con la habilidad " + ability + ":");
                    for (Map.Entry<String, Pokemon> entry : currentAllPokemons.entrySet()) {
                        if (entry.getValue().getAbilities().contains(ability)) {
                            System.out.println(entry.getKey());
                        }
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
