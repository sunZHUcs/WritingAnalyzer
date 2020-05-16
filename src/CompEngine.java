public class CompEngine extends VarFunc {

    static void compZero() {
        compOne();
        compTwo();
    }

    static void compOne() {
        String break1 = "============================================";
        String break2 = "--------------------------------------------";
        String separator = " || ";
        StringBuilder header = new StringBuilder("| YOU:            ||  " + author.toUpperCase() + ":");
        while (header.length() < 43) {
            header.append(" ");
        }
        header.append("|");

        System.out.println();
        System.out.println("Top 3 Most Used Words");
        System.out.println(break1);
        System.out.println(header);
        System.out.println(break2);

        for (int i = 0; i < 3; i++) {
            String key = keys.get(i);
            Double value = values.get(i);
            String akey = awords.get(i);
            double avalue = Double.parseDouble(astats.get(i));
            roundDouble(value);

            String part1 = key + " (" + value + ")";
            String part2 = akey + " (" + avalue + ")";

            part1 = constAppend(part1, 15);
            part2 = constAppend(part2, 22);

            System.out.println("| " + part1 + separator + part2 + "|");
        }
        System.out.println(break1);

        System.out.println();
        System.out.println("Top 3 Most Used Words Excluding Conjunctions and Common Words");
        System.out.println(break1);
        System.out.println(header);
        System.out.println(break2);

        for (int i = 0; i < 3; i++) {
            String key = ckeys.get(i);
            Double value = cvalues.get(i);
            String akey = acwords.get(i);
            double avalue = Double.parseDouble(acstats.get(i));
            roundDouble(value);

            String part1 = key + " (" + value + ")";
            String part2 = akey + " (" + avalue + ")";

            part1 = constAppend(part1, 15);
            part2 = constAppend(part2, 22);

            System.out.println("| " + part1 + separator + part2 + "|");
        }
        System.out.println(break1);
    }


    static void compTwo() {
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

        //TODO: DO HEADER PARTS & APPEND
        String header1 = "|                                  | YOU:    ";
        String header2 = author.toUpperCase() + ":";
        String header3 = "% of Author";
        String one = "|Avg. Characters Per Sentence      |  " + l;
        String two = " " + q;
        String three = " " + x;
        String four = "|Avg. Sentences Per 100 Characters |  " + per100;
        String five = " " + e;
        String six = " " + y;
        String seven = "|Avg. Words Per Sentence           |  " + w;
        String eight = " " + r;
        String nine = " " + z;
        String ten = "|Avg. Sentences Per 100 Words      |  " + sper100;
        String eleven = " " + t;
        String twelve = " " + k;

        header2 = constAppend(header2, 19);
        header3 = constAppend(header3, 11);
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

