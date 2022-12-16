package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CSV {

    // private final String FIRSTNAME;
    // private final String LASTNAME;
    // private final String STREET;
    // private final Integer YEARS;

    // public CSV(String firstName, String lastName, String street, Integer years) {
    // FIRSTNAME = firstName;
    // LASTNAME = lastName;
    // STREET = street;
    // YEARS = years;
    // }

    public static List<Map<String, String>> csvReader(String fileName) {
        Reader r;

        Map<String, Map<String, String>> peopleList = new HashMap<String, Map<String, String>>();
        List<Map<String, String>> listOfPeople = new LinkedList<>();
        // List<CSV> peopleList = new LinkedList<>();
        try {
            r = new FileReader(fileName);
            BufferedReader bfr = new BufferedReader(r);
            String line = bfr.readLine();
            // get headers
            String[] headers = line.split(",");
            String[] contents = new String[headers.length];
            // String line;
            while ((line = bfr.readLine()) != null) {
                contents = line.split(",");
                Map<String, String> people = new HashMap<String, String>();
                for (int i = 0; i < contents.length; i++) {
                    people.put(headers[i], contents[i]);
                }
                // group map by first item in headers. arbitary for any csv file
                // peopleList.put(people.get(headers[0]), people);
                listOfPeople.add(people);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfPeople;
    }

    // public String getFirstName() {
    // return FIRSTNAME;
    // }

    // public String getLastName() {
    // return LASTNAME;
    // }

    // public String getStreet() {
    // return STREET;
    // }

    // public Integer getYears() {
    // return YEARS;
    // }

}
