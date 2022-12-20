package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Template {

    public static void fillIn(List<Map<String, String>> listOfPeople, String templateFileName) {
        Reader r;
        try {

            // for each name, write to output file with details of the person
            Integer count = 1;
            for (Map<String, String> personDetails : listOfPeople) {
                r = new FileReader(templateFileName);
                BufferedReader bfr = new BufferedReader(r);
                System.out.printf("\n");
                System.out.printf("Template %d\n", count);
                System.out.println("====================================================================");

                /*
                 * read template file line by line
                 * For each keyword, look for the corresponding placeholder in each line of the
                 * template
                 */
                String fullText = bfr.lines()
                        .map(x -> {
                            for (String keyword : personDetails.keySet()) {
                                x = x.replace("<<" + keyword + ">>", personDetails.get(keyword));
                                x = x.replace("\\n", "\n"); // cannot use split as it uses regex on "\\n"
                            }
                            return x;
                        })
                        .collect(Collectors.joining("\n"));

                count++;
                System.out.println(fullText);
                System.out.println("====================================================================");
                System.out.printf("\n");
                bfr.close();

            } // for

        } catch (Exception e) {
            e.printStackTrace();
        } // try-catch
    } // fillIn method
} // class
