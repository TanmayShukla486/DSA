package ArrayProblems;

import java.util.*;

public class ThreeSum {
    public static List<List< Integer >> triplet(int n, int []arr) {
        // Write your code here.
        Set<List<Integer>> temp = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            HashSet<Integer> values = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = - (arr[i] + arr[j]);
                if (values.contains(third)) {
                    List<Integer> list = new ArrayList<>(List.of(arr[i], arr[j], third));
                    Collections.sort(list);
                    temp.add(list);
                }
                values.add(arr[j]);
            }
        }
        return new ArrayList<>(temp);
    }

    public static List<List<Integer>> tripletOptimal(int[] ar, int n) {
        Arrays.sort(ar);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = ar[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                sum += ar[j] + ar[k];
                while (j < k && sum < 0) {
                    sum -= ar[j++];
                    sum += ar[j];
                }
                while (k > j && sum > 0) {
                    sum -= ar[k--];
                    sum += ar[k];
                }
                if (j < k && sum == 0) {
                    answer.add(new ArrayList<>(List.of(ar[i], ar[j], ar[k])));
                    j++; k--;
                    while (j < k && ar[j] == ar[j - 1]) j++;
                    while (k > j && ar[k] == ar[k + 1]) k--;
                }
                sum = ar[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] input = "-18 -1 -44 -48 -9 -16 -36 -13 29 17 -12 9 -49".split(" ");
        int[] ar = new int[input.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input[i]);
        }
        System.out.println(tripletOptimal(ar, ar.length));
    }
}
