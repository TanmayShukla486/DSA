package RecursionAndBacktracking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {

    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
    private void heapify(int[] ar, int i, int n) {
        int l = 2 * i + 1; // the left child of the current node
        int r = 2 * (i + 1); // the right child of the current node
        int largest = i; // specifying the current parent node as the largest value and checking for children
        // Checking if the child node is in the scope
        if (l < n && ar[largest] < ar[l]) largest = l;
        if (r < n && ar[largest] < ar[r]) largest = r;
        // Only making a swap if the largest value is not the parent node and calling the heapify method
        // on the node with which we swap the value
        if (largest != i) {
            swap(ar, i, largest);
            heapify(ar, largest, n);
        }
    }

    private void makeHeap(int[] ar, int n) {
        // Starting from n / 2 because mathematically the parent nodes are placed at n / 2
        for (int i = n; i >= 0; i--)
            heapify(ar, i, n);
    }

    public void heapSort(int[] ar, int n) {
        if (n <= 1) return; // return if the size of the heap is less than or equal to 1
        swap(ar, 0, n); // swapping the last element with the first element of heap
        makeHeap(ar, n - 1); // making a heap for the reduced heap
        heapSort(ar, n - 1); // calling the function again on the remaining array while size > 1
    }

    public static void main(String[] args) {
        int[] ar = {3,2,1,5,6,4};
        HeapSort obj = new HeapSort();
        obj.makeHeap(ar, ar.length);
        obj.heapSort(ar, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }
}
