package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum {
    private void findCombinations(int[] ar, int index, ArrayList<Integer> list, int target) {
        if (index >= ar.length) return;
        if (target < 0) return;
        else if (target == 0) {
            System.out.println(list);
            return;
        }
        list.add(ar[index]);
        findCombinations(ar, index, list, target - ar[index]);
        list.remove(list.size() - 1);
        findCombinations(ar, index + 1, list, target);
    }

    private void uniqueCombinationSum(Set<Integer> visitedIndex, int[] ar, ArrayList<Integer> list, int target, int index) {
        if (index >= ar.length) return;
        else if (visitedIndex.contains(index)) return;
        else if (target < 0) return;
        if (target == 0) {
            System.out.println(list);
            return;
        }
        visitedIndex.add(index);
        list.add(ar[index]);
        uniqueCombinationSum(visitedIndex, ar, list, target - ar[index], index + 1);
        visitedIndex.remove(index);
        list.remove(list.size() - 1);
        uniqueCombinationSum(visitedIndex, ar, list, target, index + 1);
    }

    public static void main(String[] args) {
        int[] ar = {10,1,2,7,6,1,5};
        new CombinationSum().uniqueCombinationSum(new HashSet<>(), ar, new ArrayList<>(), 8, 0);
    }
}
