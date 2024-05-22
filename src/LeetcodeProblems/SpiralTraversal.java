package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, top = 0, right = n, bottom = m;
        int i, k = 0;
        while (k < m * n) {
            i = left;
            while (i < right) {
                answer.add(matrix[top][i++]); k++;
            }
            right--; i = top;
            while (i < bottom) {
                answer.add(matrix[i++][right]); k++;
            }
            bottom--; i = right - 1;
            while (i >= left) {
                answer.add(matrix[bottom][i--]); k++;
            }
            top++; i = bottom - 1;
            while (i >= top) {
                answer.add(matrix[i--][left]); k++;
            }
            left++;
        }
        return answer;
    }
}
