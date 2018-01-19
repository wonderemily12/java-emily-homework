package codewings.emily.hw4;


public class BigInteger {
    private int[] backend = new int[1001];
    static int flag = 0;
    static int s = 0;
    public static int sign() {
        BigInteger bigint = new BigInteger();
        if (bigint.backend[0] == "-") s = 1;
        return s;
    }

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
            if (a.backend[i] >= b.backend[i]) {
                c.backend[i] = a.backend[i] - b.backend[i];
                flag = 1;
            }
            else {
                c.backend[i] = b.backend[i] - a.backend[i];
            }
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
        int j = 0;
        int z = 0;
        for (int i = backend.length - 1; backend[i] == 0; i--) {
            j = i - 1;
        }
        while (j >= 0) {
            if (flag == 0) System.out.print(backend[j]);
            else {
                if (z == 0) {
                    System.out.print("-");
                    z = 1;
                }
                System.out.print(backend[j]);
            }
            j--;
        }
        System.out.println();
    }
}

