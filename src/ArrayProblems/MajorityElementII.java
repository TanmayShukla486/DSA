package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    /** Frequency of element > (n / 3)
     *  Step-Wise Approach:
     *  1. Check if element1 = ar[i] -> yes => element1Count++
     *  2. Check if not element1 then element2 = ar[i] -> yes => element2Count++
     *  3. Check if count of element1 = 0 -> add new element1
     *  4. Check if count of element2 = 0 -> add new element2
     *  5. if ar[i] != element1 || element2 -> decrease count of both
     *  This causes the two majority elements to filter out from the pile automatically
     *  if in the end their count is zero
     * */
    public List<Integer> findMajorityElement(int[] ar) {
        // assigning the first element of array as first majority element and
        // leaving the second element blank
        int count1 = 1, count2 = 0, element1 = ar[0], element2 = -1;
        for (int i = 1; i < ar.length; i++) {
            // if the current element is equal to first majority element increase its count
            if (ar[i] == element1) count1++;
            // if it is equal to second element increase its count
            else if (ar[i] == element2) count2++;
            // if no first element exists we assign a new one
            else if (count1 == 0) {
                count1 = 1; element1 = ar[i];
            }
            // similarly if no second element exists we assign a new one
            else if (count2 == 0) {
                count2 = 1; element2 = ar[i];
            }
            // if it is equal to neither first nor second we decrease the count of each element by one
            else if (ar[i] != element1 && ar[i] != element2) {
                count1--; count2--;
            }
        }
        List<Integer> answer = new ArrayList<>();
        // if count of either element is greater than zero then that is a majority element with freq > (n/3)
        if (count1 > 0) answer.add(element1);
        if (count2 > 0) answer.add(element2);
        return answer;
    }
}
