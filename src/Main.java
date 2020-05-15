import java.io.IOException;

public class Main extends Variables {

    public static void main(String[] args) throws IOException, InterruptedException {

        boolean devmode = false;

        //noinspection ConstantConditions
        if (!devmode) {

            while (finished) {
                if (restart) {
                    Messages.setAut(); //Set Author
                    Messages.setComp(); //Set Comparison Method
                    Messages.fixSet(); //Confirm Settings
                    TextParser.removeEnter();
                    switch (comp) {
                        case 1:
                            TextReader.wfw(); //Word for Word Comparison
                            TextReader.conjWfw(); //Word for Word Comparison excluding Conjunctions and Common Words
                            CompEngine.compOne(); //Compare vs Selected Author
                        case 2:
                            TextReader.sentcarLength(); //Calculate Sentence Stats w/Characters
                            TextReader.sentwordLength(); //Calculate Sentence Stats w/Words
                            CompEngine.compTwo(); //Compare vs Selected Author
                        case 3:
                            TextReader.wfw(); //Word for Word Comparison
                            TextReader.conjWfw(); //Word for Word Comparison excluding Conjunctions and Common Words
                            TextReader.sentcarLength(); //Calculate Sentence Stats w/Characters
                            TextReader.sentwordLength(); //Calculate Sentence Stats w/Words
                            CompEngine.compThree(); //Compare vs Selected Author
                    }
                    Messages.compAgain();
                } else {
                    System.exit(0);
                }
            }

            TextReader.getStat(); //Get all Author statistics
            TextReader.authorList(); //Parse list of authors
            Messages.beginPrompt(); //Introduction
            Messages.infoSpout(); //Basic System Run through
            Messages.setAut(); //Set Author
            Messages.setComp(); //Set Comparison Method
            Messages.fixSet(); //Confirm Settings
            TextParser.removeEnter();
            switch (comp) {
                case 1:
                    TextReader.wfw(); //Word for Word Comparison
                    TextReader.conjWfw(); //Word for Word Comparison excluding Conjunctions and Common Words
                    CompEngine.compOne(); //Compare vs Selected Author
                case 2:
                    TextReader.sentcarLength(); //Calculate Sentence Stats w/Characters
                    TextReader.sentwordLength(); //Calculate Sentence Stats w/Words
                    CompEngine.compTwo(); //Compare vs Selected Author
                case 3:
                    TextReader.wfw(); //Word for Word Comparison
                    TextReader.conjWfw(); //Word for Word Comparison excluding Conjunctions and Common Words
                    TextReader.sentcarLength(); //Calculate Sentence Stats w/Characters
                    TextReader.sentwordLength(); //Calculate Sentence Stats w/Words
                    CompEngine.compThree(); //Compare vs Selected Author
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
