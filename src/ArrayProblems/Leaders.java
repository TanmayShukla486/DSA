package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    public int[] replaceElements(int[] arr) {
        int n = arr.length - 1; // Get the length of the array minus 1.
        int leader = arr[n]; // Initialize the leader as the last element of the array.

        // Traverse the array backwards to update each element with the maximum element to its right.
        for (int i = n - 1; i >= 0; i--) {
            int temp = leader; // Store the current leader.
            leader = Math.max(arr[i], leader); // Update the leader if the current element is greater.
            arr[i] = temp; // Replace the current element with the previous leader.
        }

        arr[n] = -1; // Set the last element to -1 as it has no elements to its right.
        return arr; // Return the modified array.
    }

}
