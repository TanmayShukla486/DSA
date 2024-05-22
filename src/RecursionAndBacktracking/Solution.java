package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution{


    public int binarySearch(int[] ar, int start, int last, int target) {
//        System.out.println(start + "\t" + last);
        if (start > last) return -1;
        int mid = (start + last) / 2;
        if (ar[mid] == target) return mid;
        else if (ar[mid] > target) return binarySearch(ar, start, mid - 1, target);
        else return binarySearch(ar, mid + 1, last, target);
    }

    public void findTriplets(int x, int st, int en, int[] ar, ArrayList<Integer> list, List<List<Integer>> finalList, ArrayList<Integer> visited){
        if (st + 1 >= en) return;
        list.add(ar[st]);
        list.add(ar[en]);
//        System.out.println(list);
        int val = binarySearch(ar, st + 1, en - 1, x - ar[st] - ar[en]);
//        System.out.println(val);
        if (val != -1) {
            list.add(ar[val]);
            System.out.println(list);
            if (!finalList.contains(list)) {
                finalList.add((new ArrayList<>(list)));
            }
            else list.clear();
        } else list.clear();
        if (!list.isEmpty()) {
            list.clear();
            findTriplets(x, st + 1, en - 1, ar, list, finalList, visited);
        }
        else {
            findTriplets(x, st + 1, en, ar, list, finalList, visited);
            findTriplets(x, st, en - 1, ar, list, finalList, visited);
        }
    }

    public List<List<Integer>> threeSum(int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : ar) {
            map.compute(j, (key, val) -> (val == null) ? 1 : ++val);
        }
        int k = 0;
        int[] finalAr = new int[map.keySet().size()];
        for (Integer key: map.keySet()) {
            finalAr[k++] = Integer.valueOf(key);
        }
        List<List<Integer>> finalList = new ArrayList<>();
        int start = 0, end = finalAr.length - 1;
        findTriplets(0, start, end, finalAr, new ArrayList<>(), finalList, new ArrayList<>());
        return finalList;
    }
    
    public static void main(String[] args) {
        int[] ar = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        List<List<Integer>> finalList = new Solution().threeSum(ar);
        System.out.println(finalList);
    }
}