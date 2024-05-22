package RecursionAndBacktracking;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Permutations {

    public void helper(int @NotNull [] ar, Set<Integer> set, @NotNull ArrayList<Integer> list, List<List<Integer>> finalList) {
        // Base Case, if length is same then it is one of the permutations
        if (list.size() == ar.length) {
            finalList.add(new ArrayList<>(list));
            return;
        }
        // Moving through the n choices to select a possible candidate for the current index
        for (int i = 0; i < ar.length; i++) {
            // Checks if the current value has already been used or not
            if (set.contains(i)) continue;
            // If not we add it to the list and mark it as visited
            list.add(ar[i]); set.add(i);
            // Moving for the next index with the current one being used
            helper(ar, set, list, finalList);
            // Returning from the previous path to try out alternative values for the current index
            list.remove(list.size() - 1); set.remove(i);
        }
    }

    public void swap(int i, int j, int @NotNull [] ar) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    public void helper(int @NotNull [] ar, int index, List<String> finalList) {
        // means that we have reached the end of our array and no swaps possible so we have found one permutation
        if (index >= ar.length){
            finalList.add(Arrays.toString(ar));
            return;
        }
        // we loop from the current index to n - 1 to perform swaps
        for (int i = index; i < ar.length; i++) {
            // swapping is used to try out alternative options for the current index
            swap(i, index, ar);
            // after swapping we move to the next index to repeat the process
            helper(ar, index + 1, finalList);
            // we come back after trying out the different combinations for the successor indices and
            // swap out values to try out other values for the current index
            swap(i, index, ar);
        }
    }

    public void findPermutations(int[] ar) {
        List<String> finalList = new ArrayList<>();
        helper(ar, 0, finalList);
        System.out.println(finalList);
        System.out.println(finalList.size());
    }

    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};
        new Permutations().findPermutations(ar);
    }
}
