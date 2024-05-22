package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public void helper(String s, int stIndex,List<String> currPartitions, List<List<String>> partitions) {
        if (stIndex >= s.length()) {
            partitions.add(new ArrayList<>(currPartitions));
            return;
        }
        for (int i = stIndex + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(stIndex, i))) {
                currPartitions.add(s.substring(stIndex, i));
                helper(s, i, currPartitions, partitions);
                currPartitions.remove(s.substring(stIndex, i));
            }
        }
    }

    public List<List<String>> partitionString(String s) {
        List<List<String>> partitions = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), partitions);
        return partitions;
    }

    public static void main(String[] args) {
        List<List<String>> partitions = new PalindromePartitioning().partitionString("aaabbb");
        System.out.println(partitions);
    }
}
