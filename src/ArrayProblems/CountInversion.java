package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {

    private static void merge(int[] a, int low, int mid, int high, int[] count){
        List<Integer> t1 = new ArrayList<>(), t2 = new ArrayList<>();
        for (int i = low; i <= mid; i++) t1.add(a[i]);
        for (int i = mid + 1; i <= high; i++) t2.add(a[i]);
        int i = 0, j = 0, k = low;
        int n = t1.size(), m = t2.size();
        while (i < n && j < m) {
            if (t1.get(i) <= t2.get(j)) {
                a[k++] = t1.get(i++);
            } else {
                a[k++] = t2.get(j++);
                count[0] += n - i;
            }
        }
        while (i < n) a[k++] = t1.get(i++);
        while (j < m) a[k++] = t2.get(j++);
    }

    private static void mergeSortCount(int[] a, int low, int high, int[] count) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSortCount(a, low, mid, count);
        mergeSortCount(a, mid + 1, high, count);
        merge(a, low, mid, high, count);
    }
    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        int[] count = {0};
        mergeSortCount(a, 0, n - 1, count);
        return count[0];
    }

    public static void convertInput(String[] a, int[] ar) {
        int i = 0;
        for (String s: a) {
            ar[i++] = Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {
        String[] a = "1 20 6 4 5".split(" ");
        int[] ar = new int[a.length];
        convertInput(a, ar);
        System.out.println(numberOfInversions(ar, ar.length));
    }
}
