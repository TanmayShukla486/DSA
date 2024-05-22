package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    private static void mergeReverse(int[] a, int low, int mid, int high, int[] count){
        List<Integer> t1 = new ArrayList<>(), t2 = new ArrayList<>();

        for (int i = low; i <= mid; i++) t1.add(a[i]);
        for (int i = mid + 1; i <= high; i++) t2.add(a[i]);

        int i = 0, j = 0, k = low;
        int n = t1.size(), m = t2.size();

        while (i < n) {
            while (j < m &&  2 * t2.get(j) < t1.get(i))
                j++;
            count[0] += j;
            i++;
        }

        i = 0; j = 0;

        while (i < n && j < m) {
            if (t1.get(i) < t2.get(j)) {
                a[k++] = t1.get(i++);
            } else {
                a[k++] = t2.get(j++);
            }
        }
        while (i < n) a[k++] = t1.get(i++);
        while (j < m) a[k++] = t2.get(j++);

    }

    private static void mergeSortCountReverse(int[] a, int low, int high, int[] count) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSortCountReverse(a, low, mid, count);
        mergeSortCountReverse(a, mid + 1, high, count);
        mergeReverse(a, low, mid, high, count);
    }
    public static int numberOfReversePairs(int []a, int n) {
        // Write your code here.
        int[] count = {0};
        mergeSortCountReverse(a, 0, n - 1, count);
        return count[0];
    }

    public static void convertInput(String[] a, int[] ar) {
        int i = 0;
        for (String s: a) {
            ar[i++] = Integer.parseInt(s);
        }
    }
}
