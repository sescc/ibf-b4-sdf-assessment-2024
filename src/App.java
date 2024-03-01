
import java.io.Console;
import java.io.IOException;


public class App {

    public static void main(String[] args) throws Exception {

        // Run Your Code here
        // Menu block starts
        System.out.println("Welcome to Pokemon Gaole Legend 4 Rush 2");
        System.out.println();
        System.out.println("(1) View unique list of Pokemon in the selected stack");
        System.out.println("(2) Find next 5 stars Pokemon occurrence");
        System.out.println("(3) Create new Pokemon stack and save (append) to csv file");
        System.out.println("(4) Print distinct Pokemon and cards count");
        System.out.println("(q) to exit the program");
        
        Console cons = System.console();
        String input = cons.readLine("Enter your selection >");
        System.out.println();

        //TODO: option block



        //TODO:toremove - main options end
        System.out.println("Thank you for using the program...");
        System.out.println("Hope to see you soon...");
        // Menu block ends
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
