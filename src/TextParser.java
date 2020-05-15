import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextParser extends Variables {


    /*
    Function:
    Removes all whitespace from input via text file scanning.
     */
    public static void removeEnter() throws IOException, InterruptedException {
        Scanner s1 = new Scanner(System.in);
        input = s1.nextLine();
        input = input.replaceAll("\"", "");

        File in = new File(input);
        boolean t = false;

        while (!t) {
            if (in.exists()) {
                t = true;
            } else if (input.equalsIgnoreCase("stop") && input.equalsIgnoreCase("quit")) {
                System.out.println();
                System.out.println("Program shutting down");
                Thread.sleep(3000);
                System.exit(0);
            } else {
                System.out.println("Invalid File Path!");
                input = s1.nextLine();
                input = input.replaceAll("\"", "");
                in = new File(input);
            }
        }

        text = Files.readString(Paths.get(String.valueOf(in)));
        text = text.replace("\n", "").replace("\r", "");

    }
}
