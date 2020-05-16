import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Variables {

    public static final String ver = "0.01"; //Universal Version Number
    public static final ArrayList<String> authors = new ArrayList<>(); //Used to automatically display list of Authors
    public static final ArrayList<String> pwords = new ArrayList<>();
    public static final ArrayList<String> jwords = new ArrayList<>();
    public static final ArrayList<String> rwords = new ArrayList<>();
    public static final ArrayList<String> pcwords = new ArrayList<>();
    public static final ArrayList<String> jcwords = new ArrayList<>();
    public static final ArrayList<String> rcwords = new ArrayList<>();
    public static final ArrayList<String> pstats = new ArrayList<>();
    public static final ArrayList<String> jstats = new ArrayList<>();
    public static final ArrayList<String> rstats = new ArrayList<>();
    public static final ArrayList<String> pcstats = new ArrayList<>();
    public static final ArrayList<String> jcstats = new ArrayList<>();
    public static final ArrayList<String> rcstats = new ArrayList<>();
    public static final Map<String, Double> pat = new LinkedHashMap<>(); //Statistics of Patrick Rothfuss
    public static final Map<String, Double> jk = new LinkedHashMap<>(); //Statistics of J.K. Rowling
    public static final Map<String, Double> rick = new LinkedHashMap<>(); //Statistics of Rick Riordan

    //ACTUALLY USED VARIABLES:

    public static final ArrayList<String> awords = new ArrayList<>();
    public static final ArrayList<String> astats = new ArrayList<>();
    public static final ArrayList<String> acwords = new ArrayList<>();
    public static final ArrayList<String> acstats = new ArrayList<>();
    public static final Map<String, Double> auth = new LinkedHashMap<>();
    public static ArrayList<String> keys; //Top 3 most used words
    public static ArrayList<Double> values; //Numbers of uses for most used words
    public static ArrayList<String> ckeys; //Top 3 most used words excluding conjunctions and common words
    public static ArrayList<Double> cvalues; //Numbers of uses for most used words eluding conjunctions and common words
    public static ArrayList<Integer> prevalues; //Raw numbers of uses for most used words
    public static ArrayList<Integer> precvalues; //Raw numbers of uses for most used words excluding conjunctions and common words
    public static int comp = 0; //Selected Comparison Method(s)
    public static int aut = 0; //Selected Author
    public static String input = ""; //Universal input variable
    public static String washedinput = ""; //Input with no .?!
    public static String text = ""; //Input with no whitespace
    public static String author = ""; //Selected Author
    public static double l; //Characters per sentence
    public static double per100; //sentences per 100 characters
    public static double w; //words per sentence
    public static double sper100; //sentences per 100 words
    public static boolean restart = false;
    public static boolean finished = false;


    @SuppressWarnings("UnusedAssignment")
    static void roundDouble(Double x) {
        BigDecimal b1 = new BigDecimal(Double.toString(x));
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        x = b1.doubleValue();
    }
}
