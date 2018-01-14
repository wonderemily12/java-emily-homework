package codewings.emily.hw4;


public class BigInteger {
    private int[] backend = new int[1001];

    public static BigInteger of(String str) {
        BigInteger bigint = new BigInteger();
        for (int i = 0; i < str.length(); i++)
            bigint.backend[i] = str.charAt(str.length() - i - 1) - '0';
        return bigint;
    }

    public static BigInteger add(BigInteger a, BigInteger b) {
        BigInteger c = new BigInteger();
        for (int i = 0; i < c.backend.length; i++) {
            c.backend[i] = a.backend[i] + b.backend[i];
        }
        c.adjustCarry();
        return c;
    }

    public static BigInteger subtract(BigInteger a, BigInteger b) {
        BigInteger c = new BigInteger();
        for (int i = 0; i < c.backend.length; i++) {
            c.backend[i] = a.backend[i] - b.backend[i];
        }
        c.adjustBorrow();
        return c;
    }

    public void adjustCarry() {
        for (int i = 0; i < backend.length; i++) {
            while (backend[i] >= 10) {
                backend[i + 1]++;
                backend[i] -= 10;
            }
        }
    }

    public void adjustBorrow() {
        for (int i = 0; i < backend.length; i++) {
            while (backend[i] < 0) {
                backend[i + 1]--;
                backend[i] += 10;
            }
        }
    }

    public void print() {
        for (int i = backend.length - 1; i >= backend.length; i--) {
            System.out.print(backend[i]);
        }
        System.out.println();
    }
}


