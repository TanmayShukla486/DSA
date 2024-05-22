package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithXorK {
    public int findCount(int n, int target, int[] ar) {
        Map<Integer, Integer> preXor = new HashMap<>();
        int xorValue = 0;
        int count = 0;
        preXor.put(0, 1);
        for (int i = 0; i < n; i++) {
            xorValue ^= ar[i];
            int missingVal = xorValue ^ target;
            count += preXor.getOrDefault(missingVal, 0);
            preXor.put(xorValue, preXor.getOrDefault(xorValue, 0) + 1);
        }
        return count;
    }

}
