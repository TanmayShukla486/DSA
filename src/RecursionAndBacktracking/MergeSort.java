package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private void merge(int[] ar, int low, int mid, int high) {
        List<Integer> t1 = new ArrayList<>(); // arraylist to store first half
        List<Integer> t2 = new ArrayList<>(); // arraylist to store second half

        // looping through the first half of the array to store it in 't1'
        for (int i = low; i <= mid; i++) t1.add(ar[i]);
        // looping through the second half of the array to store it in 't2'
        for (int i = mid + 1; i <= high; i++) t2.add(ar[i]);

        // variables to control the flow
        int i = 0, j = 0, k = low;

        // Filling the array back according to the values
        while (i < t1.size() && j < t2.size()) {
            // checking which value is smaller and then placing it first
            if (t1.get(i) < t2.get(j))
                ar[k++] = t1.get(i++);
            else
                ar[k++] = t2.get(j++);
        }

        // Filling the remaining elements if any in either of the two halves
        while (i < t1.size()) ar[k++] = t1.get(i++);
        while (j < t2.size()) ar[k++] = t2.get(j++);

    }

    private void mergeSort(int[] ar, int low, int high) {
        if (low >= high) return; // low >= high means that the array is sorted, so we return
        int mid = low + (high - low)/2;
        // Sorting the first half of the array
        mergeSort(ar, low, mid);
        // Sorting the second half of the array
        mergeSort(ar, mid + 1, high);
        // Merging the two sorted halves of the array
        merge(ar, low, mid, high);
    }

    public static void main(String[] args) {
        int[] ar = {5,4,3,2,1,0,-1};
        new MergeSort().mergeSort(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }
}
