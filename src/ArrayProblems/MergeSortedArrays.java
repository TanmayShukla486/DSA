package ArrayProblems;

public class MergeSortedArrays {

    private static void swap(long[] a, long[] b, int i1, int i2) {
        long t = a[i1];
        a[i1] = b[i2];
        b[i2] = t;
    }

    private static void swapIfGreater(long[] a, long[] b, int i1, int i2) {
        if (a[i1] > b[i2]) {
            swap(a, b, i1, i2);
        }
    }

    /*TODO Revise the Without Extra Space solution*/

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int n = a.length, m = b.length;
        int gap = (n + m) / 2 + (n + m) % 2;

        while (gap > 0) {
            for (int i = 0, j = gap; i < n + m;i++, j++) {
                if (i < n && j >= n) {
                    swapIfGreater(a, b, i, j - n);
                } else if (i >= n) {
                    int t1 = i - n, t2 = j - n;
                    if (b[t1] > b[t2]) swapIfGreater(b, b, t1, t2);
                } else {
                    if (a[i] > a[j]) swapIfGreater(a, a, i, j);
                }
            }
            gap = (gap / 2) + (gap % 2);
        }
    }
}
