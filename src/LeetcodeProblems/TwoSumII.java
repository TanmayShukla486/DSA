package LeetcodeProblems;

import java.util.Arrays;

public class TwoSumII {
    private boolean helper(int[] ar, int[] numbers, int low, int high, int target) {
        if (low > high) return false;
        int mid = (low + high) / 2;
        if (numbers[mid] == target){
            ar[1] = mid;
            return true;
        } else if (numbers[mid] > target) return helper(ar, numbers, low, mid - 1, target);
        else return helper(ar, numbers, mid + 1, high, target);
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length - 1;
        int[] ar = {-1,-1};
        for (int i = 0; i < n; i++) {
            ar[0] = i;
            if (helper(ar, numbers, i, n, target - numbers[i])) break;
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] ar = {2,7,9,11};
        System.out.println(Arrays.toString(new TwoSumII().twoSum(ar, 9)));
    }
}
