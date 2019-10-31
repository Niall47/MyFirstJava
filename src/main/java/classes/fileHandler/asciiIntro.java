package classes.fileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class asciiIntro {
    private Scanner input;
    {
        try {
            input = new Scanner(new File("src/main/resources/ascii.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }

}
