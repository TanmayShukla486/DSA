package RecursionAndBacktracking;

import java.util.ArrayList;

public class SubsetSum {

    public void findSums(int[] ar, int index, int sum, ArrayList<Integer> list) {
        if (index >= ar.length) {
            System.out.println(sum);
            System.out.println(list);
            return;
        }
        sum += ar[index];
        list.add(ar[index]);
        findSums(ar, index + 1, sum, list);
        sum -= ar[index];
        list.remove(list.size() - 1);
        findSums(ar, index + 1, sum, list);
    }

    public void subsetSum(int[] ar){
        findSums(ar, 0, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        int[] ar = {3,1,2};
        new SubsetSum().subsetSum(ar);
    }
}
