import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

    public static void getStat() throws IOException {

        InputStream path = TextReader.class.getClassLoader().getResourceAsStream(tpath);

        assert path != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(":")) {
                String[] temp = line.split(":");
                awords.addAll(Arrays.asList(temp));
            } else if (line.contains("-")) {
                String[] temp = line.split("-");
                acwords.addAll(Arrays.asList(temp));
            } else if (line.contains("!")) {
                String[] temp = line.split("!");
                astats.addAll(Arrays.asList(temp));
            } else if (line.contains("?")) {
                String[] temp = line.split("[?]");
                acstats.addAll(Arrays.asList(temp));
            } else {
                String[] temp = line.split("=");
                auth.put(temp[0], Double.parseDouble(temp[1]));
            }
        }
    }
}
