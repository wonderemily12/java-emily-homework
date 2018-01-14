package codewings.emily.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigIntegerMain {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BigInteger a = BigInteger.of(reader.readLine());
            BigInteger b = BigInteger.of(reader.readLine());
            BigInteger c = BigInteger.add(a, b);
            c.print();
        }
    }
}
