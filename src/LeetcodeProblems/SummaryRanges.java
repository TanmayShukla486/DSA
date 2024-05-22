package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int start = nums[0];
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(start); sb.append("->");
        for (int i = 1; i < nums.length; i++) {
            if (sb.isEmpty()) {
                start = nums[i];
                sb.append(start); sb.append("->");
                continue;
            }
            else if (nums[i] - nums[i - 1] == 1) continue;
            sb.append(nums[i]);
            answer.add(sb.toString());
            sb.setLength(0);
        }
        if (sb.length() > 1) {
            sb.setLength(1);
            answer.add(sb.toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        new SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7});
    }
}
