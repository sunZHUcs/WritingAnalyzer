import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class VarFunc {

    public static Double roundDouble(Double x) {
        BigDecimal b1 = new BigDecimal(Double.toString(x));
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        x = b1.doubleValue();
        return x;
    }

    public static String appendMachine(String one, String two, String three, String separator, String end) {
        return one + separator + two + separator + three + end;
    }

    public static String constAppend(String x, int y) {
        StringBuilder s1 = new StringBuilder();
        s1.append(x);

        while (s1.length() < y) {
            s1.append(" ");
        }

        return String.valueOf(s1);
    }

    public static String mathEngine(Double x, Double y) {
        double z;
        z = x / y;
        z = z * 100;
        z = VarFunc.roundDouble(z);
        String k = String.valueOf(z);
        k = k + "%";
        return k;
    }

    public static void smallComp(ArrayList<String> k, ArrayList<String> aw, ArrayList<Double> v, ArrayList<String> av, String aut, String method) {
        String break1 = "============================================";
        String break2 = "--------------------------------------------";
        String separator = " || ";
        StringBuilder header = new StringBuilder("| YOU:            ||  " + aut.toUpperCase() + ":");
        while (header.length() < 43) {
            header.append(" ");
        }

        header.append("|");

        System.out.println();
        System.out.println(method);
        System.out.println(break1);
        System.out.println(header);
        System.out.println(break2);

        for (int i = 0; i < 3; i++) {
            String key = k.get(i);
            Double value = v.get(i);
            String akey = aw.get(i);
            double avalue = Double.parseDouble(av.get(i));

            String part1 = key + " (" + value + ")";
            String part2 = akey + " (" + avalue + ")";

            part1 = constAppend(part1, 15);
            part2 = constAppend(part2, 22);

            System.out.println("| " + part1 + separator + part2 + "|");
        }
        System.out.println(break1);
    }

}
