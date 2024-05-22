package ArrayProblems;

import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) {
//        new SortZeroOneTwo().sortArray(new int[] {1,1,1,1,2,0,0,0,1,2,1,1,0,1});

        int[] ar = {5,2,1,4,3,1};

//        System.out.println(new Kadane().findSum(ar));
//        System.out.println(Arrays.toString(new ArrangeBySign().rearrangeArray(ar)));

//        System.out.println(new StockBuySell().maxProfitOptimize1(ar));
//        new Leaders().findLeaders(ar);
//        System.out.println(new SubarraysWithXorK().findCount(ar.length, 6, ar));
//        System.out.println(new FourSum().findQuadruplets(ar, ar.length));
        System.out.println(new MissingNumberAndRepeatingNumber().findMissingAndRepeatingNumber(ar.length, ar));
    }

}
