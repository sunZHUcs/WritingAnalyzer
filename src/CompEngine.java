import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CompEngine extends VarFunc {

    private static final ArrayList<String> akeys = new ArrayList<>(); //Selected Author's top 3 words
    private static final ArrayList<String> avalues = new ArrayList<>(); //Selected Author's num of uses for "awords"
    private static final ArrayList<String> ackeys = new ArrayList<>(); //Selected Author's top 3 words excluding conjunctions
    private static final ArrayList<String> acvalues = new ArrayList<>(); //Selected Author's num of uses for "acwords"
    private static final Map<String, Double> auth = new LinkedHashMap<>(); //Selected Author's miscellaneous statistics\    public static ArrayList<String> keys; //Top 3 most used words
    private static String text = ""; //Input with no whitespace
    private static ArrayList<String> keys; //Top 3 most used words
    private static ArrayList<Double> values; //Numbers of uses for most used words
    private static ArrayList<String> ckeys; //Top 3 most used words excluding conjunctions and common words
    private static ArrayList<Double> cvalues; //Numbers of uses for most used words excluding conjunctions and common words
    private static double l; //Characters per sentence
    private static double per100; //sentences per 100 characters
    private static double w; //words per sentence
    private static double sper100; //sentences per 100 words
    private static Double uni = 0.0; //Number of unique words
    private static List<String> sentences = new LinkedList<>(Arrays.asList(text.split("[!.?]")));

    /*
    Remove all line breaks from input text file & store as String
     */
    public static void removeEnter() throws IOException, InterruptedException {
        Scanner s1 = new Scanner(System.in);
        String input = s1.nextLine();
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

    /*
    Add statistics to Author Arrays/Hashmap based upon settings.
     */
    public static void getStat() throws IOException {

        InputStream path = CompEngine.class.getClassLoader().getResourceAsStream(Main.tpath);

        assert path != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(":")) {
                String[] temp = line.split(":");
                akeys.addAll(Arrays.asList(temp));
            } else if (line.contains("-")) {
                String[] temp = line.split("-");
                ackeys.addAll(Arrays.asList(temp));
            } else if (line.contains("!")) {
                String[] temp = line.split("!");
                avalues.addAll(Arrays.asList(temp));
            } else if (line.contains("?")) {
                String[] temp = line.split("[?]");
                acvalues.addAll(Arrays.asList(temp));
            } else {
                String[] temp = line.split("=");
                auth.put(temp[0], Double.parseDouble(temp[1]));
            }
        }
    }

    /*
    Calculate Number of Characters per sentence and number of sentences per 100 characters.
     */
    public static void sentcarLength() {
        int i = 0;
        double car = 0;

        //Split input by sentence enders. After this, each array element is a sentence
        sentences = Arrays.asList(text.split("[!.?]"));
        for (String sentence : sentences) {

            //If Array Value is null, skip & count in int i.
            if (sentence.length() == 0) {
                i++;
            }

            /*Check if the first character in element is a space, if so - skip the
            character and only count the following characters
             */
            else {
                char x = sentence.charAt(0);
                String y = String.valueOf(x);

                if (y.equalsIgnoreCase(" ")) {
                    car = car + sentence.substring(1).length();
                } else {
                    car = car + sentence.length();
                }
            }
        }

        //Calculate Average characters and remove all null entries in array from math by subtracting i
        l = car / (sentences.size() - i);
        l = VarFunc.roundDouble(l);

        //Calculate Average sentences per 100 characters.
        per100 = 100 / l;
        per100 = VarFunc.roundDouble(per100);

    }

    /*
    Same as sentcarLenght but with words
     */
    public static void sentwordLength() {
        int i = 0;
        double words = 0;

        sentences = Arrays.asList(text.split("[!.?]"));

        for (String sentence : sentences) {

            if (sentence.length() == 0) {
                i++;
            } else {
                char x = sentence.charAt(0);
                String y = String.valueOf(x);

                /*
                Checking if first character is a space once again. This method works by
                counting the number of spaces in the sentence and adding one. In the case of
                the first character being a space, we just count the spaces. If not, we add 1 to spaces.
                 */
                if (y.equalsIgnoreCase(" ")) {
                    long spaces = sentence.chars().filter(c -> c == (int) ' ').count();
                    words = words + spaces;
                } else {
                    long spaces = sentence.chars().filter(c -> c == (int) ' ').count();
                    words = words + spaces + 1;
                }
            }
        }

        /*
        Exact Same math as sentcarLenght
         */
        w = words / (sentences.size() - i);
        w = VarFunc.roundDouble(w);

        sper100 = 100 / w;
        sper100 = VarFunc.roundDouble(sper100);

    }

    /*
    Finding the top 3 most used words and the number of times they're used.
     */
    public static void wfw() throws IOException {
        int z = 0;

        /*Removing all sentence enders from text and splitting spaces to fill an array words
        After this, each array element is a word.
         */
        text = text.replaceAll("[!.?]", "");
        String[] words = text.split("\\s+");

        //Converting every element to lower case. This just makes it look better during output
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }

        //Adding all conjunctions and characters in conjunctions.txt to arraylist conj
        ArrayList<String> conj = new ArrayList<>();
        InputStream one = CompEngine.class.getClassLoader().getResourceAsStream("resources/conjunctions.txt");

        if (!(one == null)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(one));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                conj.add(line);
            }
        } else {
            System.exit(2);
        }


        /*
        Adding each element to a hashmap repetitions and counting duplicate entries.
         */
        HashMap<String, Integer> repetitions = new HashMap<>();

        for (String word : words) {
            if (repetitions.containsKey(word) && !word.equalsIgnoreCase("")) {
                repetitions.put(word, repetitions.get(word) + 1);
            } else if (word.equalsIgnoreCase("")) {
                z++;
            } else
                repetitions.put(word, 1);
        }

        //Same as previous, but this time checking if conj contains the word and skipping if so.
        HashMap<String, Integer> conjrep = new HashMap<>();

        for (String word : words) {
            if (conjrep.containsKey(word) && !conj.contains(word) && !word.equalsIgnoreCase("")) {
                conjrep.put(word, conjrep.get(word) + 1);
            } else if (word.equalsIgnoreCase("")) {
                z++;
            } else
                conjrep.put(word, 1);
        }

        //Getting the number of unique words
        uni = Double.parseDouble(String.valueOf(repetitions.size()));
        uni = uni - z;

        //Putting the top 3 most used words and the number of uses into a new LinkedHashMap (Which keeps order).
        Map<String, Integer> topThree =
                repetitions.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //Same as above but with conjrep.
        Map<String, Integer> topThreeC =
                conjrep.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        /*
        Calculating the least used word by comparing each value to each other
         */
        String minKey = null;
        int minValue = Integer.MAX_VALUE;
        for (String key : repetitions.keySet()) {
            int value = repetitions.get(key);
            if (value < minValue) {
                minValue = value;
                minKey = key;
            }

        }

        //Adding all words into an array Keys and storing number of uses into an arraylist called Precvalues
        keys = new ArrayList<>(topThree.keySet());
        //Raw numbers of uses for most used words
        ArrayList<Integer> prevalues = new ArrayList<>(topThree.values());
        values = new ArrayList<>(prevalues.size());

        //Calculating number of uses for each word per 1000 words and saving that value in array values.
        double x;
        for (Integer prevalue : prevalues) {

            x = prevalue;
            x = x / words.length;
            x = x * 1000;
            x = VarFunc.roundDouble(x);
            values.add(x);

        }

        //Adding least used word & number of uses into arrays keys and values.
        keys.add(minKey);
        values.add((double) minValue);

        //Exact same as above but with different source
        ckeys = new ArrayList<>(topThreeC.keySet());
        ArrayList<Integer> precvalues = new ArrayList<>(topThreeC.values());
        cvalues = new ArrayList<>(prevalues.size());

        for (Integer precvalue : precvalues) {

            x = precvalue;
            x = x / words.length;
            x = x * 1000;
            x = VarFunc.roundDouble(x);
            cvalues.add(x);

        }
    }

    /*
    Compare all statistics
     */
    public static void outZero() {
        outOne();
        outTwo();
    }

    /*
    Output for word for word comparison.
     */
    public static void outOne() {
        //Feeding data to VarFunc class which does the output.
        String m = "Top 3 Most Used Words. [Word (Num of Uses/1000 Words)]";
        VarFunc.smallComp(keys, akeys, values, avalues, Main.author, m);

        //Same as above
        m = "Top 3 Most Used Words Excluding Conjunctions \nand Common Words. [Word (Num of Uses/1000 Words)]";
        VarFunc.smallComp(ckeys, ackeys, cvalues, acvalues, Main.author, m);


        /*These big tables are essentially the same as the function above with smallComp(). I just didn't create a new
        method because there is no performance advantages.

        Just a basic rundown:
        You have 3 columns. So you have 3 strings. The program checks the length of each string and adds spaces until it
        reaches the character limit provided. Then, we combine all 3 strings into one big one and output it.
         */

        String header1 = "|                     | YOU:";
        String header2 = Main.author.toUpperCase() + ":";
        String header3 = "% of Author";
        String separator = " || ";
        header1 = constAppend(header1, 45);
        header2 = constAppend(header2, 19);
        header3 = constAppend(header3, 11);
        String header4 = appendMachine(header1, header2, header3, separator, " |");


        String break1 = "=====================================================================================";
        String break2 = "-------------------------------------------------------------------------------------";
        System.out.println();
        System.out.println("Other Statistics. [Word (Num of Uses)]");
        System.out.println(break1);
        System.out.println(header4);
        System.out.println(break2);

        String key = keys.get(3);
        Double value = values.get(3);
        String akey = akeys.get(3);
        String avalue = avalues.get(3);

        String per = mathEngine(uni, auth.get("uni"));

        String one = "| Least Used Word     |  " + key + " (" + value + ")";
        String two = akey + " (" + avalue + ")";
        String three = "| # of Unique Words   |  " + uni;
        String NA = "N/A";
        String four = String.valueOf(auth.get("uni"));
        String five = per;

        one = constAppend(one, 45);
        two = constAppend(two, 19);
        three = constAppend(three, 45);
        four = constAppend(four, 19);
        five = constAppend(five, 11);
        NA = constAppend(NA, 11);

        one = appendMachine(one, two, NA, separator, " |");
        two = appendMachine(three, four, five, separator, " |");
        System.out.println(one);
        System.out.println(two);
        System.out.println(break1);
    }

    public static void outTwo() {
        String q = String.valueOf(auth.get("car"));
        String e = String.valueOf(auth.get("per100"));
        String r = String.valueOf(auth.get("words"));
        String t = String.valueOf(auth.get("sper100"));

        String x = mathEngine(l, auth.get("car"));
        String y = mathEngine(per100, auth.get("per100"));
        String z = mathEngine(w, auth.get("words"));
        String k = mathEngine(sper100, auth.get("sper100"));

        String break1 = "=====================================================================================";
        String separator = " || ";
        String break2 = "------------------------------------------------------------------------------------";

        String header1 = "|                                   | YOU:   ";
        String header2 = Main.author.toUpperCase() + ":";
        String header3 = "% of Author";
        String one = "| Avg. Characters Per Sentence      |  " + l;
        String two = q;
        String three = x;
        String four = "| Avg. Sentences Per 100 Characters |  " + per100;
        String five = e;
        String six = y;
        String seven = "| Avg. Words Per Sentence           |  " + w;
        String eight = r;
        String nine = z;
        String ten = "| Avg. Sentences Per 100 Words      |  " + sper100;
        String eleven = t;
        String twelve = k;

        header2 = constAppend(header2, 19);
        header3 = constAppend(header3, 10);
        one = constAppend(one, 45);
        two = constAppend(two, 19);
        three = constAppend(three, 11);
        four = constAppend(four, 45);
        five = constAppend(five, 19);
        six = constAppend(six, 11);
        seven = constAppend(seven, 45);
        eight = constAppend(eight, 19);
        nine = constAppend(nine, 11);
        ten = constAppend(ten, 45);
        eleven = constAppend(eleven, 19);
        twelve = constAppend(twelve, 11);

        String header = appendMachine(header1, header2, header3, separator, " |");
        String cps = appendMachine(one, two, three, separator, " |");
        String cps100 = appendMachine(four, five, six, separator, " |");
        String wps = appendMachine(seven, eight, nine, separator, " |");
        String wps100 = appendMachine(ten, eleven, twelve, separator, " |");


        System.out.println();
        System.out.println("Sentence Content & Length Comparison");
        System.out.println(break1);
        System.out.println(header);
        System.out.println(break2);
        System.out.println(cps);
        System.out.println(cps100);
        System.out.println(break2);
        System.out.println(wps);
        System.out.println(wps100);
        System.out.println(break1);
    }

}
