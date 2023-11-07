import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//A class used to read data from a specific file line by line
public class Reader {
    ArrayList<String> wordsList = new ArrayList<String>();
    public Reader(String file_name) {
        Scanner scanner = null;
        String line = null;
        try {
            scanner = new Scanner(new File("C:\\Users\\dawid\\IdeaProjects\\Wisielec\\src\\" + file_name));
            while(scanner.hasNext()){
                line = scanner.nextLine();
                wordsList.add(line);
                //System.out.println("Loaded: " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("You can't open file: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
