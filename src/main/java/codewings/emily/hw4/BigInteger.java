package codewings.emily.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigInteger {
    public static void main(String[] args) throws IOException {
        // Skeleton code for reading long integer as a String and handle operation (+ or -)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String intA = reader.readLine();
            String operation = reader.readLine();
            String intB = reader.readLine();

            switch(operation) {
                case "+":
                    System.out.println(add(intA, intB));
                    break;
                case "-":
                    System.out.println(subtract(intA, intB));
                    break;
            }
        }

    }

    private static String add(String input1, String input2) {
        // TODO: Implement it
        return Integer.toString(Integer.parseInt(input1) + Integer.parseInt(input2));
    }

    private static String subtract(String input1, String input2) {
        // TODO: Implement it
        return Integer.toString(Integer.parseInt(input1) - Integer.parseInt(input2));
    }
}
