package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumII {
    public int subarraySum(int[] ar, int target) {
        int count = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
            prefixSum.compute(sum, (key, val) -> (val == null) ? 1 : ++val);
            if (prefixSum.containsKey(sum - target)) count += prefixSum.get(sum - target);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ar = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(new SubarraySumII().subarraySum(ar, 4));
    }
}
