package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    private void generatePermutations(List<int[]> list, int[] ar, int i) {
        if (i >= ar.length) {
            list.add(ar.clone());
            return;
        }
        for (int j = i; j < ar.length; j++) {
            swap(ar, i, j);
            generatePermutations(list, ar, i + 1);
            swap(ar, i, j);
        }
    }
    public void bruteForce(int[] ar) {
        List<int[]> list = new ArrayList<>();
        generatePermutations(list, ar, 0);
        for(int[] array: list) System.out.println(Arrays.toString(array));
    }

    public void optimalSolution(int[] ar) {
        int breakPoint = ar.length - 2;
        for (int j = breakPoint; j >= 0; j--){
            if (ar[j + 1] > ar[j]) {
                breakPoint = j;
                break;
            }
        }
        int swappingValue = Integer.MIN_VALUE;
        for (int i = ar.length - 1; i > breakPoint; i--) {
            if (ar[i] > ar[breakPoint]) {
                swappingValue = i;
                break;
            }
        }
        swap(ar, breakPoint, swappingValue);
        for (int i = breakPoint + 1, j = ar.length - 1; i < j ; i++, j--)
            swap(ar, i, j);
        System.out.println(Arrays.toString(ar));
    }
}
