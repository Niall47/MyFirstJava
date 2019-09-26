import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class asciiIntro {
    public Scanner input;
    {
        try {
            input = new Scanner(new File("ascii.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }

}
