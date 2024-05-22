package ArrayProblems;

public class ArrangeBySign {


    public int[] rearrangeArray(int[] ar) {
        int posIndex = 0, negIndex = 1;
        int[] ar1 = new int[ar.length];
        for (int j : ar) {
            if (j < 0) {
                ar1[negIndex] = j;
                negIndex += 2;
            } else {
                ar1[posIndex] = j;
                posIndex += 2;
            }
        }
        return ar1;
    }
}
