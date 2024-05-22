package RecursionAndBacktracking;

import java.util.Arrays;

public class QuickSort {
    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
    private int partition(int[] ar, int low, int high) {
        // low is the pivot index
        int pivot = (low + high) / 2;
        int i = low, j = high;
        while (i < j) {
            // we place <= as we put all the value equal to the pivot value on the left side of the pivot
            while (i < high && ar[i] <= ar[pivot]) i++;
            while (j > low && ar[j] > ar[pivot]) j--;
            if (i < j) swap(ar, i, j);
        }
        swap(ar, pivot, j);
        return j;
    }

    private void quickSort(int[] ar, int low, int high) {
        if (low >= high) return;
        int pivot = partition(ar, low, high);
        quickSort(ar, low, pivot - 1);
        quickSort(ar, pivot + 1, high);
    }

    public static void main(String[] args) {
        int[] ar = {5,4,3,2,1,0,-1,-2};
        new QuickSort().quickSort(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }
}
