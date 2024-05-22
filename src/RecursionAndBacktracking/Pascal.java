package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Pascal {
    private void generatePascal(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            row.add(1);
            ArrayList<Integer> tempRow = new ArrayList<>(row);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, tempRow.get(j - 1) + tempRow.get(j));
            }
            System.out.println(row);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        new Pascal().generatePascal(n);
    }
}
