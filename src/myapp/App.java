package myapp;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    /*
     * TODO-refactor
     * public static final char QUIT = 'q';
     * public static final int ONE = 1;
     * public static final int TWO = 2;
     * public static final int THREE = 3;
     * public static final int FOUR = 4;
     */
    public static List<String> globalPokemonList = new ArrayList<>();       // global class-level String List array
    public static Map<Integer, List<String>> globalPokemonMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "";

        // Run Your Code here
        if (args.length < 1) {
            System.err.println("Please enter the CSV filename as an argument when launching the program.");
            System.exit(-1);
        } else {
            fileName = args[0];
            FileService fs = new FileService();
            globalPokemonList = fs.ReadCSV(fileName);
        }

        // Start of Menu block
        System.out.println("Welcome to Pokemon Gaole Legend 4 Rush 2");
        System.out.println();
        System.out.println("(1) View the list of Pokemon in the selected stack");
        System.out.println("(2) View unique list of Pokemon in the selected stack");
        System.out.println("(3) Find next 5 stars Pokemon occurrence");
        //System.out.println("(4) Print distinct Pokemon and cards count");
        System.out.println("(4) Create new Pokemon stack and save (append) to csv file");
        System.out.println("(q) to exit the program");

        Console cons = System.console();
        String input = cons.readLine("Enter your selection >");

        // TODO: option block
        input = input.trim().toLowerCase();
        while (!"q".equals(input)) {

            switch (input) {
                // case "q":
                // break;
                case "1":
                    // TODO
                    System.out.println("Option 1");
                    break;

                case "2":
                    // TODO
                    System.out.println("Option 2");
                    break;

                case "3":
                    // TODO
                    System.out.println("Option 3");
                    break;

                case "4":
                    // TODO
                    System.out.println("Option 4");
                    break;

                default:
                    System.err.println("Invalid option. Please try again.");
                    break;

            }
            input = cons.readLine("Enter your selection >").trim().toLowerCase();;

        }

        System.out.println();
        System.out.println("Thank you for using the program...");
        System.out.println("Hope to see you soon...");
        // End of Menu block

        
    }

    public static void clearConsole() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Task 1
    public static void pressAnyKeyToContinue() {
        // your code here
    }

    // Task 1
    public static void printHeader() {

        // Task 1 - your code here
    }

    // Task 1
    public static void printExitMessage() {

        // Task 1 - your code here
    }

    // Task 1
    public static void savePokemonStack(String pokemonStack, String filename) {

        // Task 1 - your code here
    }

    // Task 2
    public static void printUniquePokemonStack(Integer stack) {
        // Task 2 - your code here
    }

    // Task 2
    public static void printNext5StarsPokemon(String enteredPokemon) {
        // Task 2 - your code here

    }

    // Task 2
    public static void printPokemonCardCount() {
        // Task 2 - your code here
    }

}
