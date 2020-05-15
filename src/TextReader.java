import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class TextReader extends Variables {

    private static final InputStream list = TextReader.class.getClassLoader().getResourceAsStream("resources/authors.txt");
    private static final InputStream patin = TextReader.class.getClassLoader().getResourceAsStream("resources/pat.txt"); //Patrick Rothfuss Statistic File Location
    private static final InputStream jkin = TextReader.class.getClassLoader().getResourceAsStream("resources/jk.txt"); //J.K. Rowling Statistic File Location
    private static final InputStream rickin = TextReader.class.getClassLoader().getResourceAsStream("resources/rick.txt"); //Rick Riordan Statistic File Location
    private static List<String> sentences = new LinkedList<>(Arrays.asList(text.split("[!.?]")));

    //Add all authors in text file to arraylist
    public static void authorList() throws IOException {

        if (!(list == null)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(list));
            String line;

            while ((line = reader.readLine()) != null) {
                authors.add(line);
            }
        } else {
            System.exit(2);
        }
    }


    /*
    Calculates:
    Average number of characters per sentence
    Average number of sentences per 100 characters
    Average number of words per sentence
    Average number of words per 100 characters
     */
    public static void sentcarLength() {
        int i = 0;
        double car = 0;

        sentences = Arrays.asList(text.split("[!.?]"));
        for (String sentence : sentences) {

            if (sentence.length() == 0) {
                i++;
            } else {
                char x = sentence.charAt(0);
                String y = String.valueOf(x);

                if (y.equalsIgnoreCase(" ")) {
                    car = car + sentence.substring(1).length();
                } else {
                    car = car + sentence.length();
                }
            }
        }

        l = car / (sentences.size() - i);
        BigDecimal b1 = new BigDecimal(Double.toString(l));
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        l = b1.doubleValue();

        per100 = 100 / l;
        b1 = new BigDecimal(Double.toString(per100));
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        per100 = b1.doubleValue();

        /*
        System.out.println(l);
        System.out.println(per100);

         */
    }

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

                if (y.equalsIgnoreCase(" ")) {
                    long spaces = sentence.chars().filter(c -> c == (int) ' ').count();
                    words = words + spaces;
                } else {
                    long spaces = sentence.chars().filter(c -> c == (int) ' ').count();
                    words = words + spaces + 1;
                }
            }
        }

        w = words / (sentences.size() - i);
        BigDecimal b1 = new BigDecimal(Double.toString(w));
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        w = b1.doubleValue();

        sper100 = 100 / w;
        b1 = new BigDecimal(Double.toString(sper100));
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        sper100 = b1.doubleValue();

        /*
        System.out.println(w);
        System.out.println(sper100);

         */
    }

    /*
    Calculates:
    Top three most used words
     */
    public static void wfw() {

        washedinput = text.replaceAll("[!.?]", "");
        String[] words = washedinput.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }

        HashMap<String, Integer> repetitions = new HashMap<>();

        for (String word : words) {
            if (repetitions.containsKey(word))
                repetitions.put(word, repetitions.get(word) + 1);
            else
                repetitions.put(word, 1);
        }

        Map<String, Integer> topThree =
                repetitions.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        keys = new ArrayList<>(topThree.keySet());
        prevalues = new ArrayList<>(topThree.values());
        values = new ArrayList<>(prevalues.size());

        for (double x : prevalues) {

            x = x / words.length;
            x = x * 1000;

            BigDecimal b1 = new BigDecimal(Double.toString(x));
            b1 = b1.setScale(2, RoundingMode.HALF_UP);
            x = b1.doubleValue();
            values.add(x);

        }

        /*
        System.out.println(keys);
        System.out.println(values);

         */
    }

    /*
    Calculates:
    Top three most used words excluding conjunctions and common words
     */
    public static void conjWfw() throws IOException {

        washedinput = text.replaceAll("[!.?]", "");
        String[] words = washedinput.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }

        ArrayList<String> conj = new ArrayList<>();
        InputStream one = TextReader.class.getClassLoader().getResourceAsStream("resources/conjunctions.txt");

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

        HashMap<String, Integer> repetitions = new HashMap<>();

        for (String word : words) {
            if (repetitions.containsKey(word) && !conj.contains(word))
                repetitions.put(word, repetitions.get(word) + 1);
            else
                repetitions.put(word, 1);
        }

        Map<String, Integer> topThree =
                repetitions.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        ckeys = new ArrayList<>(topThree.keySet());
        precvalues = new ArrayList<>(topThree.values());
        cvalues = new ArrayList<>(prevalues.size());

        for (double x : precvalues) {

            x = x / words.length;
            x = x * 1000;

            BigDecimal b1 = new BigDecimal(Double.toString(x));
            b1 = b1.setScale(2, RoundingMode.HALF_UP);
            x = b1.doubleValue();
            cvalues.add(x);

        }

        /*
        System.out.println(ckeys);
        System.out.println(cvalues);

         */
    }

    /*
    Retrieves:
    All Author Statistics and shuffles them into hashmaps
    */
    public static void getStat() throws IOException {

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                assert patin != null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(patin));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(":")) {
                        String[] temp = line.split(":");
                        pwords.add(temp[0]);
                        pwords.add(temp[1]);
                        pwords.add(temp[2]);
                    } else if (line.contains("-")) {
                        String[] temp = line.split("-");
                        pcwords.add(temp[0]);
                        pcwords.add(temp[1]);
                        pcwords.add(temp[2]);
                    } else if (line.contains("!")) {
                        String[] temp = line.split("!");
                        pstats.add(temp[0]);
                        pstats.add(temp[1]);
                        pstats.add(temp[2]);
                    } else if (line.contains("?")) {
                        String[] temp = line.split("[?]");
                        pcstats.add(temp[0]);
                        pcstats.add(temp[1]);
                        pcstats.add(temp[2]);
                    } else {
                        String[] temp = line.split("=");
                        pat.put(temp[0], Double.parseDouble(temp[1]));
                    }
                }
            } else if (i == 1) {
                assert jkin != null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(jkin));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(":")) {
                        String[] temp = line.split(":");
                        jwords.add(temp[0]);
                        jwords.add(temp[1]);
                        jwords.add(temp[2]);
                    } else if (line.contains("-")) {
                        String[] temp = line.split("-");
                        jcwords.add(temp[0]);
                        jcwords.add(temp[1]);
                        jcwords.add(temp[2]);
                    } else if (line.contains("!")) {
                        String[] temp = line.split("!");
                        jstats.add(temp[0]);
                        jstats.add(temp[1]);
                        jstats.add(temp[2]);
                    } else if (line.contains("?")) {
                        String[] temp = line.split("[?]");
                        jcstats.add(temp[0]);
                        jcstats.add(temp[1]);
                        jcstats.add(temp[2]);
                    } else {
                        String[] temp = line.split("=");
                        jk.put(temp[0], Double.parseDouble(temp[1]));
                    }
                }
            } else {
                assert rickin != null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(rickin));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(":")) {
                        String[] temp = line.split(":");
                        rwords.add(temp[0]);
                        rwords.add(temp[1]);
                        rwords.add(temp[2]);
                    } else if (line.contains("-")) {
                        String[] temp = line.split("-");
                        rcwords.add(temp[0]);
                        rcwords.add(temp[1]);
                        rcwords.add(temp[2]);
                    } else if (line.contains("!")) {
                        String[] temp = line.split("!");
                        rstats.add(temp[0]);
                        rstats.add(temp[1]);
                        rstats.add(temp[2]);
                    } else if (line.contains("?")) {
                        String[] temp = line.split("[?]");
                        rcstats.add(temp[0]);
                        rcstats.add(temp[1]);
                        rcstats.add(temp[2]);
                    } else {
                        String[] temp = line.split("=");
                        rick.put(temp[0], Double.parseDouble(temp[1]));
                    }
                }
            }
        }

    }
}
