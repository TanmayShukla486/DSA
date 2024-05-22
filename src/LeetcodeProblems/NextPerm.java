package LeetcodeProblems;

public class NextPerm {
    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    private void reverse(int[] ar, int start, int end) {
        while (start < end) {
            swap(ar, start, end);
            start++; end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        else if (n == 2) {
            swap(nums, 0, 1);
            return;
        }
        int i = n - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) i--;
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
    }

    public static void main(String[] args) {
        new NextPerm().nextPermutation(new int[]{1,5,1});
    }
}
