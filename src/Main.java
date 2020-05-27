import java.io.IOException;

public class Main {

    public static int comp = 0; //Selected Comparison Method(s)
    public static String author = ""; //Selected Author
    public static String tpath = ""; //Path for selected Author
    public static boolean restart = false; //Condition to restart program
    public static boolean finished = false; //Has the program finished at least once

    public static void main(String[] args) throws IOException, InterruptedException {

        boolean devmode = false;

        //noinspection ConstantConditions
        if (!devmode) {

            while (finished) {
                if (restart) {
                    Messages.setAut();
                    Messages.setComp();
                    Messages.fixSet();
                    CompEngine.removeEnter();
                    CompEngine.getStat();
                    switch (comp) {
                        case 0 -> {
                            CompEngine.wfw();
                            CompEngine.sentcarLength();
                            CompEngine.sentwordLength();
                            CompEngine.outZero();
                        }
                        case 1 -> {
                            CompEngine.wfw();
                            CompEngine.outOne();
                        }
                        case 2 -> {
                            CompEngine.sentcarLength();
                            CompEngine.sentwordLength();
                            CompEngine.outTwo();
                        }
                    }
                    Messages.compAgain();
                } else {
                    System.exit(0);
                }
            }

            Messages.authorList();
            Messages.beginPrompt();
            Messages.infoSpout();
            Messages.setAut();
            Messages.setComp();
            Messages.fixSet();
            CompEngine.removeEnter();
            CompEngine.getStat();
            switch (comp) {
                case 0 -> {
                    CompEngine.wfw();
                    CompEngine.sentcarLength();
                    CompEngine.sentwordLength();
                    CompEngine.outZero();
                }
                case 1 -> {
                    CompEngine.wfw();
                    CompEngine.outOne();
                }
                case 2 -> {
                    CompEngine.sentcarLength();
                    CompEngine.sentwordLength();
                    CompEngine.outTwo();
                }
            }
            Messages.compAgain();

        } else {
            Messages.authorList();
            Messages.setAut();
            CompEngine.getStat();
            CompEngine.removeEnter();
            CompEngine.wfw();
            CompEngine.outOne();
        }

        //TODO: MINIMIZE CODE
        //TODO: Fix invalid words
        //TODO: Code Cleanup (Always)

    }

}
