package RecursionAndBacktracking;

import java.util.*;

public class LeastUnique {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length <= k) return 0;
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int j: arr) freqCount.compute(j, (key, val) -> val == null ? 1 : ++val);
        List<Integer> freqList = (List<Integer>) freqCount.values();
        Collections.sort(freqList);
        while(k > 0 && !freqList.isEmpty()) {
            k -= freqList.get(0);
            if (k < 0) break;
            freqList.remove(0);
        }
        return freqList.size();
    }
    public static void main(String[] args) {}
}
