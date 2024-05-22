package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] ar, int target) {
        Arrays.sort(ar); // Sort the array to simplify the search process.
        int n = ar.length; // Store the length of the array.
        List<List<Integer>> answer = new ArrayList<>(); // Initialize a list to store the resulting quadruplets.

        // Iterate through the array to select the first element of the quadruplet.
        for (int i = 0; i < n; i++) {
            // Iterate through the array to select the second element of the quadruplet.
            for (int j = i + 1; j < n; j++) {
                int k = j + 1, l = n - 1; // Initialize two pointers for the remaining elements.

                // Use two pointers technique to find the other two elements of the quadruplet.
                while (k < l) {
                    long sum = (long)ar[k] + (long)ar[l]; // Calculate the sum of the current pair of elements.
                    long req = (long)target - (long)ar[i] - (long)ar[j]; // Calculate the required sum to form the target.

                    // If the sum equals the required sum, add the quadruplet to the answer list.
                    if (sum == req) {
                        List<Integer> temp = Arrays.asList(ar[i], ar[j], ar[k], ar[l]);
                        answer.add(temp);
                        // Move the pointers to avoid duplicates in the array.
                        while(k < l && ar[k] == temp.get(2)) k++;
                        while (l > k && ar[l] == temp.get(3)) l--;
                    } else if (sum < req) { // If the sum is less than the required sum, move the left pointer.
                        k++;
                    } else { // If the sum is greater than the required sum, move the right pointer.
                        l--;
                    }
                }
                // Skip duplicate elements for the second element of the quadruplet.
                while (j + 1 < n && ar[j] == ar[j + 1]) j++;
            }
            // Skip duplicate elements for the first element of the quadruplet.
            while (i + 1 < n && ar[i] == ar[i + 1]) i++;
        }
        return answer; // Return the list of valid quadruplets.
    }
}
