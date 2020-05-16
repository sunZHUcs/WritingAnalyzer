import java.io.IOException;

public class Main extends VarFunc {

    public static void main(String[] args) throws IOException, InterruptedException {

        boolean devmode = false;

        //noinspection ConstantConditions
        if (!devmode) {

            while (finished) {
                if (restart) {
                    Messages.setAut();
                    Messages.setComp();
                    Messages.fixSet();
                    TextParser.removeEnter();
                    TextParser.parseAut();
                    switch (comp) {
                        case 0 -> {
                            TextReader.wfw();
                            TextReader.conjWfw();
                            TextReader.sentcarLength();
                            TextReader.sentwordLength();
                            CompEngine.compZero();
                        }
                        case 1 -> {
                            TextReader.sentcarLength();
                            TextReader.sentwordLength();
                            CompEngine.compTwo();
                        }
                        case 2 -> {
                            TextReader.wfw();
                            TextReader.conjWfw();
                            CompEngine.compOne();
                        }
                    }
                    Messages.compAgain();
                } else {
                    System.exit(0);
                }
            }

            TextReader.getStat();
            TextReader.authorList();
            Messages.beginPrompt();
            Messages.infoSpout();
            Messages.setAut();
            Messages.setComp();
            Messages.fixSet();
            TextParser.removeEnter();
            TextParser.parseAut();
            switch (comp) {
                case 0 -> {
                    TextReader.wfw();
                    TextReader.conjWfw();
                    TextReader.sentcarLength();
                    TextReader.sentwordLength();
                    CompEngine.compZero();
                }
                case 1 -> {
                    TextReader.sentcarLength();
                    TextReader.sentwordLength();
                    CompEngine.compTwo();
                }
                case 2 -> {
                    TextReader.wfw();
                    TextReader.conjWfw();
                    CompEngine.compOne();
                }
            }
            Messages.compAgain();

        } else {
            TextReader.getStat();
            Messages.setAut();
            TextParser.removeEnter();
            TextReader.sentcarLength();
            TextReader.sentwordLength();
            CompEngine.compTwo();
        }

        //TODO: MINIMIZE CODE
        //TODO: Recheck all Code
        //TODO: Do logic flow check
        //TODO: Code Cleanup (Always)

    }

}
