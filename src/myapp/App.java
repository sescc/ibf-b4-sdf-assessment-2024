package myapp;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    /*
     * TODO-refactor
     * public static final char QUIT = 'q';
     * public static final int ONE = 1;
     * public static final int TWO = 2;
     * public static final int THREE = 3;
     * public static final int FOUR = 4;
     */
    public static List<String> globalPokemonList = new ArrayList<>();
    public static Map<Integer, List<String>> globalPokemonMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "";
        FileService fs = new FileService();

        // Run Your Code here
        if (args.length < 1) {
            System.err.println("Please enter the CSV filename as an argument when launching the program.");
            System.exit(-1);
        } else {
            fileName = args[0];
            globalPokemonList = fs.ReadCSV(fileName);                           // read into global String List array
            System.out.println("Map size debugging: " + globalPokemonMap.size());
            //globalPokemonMap.put(globalPokemonMap.size(), globalPokemonList);
        }

    // for (String str : globalPokemonList) {
    //     globalPokemonMap.put(globalPokemonMap.size(), str);
    // }
            //globalPokemonMap.put(globalPokemonMap.size(), globalPokemonList);   // add list as a new global map value
            //System.out.println(globalPokemonMap);
            
            //List<String> pokemonList = globalPokemonMap.get(stack);
            // String[] tempArr = globalPokemonList.toArray(new String[globalPokemonList.size()]);
            // //String[] pokemonLine = tempArr[0].split(",");
    
            // for (int i = 0; i < tempArr.length; i++) {
            //     globalPokemonMap.put(i, tempArr[i]);
            //     System.out.printf("%i ==> %s\n", i, pokemonLine[i]);
            // }
        //}

        // Start of Menu block
        printHeader();

        
        printExitMessage();
        // End of Menu block

        
    }

    public static void clearConsole() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Task 1
    public static void pressAnyKeyToContinue() {
        // your code here
        Console cons = System.console();
        String input = cons.readLine("Press any key to continue...");
    }

    // Task 1
    public static void printHeader() {

        // Task 1 - your code here
        System.out.println("Welcome to Pokemon Gaole Legend 4 Rush 2");
        System.out.println();
        System.out.println("(1) View the list of Pokemon in the selected stack");
        System.out.println("(2) View unique list of Pokemon in the selected stack");
        System.out.println("(3) Find next 5 stars Pokemon occurrence");
        System.out.println("(4) Create new Pokemon stack and save (append) to csv file");
        System.out.println("(q) to exit the program");

// // TODO: removetest
System.out.println("----------- section List -----------");
// System.out.println(globalPokemonList.toString());
System.out.println(globalPokemonList.size());
System.out.println("----------- section Map -----------");
System.out.println(globalPokemonMap.toString());
System.out.println(globalPokemonMap.size());

        Console cons = System.console();
        String input = cons.readLine("Enter your selection >");

        // TODO: option block
        input = input.trim().toLowerCase();
        while (!"q".equals(input)) {

            switch (input) {
                // case "q":
                // break;
                case "1":
                    Integer stackNum = Integer.parseInt(cons.readLine("View the list of Pokemon in the selected stack (1 - 8) >\n"));
                    printUniquePokemonStack(stackNum);
                    break;

                case "2":
                    printPokemonCardCount();
                    break;

                case "3":
                    // TODO
                    String enteredPokemon = cons.readLine("Search for the next occurence of 5 stars Pokemon in all stacks based on entered Pokemon >\n");
                    printNext5StarsPokemon(enteredPokemon);
                    break;

                case "4":
                    String pokemons = cons.readLine("Create a new Pokemon stack and save to a new file >\n");
                    String readPathFilename = cons.readLine("Enter filename to save (e.g. path/filename.csv) >\n");
                    
                    savePokemonStack(pokemons, readPathFilename);
                    break;

                default:
                    System.err.println("Invalid option. Please try again.");
                    break;

            }
            input = cons.readLine("Enter your selection >").trim().toLowerCase();;

        }
    }

    // Task 1
    public static void printExitMessage() {

        // Task 1 - your code here
        System.out.println();
        System.out.println("Thank you for using the program...");
        System.out.println("Hope to see you soon...");
    }

    // Task 1
    public static void savePokemonStack(String pokemonStack, String filename) {

        // Task 1 - your code here
        //globalPokemonMap.put(globalPokemonMap.size(), globalPokemonList);
        FileService fs = new FileService();
        fs.writeAsCSV(pokemonStack, filename);
        }
    

    // Task 2
    public static void printUniquePokemonStack(Integer stack) {
        // Task 2 - your code here
        try {
            if (stack < 1 || stack > 8) {
            System.err.println("Invalid stack number. Please try again.");
            pressAnyKeyToContinue();
            printHeader();
            }

            int actualStackIndex = stack - 1;

            List<String> pokemonList = globalPokemonMap.get(actualStackIndex);
            for (int i = 0; i < pokemonList.size(); i++) {
                System.out.println((i+1) + " ==> " + pokemonList.get(i));
            }


            // String[] pokemonArr = pokemonList.toArray(new String[pokemonList.size()]);
            // String[] pokemonLine = pokemonArr[0].split(",");

            // for (int i = 0; i < pokemonLine.length; i++) {
            // // System.out.printf("%i ==> %s\n", i, pokemonLine[i]);
            // System.out.println((i+1) + " ==> " + pokemonLine[i]);
            // }
        } catch (NullPointerException e) {
            System.err.println("This stack does not exist. Please try again.");
        }

    }

    // Task 2
    public static void printNext5StarsPokemon(String enteredPokemon) {
        // Task 2 - your code here
        for (int i = 0; i < globalPokemonMap.size(); i++) {
            List<String> currentStack = globalPokemonMap.get(i);

            boolean pokemonNameFound = false;
            boolean pokemonFiveStarFound = false;
            int indexOfFiveStars = 0;
            int indexOfFound = 0;
            String[] enteredPokemonArr = enteredPokemon.split(" ");

            //TODO: removetest
            //System.out.println("Stacksize: " +currentStack.size());
            //for (String pokemon : currentStack) {
            for (int j = 0; j < currentStack.size(); j++) {
                String pokemonArr[] = currentStack.get(j).split(" ");
                // System.out.println(i+" "+j +pokemonArr[0]);
                // System.out.println(i+" "+j +pokemonArr.length);
                // System.out.println(i+" "+j +enteredPokemonArr[1]);
                // System.out.println(pokemonNameFound);
                //indexOfFound = currentStack.indexOf(enteredPokemonArr[1]);
                if (pokemonNameFound) {         // skip if entered pokemon is 5*
                    if (enteredPokemonArr[0].equals("5*")) {
                        pokemonFiveStarFound = true;
                        indexOfFiveStars = j;
                    }
                }
                if (!enteredPokemonArr.equals(pokemonArr) && enteredPokemonArr[1].equals(pokemonArr[1])) {
                    pokemonNameFound = true;
                    indexOfFound = j;
                    System.out.println("5* " + enteredPokemonArr[1] + ">>>" + (indexOfFiveStars - indexOfFound) + " cards to go.");
                    
                }

            }
            System.out.println("Set " + (i+1));
            if (!pokemonNameFound) {
                System.out.println(enteredPokemonArr[1] + " not found in the set.");
            }
            if (pokemonNameFound) {
                if (!pokemonFiveStarFound) {
                    System.out.println("No 5 stars Pokemon found subsequently in the stack.");
                }
                if (pokemonFiveStarFound) {
                    //System.out.println("5* " + enteredPokemonArr[1] + ">>>" + (indexOfFiveStars - indexOfFound) + " cards to go.");
                }

            }

        }

    }

    // Task 2
    public static void printPokemonCardCount() {
        // Task 2 - your code here
        List<String> uniquePokemons = globalPokemonList.stream()
                .distinct()
                .collect(Collectors.toList());

    //Map<Integer, String> totalCount = new Map<Integer,String>();
    int totalCount = 0;
    for (int i = 0; i < uniquePokemons.size(); i++) {
            System.out.printf("Pokemon %i : %s, Cards Count: %i",i, uniquePokemons.get(i), totalCount);
    }
    }

}
