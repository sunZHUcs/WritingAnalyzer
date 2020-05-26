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
                    TextParser.getStat();
                    switch (comp) {
                        case 0 -> {
                            TextReader.wfw();
                            TextReader.conjWfw();
                            TextReader.sentcarLength();
                            TextReader.sentwordLength();
                            CompEngine.compZero();
                        }
                        case 1 -> {
                            TextReader.wfw();
                            TextReader.conjWfw();
                            CompEngine.compOne();
                        }
                        case 2 -> {
                            TextReader.sentcarLength();
                            TextReader.sentwordLength();
                            CompEngine.compTwo();
                        }
                    }
                    Messages.compAgain();
                } else {
                    System.exit(0);
                }
            }

            TextReader.authorList();
            Messages.beginPrompt();
            Messages.infoSpout();
            Messages.setAut();
            Messages.setComp();
            Messages.fixSet();
            TextParser.removeEnter();
            TextParser.getStat();
            switch (comp) {
                case 0 -> {
                    TextReader.wfw();
                    TextReader.conjWfw();
                    TextReader.sentcarLength();
                    TextReader.sentwordLength();
                    CompEngine.compZero();
                }
                case 1 -> {
                    TextReader.wfw();
                    TextReader.conjWfw();
                    CompEngine.compOne();
                }
                case 2 -> {
                    TextReader.sentcarLength();
                    TextReader.sentwordLength();
                    CompEngine.compTwo();
                }
            }
            Messages.compAgain();

        } else {
            TextReader.authorList();
            Messages.setAut();
            TextParser.getStat();
            TextParser.removeEnter();
            TextReader.wfw();
            TextReader.conjWfw();
            CompEngine.compOne();
        }

        //TODO: MINIMIZE CODE
        //TODO: Fix invalid words
        //TODO: Code Cleanup (Always)

    }

}
