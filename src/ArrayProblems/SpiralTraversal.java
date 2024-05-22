package ArrayProblems;

import java.util.Arrays;

public class SpiralTraversal {
    public void traverse(int[][] ar) {
        int columns = ar[0].length;
        int rows = ar.length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        int k = 0;
        while (k < rows * columns) {

            for (int i = left; i <= right; i++) {
                k++;
                System.out.print(ar[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                k++;
                System.out.print(ar[i][right] + " ");
            }
            right--;

            for (int i = right; i >= left; i--) {
                k++;
                System.out.print(ar[bottom][i] + " ");
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                k++;
                System.out.print(ar[i][left] + " ");
            }
            left++;
        }
    }
    public static void main(String[] args){
        int[][] ar = new int[4][4];
        int k = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                ar[i][j] = k++;
        for (int i = 0; i < 4; i++) System.out.println(Arrays.toString(ar[i]));
        new SpiralTraversal().traverse(ar);
    }
}
