package ArrayProblems;

public class Kadane {
    public int findSum(int[] ar) {
        int i = 0, j = 0, finalIndex = 0;
        int sum = 0, maxSum = 0;
        while (j < ar.length) {
            sum += ar[j++];
            while (sum < 0) {
                i++;
                sum = 0;
            }
            if (maxSum < sum) {
                finalIndex = j;
                maxSum = sum;
            }
        }
        System.out.println(i + "->" + finalIndex);
        return maxSum;
    }
}
