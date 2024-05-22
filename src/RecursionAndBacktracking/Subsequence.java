package RecursionAndBacktracking;

import java.util.ArrayList;

public class Subsequence {
    private int[] arr;
    public void printSubsequence(int index, int size, ArrayList<Integer> list) {
        if (index == size) {
            System.out.println(list);
            return;
        }
        // Solved using concept of taking an index and not taking an index
        // Taking an index
        list.add(arr[index]);
        printSubsequence(index + 1, size, list);
        // Not taking an index
        list.remove(list.size() - 1);
        // proceeding without taking the element in the subsequence
        printSubsequence(index + 1, size, list);
    }

    private boolean subsequenceSum(int sum, int target, int index, ArrayList<Integer> list) {
        if (index >= arr.length) {
            if (sum == target) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        // Only used if all positive values in the list
//        else if (sum > target) {
//            sum -= arr[index - 1];
//            list.remove(Integer.valueOf(arr[index - 1]));
//            return;
//        }
        // Taking the index
        sum += arr[index];
        list.add(arr[index]);
        if (subsequenceSum(sum, target, index + 1, list)) return true;
        sum -= arr[index];
        list.remove(Integer.valueOf(arr[index]));
        return subsequenceSum(sum, target, index + 1, list);
    }

    private int countSubsequenceSum(int sum, int target, int index) {
        if (index >= arr.length) {
            if (sum == target)
                return 1;
            return 0;
        }
        // Only used if all positive values in the list
//        else if (sum > target) {
//            sum -= arr[index - 1];
//            list.remove(Integer.valueOf(arr[index - 1]));
//            return;
//        }
        // Taking the index
        sum += arr[index];
        int l = (countSubsequenceSum(sum, target, index + 1));
        sum -= arr[index];
        int r = (countSubsequenceSum(sum, target, index + 1));
        return l + r;
    }

    public static void main(String[] args) {
        Subsequence obj = new Subsequence();
        obj.arr = new int[] {1, 2, 1};
        obj.printSubsequence(0, 3, new ArrayList<>());
        System.out.println("--------------------------------------------------------");
        obj.subsequenceSum(0, 2, 0, new ArrayList<>());
        System.out.println(obj.countSubsequenceSum(0, 2, 0));
    }
}
