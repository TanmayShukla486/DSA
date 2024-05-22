package ArrayProblems;

import org.graalvm.collections.Pair;

public class MissingNumberAndRepeatingNumber {

    public Pair<Integer, Integer> findMissingAndRepeatingNumber(int n, int[] ar) {
        long n1 = n;
        long Sn = (n1 * (n1 + 1)) / 2;
        long S2n = (n1 * (n1 + 1) * (2 * n1 + 1)) / 6;
        long S = 0L, S2 = 0L;
        for (int j : ar) {
            S += j;
            S2 += ((long) j * j);
        }
        long val1 = S - Sn;
        long val2 = S2 - S2n;
        val2 /= val1;
        long x = (val2 + val1) / 2L;
        long y = x - val1;
        return Pair.create((int)x, (int)y);
    }

}
