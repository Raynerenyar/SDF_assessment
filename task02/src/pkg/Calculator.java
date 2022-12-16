package pkg;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static final List<String> listOfOperators = Arrays.asList("+", "-", "*",
            "/");

    public static Double calculate(String num1, String num2, String oper) {

        // if (num1.equalsIgnoreCase("$last")) {
        // num1 = last;
        // } else if (num2.equalsIgnoreCase("$last")) {
        // num2 = last;
        // }

        Double doubleNum1 = Double.parseDouble(num1);
        Double doubleNum2 = Double.parseDouble(num2);
        // BigDecimal bigNum1 = BigDecimal.valueOf(doubleNum1);
        // BigDecimal bigNum2 = BigDecimal.valueOf(doubleNum2);

        // System.out.println(bigNum1);
        // System.out.println(bigNum2);

        switch (oper) {
            case "+" -> {
                return doubleNum1 + doubleNum2;
            }
            case "-" -> {
                return doubleNum1 - doubleNum2;
            }
            case "*" -> {
                return doubleNum1 * doubleNum2;
            }
            case "/" -> {
                return doubleNum1 / doubleNum2;
            }
        }
        return 0d;
    }

    public static Boolean isValueInMaxMinRange(String num1, String num2) {
        // System.out.printf("num1: %s\n", num1);
        // System.out.printf("num2: %s\n", num2);

        Double doubleNum1 = Double.parseDouble(num1);
        Double doubleNum2 = Double.parseDouble(num2);

        // System.out.printf("num1: %,f\n", doubleNum1);
        // System.out.printf("num1: %,f\n", doubleNum2);

        if (doubleNum1 > Long.MAX_VALUE || doubleNum1 < Long.MIN_VALUE) {
            return false;
        }
        if (doubleNum2 > Long.MAX_VALUE || doubleNum2 < Long.MIN_VALUE) {
            return false;
        }
        // if ((long) doubleNum1 > Double.MAX_VALUE)
        return true;
    }

    public static Boolean isValueInMaxMinRange(Double result) {
        if (result > Long.MAX_VALUE || result < Long.MIN_VALUE) {
            return false;
        }
        if (result > Long.MAX_VALUE || result < Long.MIN_VALUE) {
            return false;
        }
        // if ((long) doubleNum1 > Double.MAX_VALUE)
        return true;
    }

    public static Boolean isInputValid(String line) {
        String[] terms = line.split(" ");
        // check length first to prevent out of bound exception
        if (!(terms.length == 3)) {
            return false;
        }
        // return false if operator is not in the list of operators
        if (!listOfOperators.contains(terms[1])) {
            return false;
        }
        try {
            Double doubleNum1 = Double.parseDouble(terms[0]);
            Double doubleNum2 = Double.parseDouble(terms[2]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
