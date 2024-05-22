package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private int fac(int n) {
        if (n <= 1) return 1;
        return n * fac(n - 1);
    }
    public int givenNAndR(int n, int r) {
        int val = 1;
        for (int i = 0; i < r; i++) {
            val *= (n - i);
        }
        return val / fac(r);
    }

    public List<Integer> nthRow(int n){
        List<Integer> answer = new ArrayList<>();
        if (n == 1) {
            answer.add(1);
            return answer;
        }
        answer.add(1); int num = 1, den = 1;
        for (int i = 1; i < n - 1; i++) {
            num *= n - i;
            den *= i;
            answer.add(num / den);
        }
        answer.add(1);
        return answer;
    }

    public List<List<Integer>> generateTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            triangle.add(nthRow(i));
        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> answer = new PascalTriangle().generateTriangle(10);
        for (List<Integer> row: answer) System.out.println(row);
    }
}
