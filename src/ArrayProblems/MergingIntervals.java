package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {
    public static List<List< Integer >> mergeOverlappingIntervals(int [][]arr){
        if (arr.length == 0) return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(List.of(arr[0][0], arr[0][1])));
        for (int i = 1; i < arr.length; i++) {
            int n = answer.size();
            if (arr[i][0] > answer.get(n - 1).get(1)) {
                answer.add(new ArrayList<>(List.of(arr[i][0], arr[i][1])));
            } else {
                int maxValue = Math.max(answer.get(n - 1).get(1), arr[i][1]);
                answer.get(n - 1).set(1, maxValue);
            }
        }
        return answer;
    }
}
