package pkg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome.");
        Scanner scn = new Scanner(System.in);
        Double $last = 0d;

        while (true) {

            System.out.printf("> ");
            String line = scn.nextLine();

            // to exit calculator
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Bye bye");
                break;
            }

            // replaces terms with saved value
            line = line.replace("$last", Double.toString($last));
            String[] splitLine = line.split(" ");

            // verify inputs
            Boolean isInputValid = Calculator.isInputValid(line);
            if (!isInputValid) {
                System.out.println("\nInvalid input\nPlease input: \n<number> <operator> <number>\n");
                continue;
            }
            String num1 = splitLine[0];
            String oper = splitLine[1];
            String num2 = splitLine[2];

            // checks if values given are within range
            Boolean isValueInMaxMinRange = Calculator.isValueInMaxMinRange(num1, num2);
            if (isValueInMaxMinRange) {

                $last = Calculator.calculate(num1, num2, oper);

                // check if $last exceed range
                if (!Calculator.isValueInMaxMinRange($last)) {
                    continue;
                }
                if (Math.abs($last) % 1 > 0) {

                    System.out.println($last);
                } else {

                    Long long$last = $last.longValue();
                    System.out.printf("%d\n", long$last);

                }
            } else {
                System.out.println("value has exceeded max or min");
                System.out.printf("Max value allowed is: %d\n", Long.MAX_VALUE);
                System.out.printf("Min value allowed is: %d\n", Long.MIN_VALUE);

                continue;
            } // if-else
        } // while
        scn.close();
    }// main method
}// class
