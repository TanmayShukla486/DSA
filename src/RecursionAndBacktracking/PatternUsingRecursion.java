package RecursionAndBacktracking;

public class PatternUsingRecursion {

    private void printRow(int n) {
        if (n == 0) {
            System.out.println();
            return;
        }
        System.out.print("*");
        printRow(n - 1);
    }
    private void printRows(int n, int count) {
        if (count < n) {
            printRow(n);
            printRows(n, count + 1);
        }
    }
    public void printPattern(int n) {
        printRows(n, 0);
    }
    public static void main(String[] args) {
        new PatternUsingRecursion().printPattern(5);
    }
}
