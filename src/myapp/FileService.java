package myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {
    public List<String> ReadCSV(String fullPathFilename) {
        // Task 1 - your code here
        List<String> pokemonList = new ArrayList<>();
        File file = Paths.get(fullPathFilename).toFile();

        if (!file.exists()) {
            System.err.println("The file does not exist.");
            //TODO - behaviour when file not found
        } else if (file.isDirectory()) {
            System.err.println("This is not a file.");
            //TODO - behaviour when file not found
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(fullPathFilename))) {
                
                String line = br.readLine(); // reading 1st row
                //globalPokemonMap.put(1, line);

                while (line != null) {
                    //pokemonList.add(line);

                    //*TODO: put in writingCSV method
                    String[] pokemon = line.split(",");
                    pokemonList = new ArrayList<>(Arrays.asList(pokemon));

                    for (String str : pokemonList) {
                        App.globalPokemonMap.put(App.globalPokemonMap.size(), pokemonList);
                    }

                    // for (int i = 0; i < pokemon.length; i++) {
                    //     pokemonList.add(pokemon[i]);
                    // }
                    //*/

                    line = br.readLine();
                    //TODO: removetest
                    System.out.println(pokemonList.size());
                }

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pokemonList;
    }

    public void writeAsCSV(String pokemons, String fullPathFilename) {
        // Task 1 - your code here
        //File file = Paths.get(fullPathFilename).toFile();
        File file = new File(fullPathFilename);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullPathFilename, true))) {
            if (!file.isDirectory()) {
                if (!file.exists()) {
                    // TODO: check if directory exists
                    file.createNewFile();
                    System.out.printf("File %s created.\n", fullPathFilename);
                }
                bw.write(pokemons);
                bw.newLine();
                System.out.println("New Pokemon stack added.");
            }
                    
                    //String line = br.readLine(); // reading 1st row
                    //line = br.readLine(); // read data from first row onwards

                    //while (line != null) {
        /*TODO: put in writingCSV method
        String[] pokemon = line.split(",");

        for (int i = 0; i < pokemon.length; i++) {
            pokemonList.add(pokemon[i]);
        }
        */
                //     pokemonList.add(line);
                //     line = br.readLine();
                // }

                // br.close();
                // } catch (IOException e) {
                //     e.printStackTrace();
                // }
                //}
            else {
                System.err.println("Please enter a valid filename. No action taken.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Please enter a valid filename. No action taken.");
        }
    }
}
