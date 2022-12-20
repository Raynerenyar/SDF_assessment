package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CSV {

    public static List<Map<String, String>> csvReader(String fileName) {

        List<Map<String, String>> listOfPeople = new LinkedList<>();

        try {
            Reader r = new FileReader(fileName);
            BufferedReader bfr = new BufferedReader(r);
            String line = bfr.readLine();

            // get headers
            String[] headers = line.split(",");
            String[] contents = new String[headers.length];

            /*
             * List<Map<String, String>>
             * 
             * List
             * ┃
             * ┣━━ Map1 ━━┳ Header1: value1
             * ┃          ┣ Header2: value2
             * ┃          ┗ Header3: value3
             * ┃
             * ┣━━ Map2 ━━┳ Header1: value1
             * ┃          ┣ Header2: value2
             * ┃          ┗ Header3: value3
             * ┃
             * ┗━━ Map3 ━━┳ Header1: value1
             *            ┣ Header2: value2
             *            ┗ Header3: value3
             */
            while ((line = bfr.readLine()) != null) {
                contents = line.split(",");
                Map<String, String> people = new HashMap<String, String>();
                for (int i = 0; i < contents.length; i++) {
                    people.put(headers[i], contents[i]);
                }
                listOfPeople.add(people);
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfPeople;
    }
}
