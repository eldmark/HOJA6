package pokemon;

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
        Map<String, ArrayList<String>> allPokemons = null;

        boolean exit = false;
        while (!exit) {
            System.out.print("Seleccione el método de creación del mapa (1: HashMap, 2: TreeMap, 3:LinkedHashMap): ");
            int mapOption = scanner.nextInt();
            scanner.nextLine();
            if (mapOption > 0 && mapOption < 4) {

                String filePath = "./recursos/pokemon.csv";
                allPokemons = csvController.createPokemonList(filePath, mapOption);
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

            // Create a final reference to use within this iteration
            final Map<String, ArrayList<String>> currentAllPokemons = allPokemons;
            System.out.println("allPokemons: " + currentAllPokemons);
            System.out.println("\nMenú de Pokémon:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar Pokémon ordenados por Tipo 1");
            System.out.println("4. Mostrar todos los Pokémon de allPokemons ordenados por Tipo 1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
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
                        ArrayList<String> data = currentAllPokemons.get(name);
                        System.out.println("Datos del Pokémon: " + data);
                    }
                    break;

                case 3:
                    List<String> sortedList = new ArrayList<>(pokemonCollection);
                    sortedList.sort(Comparator.comparing(n -> currentAllPokemons.get(n).get(3)));

                    System.out.println("Pokémon ordenados por Tipo 1:");
                    for (String n : sortedList) {
                        System.out.println(n + " - Tipo 1: " + currentAllPokemons.get(n).get(3));
                    }
                    break;

                case 4:
                    List<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>(currentAllPokemons.entrySet());
                    entries.sort(Comparator.comparing(entry -> entry.getValue().get(3)));

                    System.out.println("Todos los Pokémon ordenados por Tipo 1:");
                    for (Map.Entry<String, ArrayList<String>> entry : entries) {
                        System.out.println(entry.getKey() + " - Tipo 1: " + entry.getValue().get(3));
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la habilidad deseada: ");
                    String ability = scanner.nextLine();

                    System.out.println("Pokémon con la habilidad " + ability + ":");
                    for (Map.Entry<String, ArrayList<String>> entry : currentAllPokemons.entrySet()) {
                        if (entry.getValue().contains(ability)) {
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
