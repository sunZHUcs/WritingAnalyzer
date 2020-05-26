import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextParser extends VarFunc {

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
                Thread.sleep(1500);
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

    public static void parseAut() {

        switch (aut) {
            case 1 -> {
                awords.addAll(pwords);
                astats.addAll(pstats);
                acwords.addAll(pcwords);
                acstats.addAll(pcstats);
                auth.putAll(pat);
            }
            case 2 -> {
                awords.addAll(jwords);
                astats.addAll(jstats);
                acwords.addAll(jcwords);
                acstats.addAll(jcstats);
                auth.putAll(jk);
            }
            case 3 -> {
                awords.addAll(rwords);
                astats.addAll(rstats);
                acwords.addAll(rcwords);
                acstats.addAll(rcstats);
                auth.putAll(rick);
            }
        }
    }
}
