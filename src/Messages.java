import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("BusyWait")
public class Messages extends VarFunc {

    private static final String compMethods = "[0] All Methods\n[1] Word for Word comparision\n[2] BETA: Sentence Structure\n------------------------------";
    private static final String shutdown = "Program shutting down";
    private static final String ver = "0.01";
    private static Boolean suc = false;

    //Introduce User and make sure they want to continue
    public static void beginPrompt() throws InterruptedException {
        System.out.println("Welcome to Version " + ver + " of the Basic Writing Analyzer.");
        System.out.println("This Writing Analyzer compares your writing to that of several notable authors including:");
        System.out.println("J.K. Rowling, Rick Riordan, and Pat Rothfuss.");
        System.out.println("Report all bugs to Sunboyz#4751 on Discord");
        System.out.println();
        System.out.println("Would you like to continue? (Hint: You can type \"Stop\" or \"Quit\" to end this program at any time)");

        Scanner s1 = new Scanner(System.in);
        input = s1.nextLine();

        while (!suc) {

            switch (input.toLowerCase()) {
                default -> {
                    System.out.println("Invalid Input!");
                    input = s1.nextLine();
                }
                case "yes" -> suc = true;
                case "no", "stop", "quit" -> {
                    System.out.println();
                    System.out.println(shutdown);
                    Thread.sleep(1500);
                    System.exit(0);
                }
            }
        }

        suc = false;
    }

    //Tell user the gist of the program and make sure they understand
    public static void infoSpout() throws InterruptedException {

        System.out.println();
        System.out.println("This Writing Analyzer is capable of comparing your writing in 3 different ways:");
        System.out.println(compMethods);
        System.out.println("To input your writing, make sure that it's in a readable Text (.txt) file and enter");
        System.out.println("the file path when prompted to.");
        System.out.println();
        System.out.println("Do you understand? Enter \"Yes\", \"Confirm\", or \"No\".");

        Scanner s2 = new Scanner(System.in);
        input = s2.nextLine();

        while (!suc) {

            switch (input.toLowerCase()) {
                default -> {
                    System.out.println("Invalid Input!");
                    input = s2.nextLine();
                }
                case "yes", "confirm" -> suc = true;
                case "no" -> {
                    System.out.println("The program will now reprint the information spout");
                    input = null;
                    suc = false;
                    infoSpout();
                }
                case "stop", "quit" -> {
                    System.out.println();
                    System.out.println(shutdown);
                    Thread.sleep(1500);
                    System.exit(0);
                }
            }
        }

        suc = false;
    }


    //Allow user to set Author
    public static void setAut() throws InterruptedException {
        System.out.println();
        System.out.println("Which author would you like to compare your work to? Choose from the following:");
        System.out.println(authors.toString());

        Scanner s3 = new Scanner(System.in);
        input = s3.nextLine();

        while (!suc) {

            switch (input.toLowerCase()) {
                default -> {
                    System.out.println("Invalid Input!");
                    input = s3.nextLine();
                }
                case "patrick rothfuss" -> {
                    aut = 1;
                    suc = true;
                }
                case "jk rowling" -> {
                    aut = 2;
                    suc = true;
                }
                case "rick riordan" -> {
                    aut = 3;
                    suc = true;
                }
                case "stop", "quit" -> {
                    System.out.println();
                    System.out.println(shutdown);
                    Thread.sleep(1500);
                    System.exit(0);
                }
            }
        }

        author = input;
        suc = false;
        System.out.println();
        System.out.println("You have selected: " + author.toUpperCase());
    }

    //Allow user to set Comparison Method(s)
    public static void setComp() throws InterruptedException {
        System.out.println("What comparisons would you like to calculate?");
        System.out.println(compMethods);

        Scanner s4 = new Scanner(System.in);
        input = s4.nextLine();

        while (!suc) {

            switch (input.toLowerCase()) {
                default -> {
                    System.out.println("Invalid Input!");
                    input = s4.nextLine();
                }
                case "0" -> {
                    comp = 0;
                    suc = true;
                }
                case "1" -> {
                    comp = 1;
                    suc = true;
                }
                case "2" -> {
                    comp = 2;
                    suc = true;
                }
                case "stop", "quit" -> {
                    System.out.println();
                    System.out.println(shutdown);
                    Thread.sleep(1500);
                    System.exit(0);
                }
            }
        }

        suc = false;
    }

    //Allow user to change final settings
    public static void fixSet() throws InterruptedException {
        System.out.println();
        System.out.println("You have selected the Author " + author.toUpperCase() + " and the comparison(s): ");

        switch (comp) {
            case 0 -> System.out.println("Word for Word Comparison and Sentence Structure Comparison");
            case 1 -> System.out.println("[1] Word for Word Comparision");
            case 2 -> System.out.println("[2] BETA: Sentence Structure Comparison");
        }

        System.out.println();
        System.out.println("To confirm these settings type \"Confirm\". To change the author type \"Author\". To change the comparison method(s) type \"Comparison\".");

        Scanner s5 = new Scanner(System.in);
        input = s5.nextLine();

        while (!suc) {

            switch (input.toLowerCase()) {
                default -> {
                    System.out.println("Invalid Input!");
                    input = s5.nextLine();
                }
                case "confirm" -> suc = true;
                case "author" -> {
                    setAut();
                    fixSet();
                }
                case "comparison" -> {
                    System.out.println();
                    setComp();
                    fixSet();
                }
                case "stop", "quit" -> {
                    System.out.println();
                    System.out.println(shutdown);
                    Thread.sleep(1500);
                    System.exit(0);
                }
            }
        }

        System.out.println();
        System.out.println("Settings confirmed. Enter the file path of your text file: ");
    }

    public static void compAgain() throws IOException, InterruptedException {
        boolean x = false;
        finished = true;

        System.out.println();
        System.out.println("Would you like to compare more text?");
        Scanner s1 = new Scanner(System.in);

        while (!x) {
            switch (s1.nextLine().toLowerCase()) {
                case "yes" -> {
                    restart = true;
                    Main.main(null);
                    x = true;
                }
                case "no", "stop", "quit" -> {
                    x = true;
                    System.out.println();
                    System.out.println(shutdown);
                    Thread.sleep(1500);
                    System.exit(0);
                }
                default -> System.out.println("Invalid Input!");
            }
        }
    }

}
