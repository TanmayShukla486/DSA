package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsets {

    public void getSubsets(int[] ar, int index, ArrayList<Integer> list, List<List<Integer>> finalList, int count) {
        finalList.add(new ArrayList<>(list));
        for (int i = index; i < ar.length; i++) {
            if (i != index && ar[i] == ar[i - 1]) continue;
            list.add(ar[i]);
            getSubsets(ar, i + 1, list, finalList, count + 1);
            list.remove(list.size() - 1);
        }
    }

    public void findSubsets(int[] ar) {
        Arrays.sort(ar);
        List<List<Integer>> finalList = new ArrayList<>();
        getSubsets(ar, 0, new ArrayList<>(), finalList, 1);
        System.out.println(finalList);
    }

    public static void main(String[] args) {
        int[] ar = {3,3,2};
        new UniqueSubsets().findSubsets(ar);
    }
}
