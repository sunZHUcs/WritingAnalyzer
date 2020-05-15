import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompEngine extends Variables {

    static void compOne() {
        switch (aut) {
            case 1 -> {
                System.out.println();
                System.out.println("Top 3 Most Used Words");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = keys.get(i);
                    Double value = values.get(i);
                    String akey = pwords.get(i);
                    double avalue = Double.parseDouble(pstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                System.out.println();
                System.out.println("Top 3 Most Used Words Excluding Conjunctions");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = ckeys.get(i);
                    Double value = cvalues.get(i);
                    String akey = pcwords.get(i);
                    double avalue = Double.parseDouble(pcstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
            }
            case 2 -> {
                System.out.println();
                System.out.println("Top 3 Most Used Words");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = keys.get(i);
                    Double value = values.get(i);
                    String akey = jwords.get(i);
                    double avalue = Double.parseDouble(jstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                System.out.println();
                System.out.println("Top 3 Most Used Words Excluding Conjunctions");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = ckeys.get(i);
                    Double value = cvalues.get(i);
                    String akey = jcwords.get(i);
                    double avalue = Double.parseDouble(jcstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
            }
            case 3 -> {
                System.out.println();
                System.out.println("Top 3 Most Used Words");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = keys.get(i);
                    Double value = values.get(i);
                    String akey = rwords.get(i);
                    double avalue = Double.parseDouble(rstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                System.out.println();
                System.out.println("Top 3 Most Used Words Excluding Conjunctions");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = ckeys.get(i);
                    Double value = cvalues.get(i);
                    String akey = rcwords.get(i);
                    double avalue = Double.parseDouble(rcstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
            }
        }
    }

    static void compTwo() {
        switch (aut) {
            case 1:
                double x = l / pat.get("car");
                x = x * 100; //% similarity for characters
                BigDecimal b1 = new BigDecimal(Double.toString(x));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                x = b1.doubleValue();
                String xx = String.valueOf(x);
                xx = xx + "%";

                double y = per100 / pat.get("per100");
                y = y * 100; //%similarity for sentences/100char
                b1 = new BigDecimal(Double.toString(y));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                y = b1.doubleValue();
                String yy = String.valueOf(y);
                yy = yy + "%";

                double z = w / pat.get("words");
                z = z * 100; //%similarity for words
                b1 = new BigDecimal(Double.toString(z));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                z = b1.doubleValue();
                String zz = String.valueOf(z);
                zz = zz + "%";

                double k = sper100 / pat.get("sper100");
                k = k * 100; //%similarity for sentences/100words
                b1 = new BigDecimal(Double.toString(k));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                k = b1.doubleValue();
                String kk = String.valueOf(k);
                kk = kk + "%";

                double q = pat.get("car") + 0;
                String qq = String.valueOf(q);

                double e = pat.get("per100") + 0;
                String ee = String.valueOf(e);

                double r = pat.get("words") + 0;
                String rr = String.valueOf(r);

                double t = pat.get("sper100") + 0;
                String tt = String.valueOf(t);

                System.out.println();
                System.out.println("Sentence Content & Length Comparison");
                System.out.println("====================================================================================");
                System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + qq + "  ||  " + xx + "        |");
                System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + ee + "  ||  " + yy + "        |");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + rr + "  ||  " + zz + "        |");
                System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + tt + "  ||  " + kk + "        |");
                System.out.println("===================================================================================");
                break;
            case 2:
                x = l / jk.get("car");
                x = x * 100; //% similarity for characters
                b1 = new BigDecimal(Double.toString(x));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                x = b1.doubleValue();
                xx = String.valueOf(x);
                xx = xx + "%";

                y = per100 / jk.get("per100");
                y = y * 100; //%similarity for sentences/100char
                b1 = new BigDecimal(Double.toString(y));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                y = b1.doubleValue();
                yy = String.valueOf(y);
                yy = yy + "%";

                z = w / jk.get("words");
                z = z * 100; //%similarity for words
                b1 = new BigDecimal(Double.toString(z));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                z = b1.doubleValue();
                zz = String.valueOf(z);
                zz = zz + "%";

                k = sper100 / jk.get("sper100");
                k = k * 100; //%similarity for sentences/100words
                b1 = new BigDecimal(Double.toString(k));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                k = b1.doubleValue();
                kk = String.valueOf(k);
                kk = kk + "%";

                q = jk.get("car") + 0;
                qq = String.valueOf(q);

                e = jk.get("per100") + 0;
                ee = String.valueOf(e);

                r = jk.get("words") + 0;
                rr = String.valueOf(r);

                t = jk.get("sper100") + 0;
                tt = String.valueOf(t);

                System.out.println();
                System.out.println("Sentence Content & Length Comparison");
                System.out.println("====================================================================================");
                System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + qq + "  ||  " + xx + "        |");
                System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + ee + "  ||  " + yy + "        |");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + rr + "  ||  " + zz + "        |");
                System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + tt + "  ||  " + kk + "        |");
                System.out.println("===================================================================================");
                break;
            case 3:
                x = l / rick.get("car");
                x = x * 100; //% similarity for characters
                b1 = new BigDecimal(Double.toString(x));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                x = b1.doubleValue();
                xx = String.valueOf(x);
                xx = xx + "%";

                y = per100 / rick.get("per100");
                y = y * 100; //%similarity for sentences/100char
                b1 = new BigDecimal(Double.toString(y));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                y = b1.doubleValue();
                yy = String.valueOf(y);
                yy = yy + "%";

                z = w / rick.get("words");
                z = z * 100; //%similarity for words
                b1 = new BigDecimal(Double.toString(z));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                z = b1.doubleValue();
                zz = String.valueOf(z);
                zz = zz + "%";

                k = sper100 / rick.get("sper100");
                k = k * 100; //%similarity for sentences/100words
                b1 = new BigDecimal(Double.toString(k));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                k = b1.doubleValue();
                kk = String.valueOf(k);
                kk = kk + "%";

                q = rick.get("car") + 0;
                qq = String.valueOf(q);

                e = rick.get("per100") + 0;
                ee = String.valueOf(e);

                r = rick.get("words") + 0;
                rr = String.valueOf(r);

                t = rick.get("sper100") + 0;
                tt = String.valueOf(t);

                System.out.println();
                System.out.println("Sentence Content & Length Comparison");
                System.out.println("====================================================================================");
                System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + qq + "  ||  " + xx + "        |");
                System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + ee + "  ||  " + yy + "        |");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + rr + "  ||  " + zz + "        |");
                System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + tt + "  ||  " + kk + "        |");
                System.out.println("===================================================================================");
                break;
        }

    }

    static void compThree() {
        switch (aut) {
            case 1 -> {
                System.out.println();
                System.out.println("Top 3 Most Used Words");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = keys.get(i);
                    Double value = values.get(i);
                    String akey = pwords.get(i);
                    double avalue = Double.parseDouble(pstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                System.out.println();
                System.out.println("Top 3 Most Used Words Excluding Conjunctions");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = ckeys.get(i);
                    Double value = cvalues.get(i);
                    String akey = pcwords.get(i);
                    double avalue = Double.parseDouble(pcstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                double x = l / pat.get("car");
                x = x * 100; //% similarity for characters
                BigDecimal b1 = new BigDecimal(Double.toString(x));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                x = b1.doubleValue();
                String xx = String.valueOf(x);
                xx = xx + "%";
                double y = per100 / pat.get("per100");
                y = y * 100; //%similarity for sentences/100char
                b1 = new BigDecimal(Double.toString(y));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                y = b1.doubleValue();
                String yy = String.valueOf(y);
                yy = yy + "%";
                double z = w / pat.get("words");
                z = z * 100; //%similarity for words
                b1 = new BigDecimal(Double.toString(z));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                z = b1.doubleValue();
                String zz = String.valueOf(z);
                zz = zz + "%";
                double k = sper100 / pat.get("sper100");
                k = k * 100; //%similarity for sentences/100words
                b1 = new BigDecimal(Double.toString(k));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                k = b1.doubleValue();
                String kk = String.valueOf(k);
                kk = kk + "%";
                double q = pat.get("car") + 0;
                String qq = String.valueOf(q);
                double e = pat.get("per100") + 0;
                String ee = String.valueOf(e);
                double r = pat.get("words") + 0;
                String rr = String.valueOf(r);
                double t = pat.get("sper100") + 0;
                String tt = String.valueOf(t);
                System.out.println();
                System.out.println("Sentence Content & Length Comparison");
                System.out.println("====================================================================================");
                System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + qq + "  ||  " + xx + "        |");
                System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + ee + "  ||  " + yy + "        |");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + rr + "  ||  " + zz + "        |");
                System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + tt + "  ||  " + kk + "        |");
                System.out.println("===================================================================================");
            }
            case 2 -> {
                System.out.println();
                System.out.println("Top 3 Most Used Words");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = keys.get(i);
                    Double value = values.get(i);
                    String akey = jwords.get(i);
                    double avalue = Double.parseDouble(jstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                System.out.println();
                System.out.println("Top 3 Most Used Words Excluding Conjunctions");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = ckeys.get(i);
                    Double value = cvalues.get(i);
                    String akey = jcwords.get(i);
                    double avalue = Double.parseDouble(jcstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                double x = l / jk.get("car");
                x = x * 100; //% similarity for characters
                BigDecimal b1 = new BigDecimal(Double.toString(x));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                x = b1.doubleValue();
                String xx = String.valueOf(x);
                xx = xx + "%";
                double y = per100 / jk.get("per100");
                y = y * 100; //%similarity for sentences/100char
                b1 = new BigDecimal(Double.toString(y));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                y = b1.doubleValue();
                String yy = String.valueOf(y);
                yy = yy + "%";
                double z = w / jk.get("words");
                z = z * 100; //%similarity for words
                b1 = new BigDecimal(Double.toString(z));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                z = b1.doubleValue();
                String zz = String.valueOf(z);
                zz = zz + "%";
                double k = sper100 / jk.get("sper100");
                k = k * 100; //%similarity for sentences/100words
                b1 = new BigDecimal(Double.toString(k));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                k = b1.doubleValue();
                String kk = String.valueOf(k);
                kk = kk + "%";
                double q = jk.get("car") + 0;
                String qq = String.valueOf(q);
                double e = jk.get("per100") + 0;
                String ee = String.valueOf(e);
                double r = jk.get("words") + 0;
                String rr = String.valueOf(r);
                double t = jk.get("sper100") + 0;
                String tt = String.valueOf(t);
                System.out.println();
                System.out.println("Sentence Content & Length Comparison");
                System.out.println("====================================================================================");
                System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + qq + "  ||  " + xx + "        |");
                System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + ee + "  ||  " + yy + "        |");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + rr + "  ||  " + zz + "        |");
                System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + tt + "  ||  " + kk + "        |");
                System.out.println("===================================================================================");
            }
            case 3 -> {
                System.out.println();
                System.out.println("Top 3 Most Used Words");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = keys.get(i);
                    Double value = values.get(i);
                    String akey = rwords.get(i);
                    double avalue = Double.parseDouble(rstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                System.out.println();
                System.out.println("Top 3 Most Used Words Excluding Conjunctions");
                System.out.println("=================================");
                System.out.println("YOU:        ||  " + author.toUpperCase() + ":");
                for (int i = 0; i < 3; i++) {
                    String key = ckeys.get(i);
                    Double value = cvalues.get(i);
                    String akey = rcwords.get(i);
                    double avalue = Double.parseDouble(rcstats.get(i));
                    System.out.println(key + " (" + value + ")" + " || " + akey + " (" + avalue + ")");
                }
                System.out.println("=================================");
                double x = l / rick.get("car");
                x = x * 100; //% similarity for characters
                BigDecimal b1 = new BigDecimal(Double.toString(x));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                x = b1.doubleValue();
                String xx = String.valueOf(x);
                xx = xx + "%";
                double y = per100 / rick.get("per100");
                y = y * 100; //%similarity for sentences/100char
                b1 = new BigDecimal(Double.toString(y));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                y = b1.doubleValue();
                String yy = String.valueOf(y);
                yy = yy + "%";
                double z = w / rick.get("words");
                z = z * 100; //%similarity for words
                b1 = new BigDecimal(Double.toString(z));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                z = b1.doubleValue();
                String zz = String.valueOf(z);
                zz = zz + "%";
                double k = sper100 / rick.get("sper100");
                k = k * 100; //%similarity for sentences/100words
                b1 = new BigDecimal(Double.toString(k));
                b1 = b1.setScale(2, RoundingMode.HALF_UP);
                k = b1.doubleValue();
                String kk = String.valueOf(k);
                kk = kk + "%";
                double q = rick.get("car") + 0;
                String qq = String.valueOf(q);
                double e = rick.get("per100") + 0;
                String ee = String.valueOf(e);
                double r = rick.get("words") + 0;
                String rr = String.valueOf(r);
                double t = rick.get("sper100") + 0;
                String tt = String.valueOf(t);
                System.out.println();
                System.out.println("Sentence Content & Length Comparison");
                System.out.println("====================================================================================");
                System.out.println("|                                  | YOU:  ||  " + author.toUpperCase() + ":  || " + "% of Author  |");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("|Avg. Characters Per Sentence      |  " + l + "    ||  " + qq + "  ||  " + xx + "        |");
                System.out.println("|Avg. Sentences Per 100 Characters |  " + per100 + "     ||  " + ee + "  ||  " + yy + "        |");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("|Avg. Words Per Sentence           |  " + w + "    ||  " + rr + "  ||  " + zz + "        |");
                System.out.println("|Avg. Sentences Per 100 Words      |  " + sper100 + "     ||  " + tt + "  ||  " + kk + "        |");
                System.out.println("===================================================================================");
            }
        }
    }
}
