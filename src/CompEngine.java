@SuppressWarnings("SuspiciousNameCombination")
public class CompEngine extends VarFunc {


    static void compZero() {
        compOne();
        compTwo();
    }

    static void compOne() {
        System.out.println();
        System.out.println("Top 3 Most Used Words");
        System.out.println("====================================");
        System.out.println("| YOU:        ||  " + author.toUpperCase() + ":");
        System.out.println("------------------------------------");
        for (int i = 0; i < 3; i++) {
            String key = keys.get(i);
            Double value = values.get(i);
            String akey = awords.get(i);
            double avalue = Double.parseDouble(astats.get(i));
            System.out.println("| " + key + " (" + value + ")" + " || " + akey + " (" + avalue + ")" + "     |");
        }
        System.out.println("====================================");
        System.out.println();
        System.out.println("| Top 3 Most Used Words Excluding Conjunctions");
        System.out.println("====================================");
        System.out.println("| YOU:        ||  " + author.toUpperCase() + ":");
        System.out.println("------------------------------------");
        for (int i = 0; i < 3; i++) {
            String key = ckeys.get(i);
            Double value = cvalues.get(i);
            String akey = acwords.get(i);
            double avalue = Double.parseDouble(acstats.get(i));
            System.out.println("| " + key + " (" + value + ")" + " || " + akey + " (" + avalue + ")" + "      |");
        }
        System.out.println("====================================");
    }


    static void compTwo() {
        String xx = "";
        String yy = "";
        String zz = "";
        String kk = "";

        mathEngine(l, auth.get("car"), xx);
        mathEngine(per100, auth.get("per100"), yy);
        mathEngine(w, auth.get("words"), zz);
        mathEngine(sper100, auth.get("sper100"), kk);

        String q = String.valueOf(auth.get("car"));
        String e = String.valueOf(auth.get("per100"));
        String r = String.valueOf(auth.get("words"));
        String t = String.valueOf(auth.get("sper100"));
        System.out.println();
        System.out.println("Sentence Content & Length Comparison");
        System.out.println("====================================================================================");
        System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + q + "  ||  " + xx + "        |");
        System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + e + "  ||  " + yy + "        |");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + r + "  ||  " + zz + "        |");
        System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + t + "  ||  " + kk + "        |");
        System.out.println("===================================================================================");
    }
}

