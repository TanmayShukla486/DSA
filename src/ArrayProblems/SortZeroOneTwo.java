package ArrayProblems;

import java.util.Arrays;

public class SortZeroOneTwo {

    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
    public void sortArray(int[] ar) {
        int low = 0, mid = 0, high = ar.length - 1;
        while (mid <= high) {
            if (ar[mid] == 0) swap(ar, low++, mid++);
            else if (ar[mid] == 1) mid++;
            else if (ar[mid] == 2) swap(ar, mid , high--);
        }
        System.out.println(Arrays.toString(ar));
    }
}
