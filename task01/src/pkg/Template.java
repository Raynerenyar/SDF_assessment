package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class Template {

    public static void fillIn(List<Map<String, String>> listOfPeople, String templateFileName) {
        Reader r;
        try {
            String line;

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
                while ((line = bfr.readLine()) != null) {

                    for (String keyword : personDetails.keySet()) {

                        // find placeholder in line
                        if (line.contains("<<" + keyword + ">>")) {

                            // replace placeholder with the correct detail
                            line = line.replace("<<" + keyword + ">>", personDetails.get(keyword));
                        }
                    } // for
                      // if (line.contains("\\n")) {
                      // String[] splitLine = line.split("\\n");
                      // line.getChars(0, 0, null, 0);
                      // System.out.println(splitLine[0]);
                      // System.out.println(splitLine[1]);
                      // }
                    System.out.printf("%s\n", line);
                } // while
                count++;
                System.out.println("====================================================================");
                System.out.printf("\n");

            } // for

        } catch (Exception e) {
            e.printStackTrace();
        } // try-catch
    } // fillIn method
} // class
