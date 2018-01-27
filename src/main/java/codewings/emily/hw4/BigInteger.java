package codewings.emily.hw4;

public class BigInteger {
    public int[] backend = new int[101];
    private int digit;

    public static BigInteger of(String str) {
        BigInteger bigint = new BigInteger();
        for (int i = 0; i < str.length(); i++)
            bigint.backend[i] = str.charAt(str.length() - i - 1) - '0';
        return bigint;
    }

    public static BigInteger add(BigInteger a, BigInteger b) {
        BigInteger c = new BigInteger();
        for (int i = 1; i < c.backend.length; i++) {
            c.backend[i] = a.backend[i] + b.backend[i];
        }
        c.adjustCarry();
        return c;
    }

    public static BigInteger subtract(BigInteger a, BigInteger b) {
        BigInteger c = new BigInteger();
        for (int i = c.backend.length - 1; i > 0; i--) {
            if (a.compareTo(b) == 1 || a.compareTo(b) == 0) {   // a >= b 이면 a - b
                c.backend[i] = a.backend[i] - b.backend[i];
            } else if (a.compareTo(b) == -1) {                  // a < b 이면 b - a, 부호 바꿔주기
                c.backend[i] = b.backend[i] - a.backend[i];
                c.backend[0] = '-';
            }
        }
        c.adjustBorrow();
        return c;
    }

    public int compareTo(BigInteger other) {
        for (int i = backend.length - 1; backend[i] == 0; i--) {
            this.digit = i + 1;
        }
        if (this.digit > other.digit) return 1;
        else if (this.digit == other.digit) {
            for (int i = this.digit - 1; i >= 0; i--) {
                if (this.backend[i] > other.backend[i]) return 1;
                else if (this.backend[i] < other.backend[i]) return -1;
            }
            return 0;
        }
        else return -1;
    }

    public void adjustCarry() {
        for (int i = 1; i < backend.length; i++) {
            while (backend[i] >= 10) {
                backend[i + 1]++;
                backend[i] -= 10;
            }
        }
    }

    public void adjustBorrow() {
        for (int i = 1; i < backend.length; i++) {
            while (backend[i] < 0) {
                backend[i + 1]--;
                backend[i] += 10;
            }
        }
    }

    public void print() {
        int j = 0;
        for (int i = backend.length - 1; backend[i] == 0; i--) { // backend 배열에 0밖에 없어서 break 불가능.
            if (backend[i] != 0) {
                j = i;
                break;
            }
        }
        while (j >= 0) {
            System.out.print(backend[j]);
            j--;
        }
    }
}