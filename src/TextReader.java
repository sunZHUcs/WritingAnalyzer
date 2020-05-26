import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TextReader extends VarFunc {

    private static final InputStream list = TextReader.class.getClassLoader().getResourceAsStream("resources/authors.txt");
    private static final InputStream patin = TextReader.class.getClassLoader().getResourceAsStream("resources/pat.txt");
    private static final InputStream jkin = TextReader.class.getClassLoader().getResourceAsStream("resources/jk.txt");
    private static final InputStream rickin = TextReader.class.getClassLoader().getResourceAsStream("resources/rick.txt");
    private static List<String> sentences = new LinkedList<>(Arrays.asList(text.split("[!.?]")));
    private static double x;

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
        l = VarFunc.roundDouble(l);

        per100 = 100 / l;
        per100 = VarFunc.roundDouble(per100);

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
        w = VarFunc.roundDouble(w);

        sper100 = 100 / w;
        sper100 = VarFunc.roundDouble(sper100);

    }

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

        uni = Double.parseDouble(String.valueOf(repetitions.size()));

        Map<String, Integer> topThree =
                repetitions.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        String minKey = null;
        int minValue = Integer.MAX_VALUE;
        for (String key : repetitions.keySet()) {
            int value = repetitions.get(key);
            if (value < minValue) {
                minValue = value;
                minKey = key;
            }

        }

        keys = new ArrayList<>(topThree.keySet());
        prevalues = new ArrayList<>(topThree.values());
        values = new ArrayList<>(prevalues.size());

        for (Integer prevalue : prevalues) {

            x = prevalue;
            x = x / words.length;
            x = x * 1000;
            x = VarFunc.roundDouble(x);
            values.add(x);

        }
        keys.add(minKey);
        values.add((double) minValue);
    }

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

        for (Integer precvalue : precvalues) {

            x = precvalue;
            x = x / words.length;
            x = x * 1000;
            x = VarFunc.roundDouble(x);
            cvalues.add(x);

        }
    }

}
