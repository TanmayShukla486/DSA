package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    /**
     * Finding the maximum length of the sub-array with the sum 'k'
     */
    private int bruteForce(int[] ar, int target) {
        int len = 0;
        for (int i = 0; i < ar.length; i++) {
            int sum = 0;
            for (int j = i; j < ar.length; j++) {
                if (sum == target) len = Math.max(len, j - i + 1);
                else if (sum > target) break;
            }
        }
        return len;
    }

    private int betterApproach(int[] ar, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int sum = 0; int len = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
            hash.put(sum, i);
            if (sum == target) len = i + 1;
            if (hash.containsKey(target - sum)) len = Math.max(len, i - hash.get(target - sum) + 1);
        }
        return len;
    }

    private int twoPointerOptimal(int[] ar, int target) {
        int i = 0, j = 0;
        int len = 0, sum = 0;
        while (j < ar.length) {
            sum += ar[j];
            while(i < ar.length && sum > target) sum -= ar[i++];
            if (sum == target) len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
}
