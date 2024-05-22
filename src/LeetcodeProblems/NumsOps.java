package LeetcodeProblems;

import java.util.Arrays;

public class NumsOps {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void checkRight(int[] nums, int i) {
        int j = i + 1;
        while (j < nums.length) {
            if (nums[j] >= nums[i]) break;
            j++;
        }
        j--;
        if (j < nums.length)
            swap(nums, i, j);
    }

    private void checkLeft(int[] nums, int i) {
        int j = i - 1;
        while (j >= 0) {
            if (nums[j] <= nums[i]) break;
            j--;
        }
        j++;
        if (j >= 0)
            swap(nums, i, j);
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int medianIndex = nums.length / 2;
        if (nums[medianIndex] == k) return 0;
        long count = 0;
        while (nums[medianIndex] != k) {
            if (nums[medianIndex] < k) {
                int diff = k - nums[medianIndex];
                nums[medianIndex] += diff; count += diff;
                checkRight(nums, medianIndex);
            }
            else if (nums[medianIndex] > k) {
                int diff = nums[medianIndex] - k;
                nums[medianIndex] -= diff; count += diff;
                checkLeft(nums, medianIndex);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new NumsOps().minOperationsToMakeMedianK(new int[] {69,89,57,31,84,97,50,38,91}, 91);
    }
}
