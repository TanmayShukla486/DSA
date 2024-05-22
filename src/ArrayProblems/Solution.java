package ArrayProblems;

import java.util.*;

public class Solution {


    public int maxPointsInsideSquare(int[][] points, String s) {
        Arrays.sort(points, (a, b) -> Math.toIntExact((((long) a[0] * a[0] + (long) a[1] * a[1]) - ((long) b[0] * b[0] + (long) b[1] * b[1]))));
        int i = 0; int curr = i, c = 0;
        Set<Character> val = new HashSet<>();
        for (int j = 0; j < points.length;) {
            int count = 0;
            while (j < points.length && Math.abs(points[j][0]) <= curr && Math.abs(points[j][1]) <= curr) {
                if (val.contains(s.charAt(j))) {
                    return i;
                }
                count++;
                val.add(s.charAt(j));
                j++;
            }
            if (count > 0) {
                c++;
            }
            curr++;
        }
        return i;
    }

    public static void main(String[] args) {
        new Solution().maxPointsInsideSquare(
                new int[][] {
                        {-1,-4},{16,-8},{13,-3},{-12,0}
                }, "abda"
        );
    }
}
