package codewings.emily.hw4;

import com.intellij.icons.AllIcons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigIntegerMain {
    public static void main(String[] args) throws IOException {
//        testCompareTo();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BigInteger a = BigInteger.of(reader.readLine());
            BigInteger b = BigInteger.of(reader.readLine());
            BigInteger c = new BigInteger();
            for (int i = 0; i < c.backend.length; i++) {
                if (a.backend[0] == '+' && b.backend[0] == '+') {
                    c = BigInteger.add(a, b);
                }
                else if (a.backend[0] == '+' && b.backend[0] == '-' ||  a.backend[0] == '-' && b.backend[0] == '+') {
                    c = BigInteger.subtract(a, b);
                }
                else if (a.backend[0] == '-' && b.backend[0] == '-') {
                    c = BigInteger.add(a, b);
                    c.backend[0] = '-';
                }
            }
            c.print();
        }
    }

//    public static void testCompareTo() {
//        assert BigInteger.of("123").compareTo(BigInteger.of("45")) > 0;
//        assert BigInteger.of("45").compareTo(BigInteger.of("123")) < 0;
//        assert BigInteger.of("12345").compareTo(BigInteger.of("12346")) < 0;
//        assert BigInteger.of("12345").compareTo(BigInteger.of("12344")) > 0;
//        assert BigInteger.of("123").compareTo(BigInteger.of("123")) == 0;
//        System.out.println("Test Succeed");
//    }
}



