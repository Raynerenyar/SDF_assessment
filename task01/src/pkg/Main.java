package pkg;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String csvFilename = args[0];
        String templateFile = args[1];

        List<Map<String, String>> peopleMap = CSV.csvReader(csvFilename);
        Template.fillIn(peopleMap, templateFile);
    }
}
