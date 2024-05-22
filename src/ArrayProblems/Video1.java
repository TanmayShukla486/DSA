package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class Video1 {
    private boolean isSorted(int[] ar) {
        for (int i = ar.length - 2; i >= 0; i--) if (ar[i] > ar[i + 1]) return false;
        return true;
    }

    private int removeDuplicates(int[] ar) {
        int i = 0;
        for (int j = 1; j < ar.length; j++) {
            if (ar[j] != ar[i]) ar[++i] = ar[j];
        }
        return i + 1;
    }

    private int singleOccurringElement(int[] ar) {
        int element = ar[0];
        for (int i = 1; i < ar.length; i++) element ^= ar[i];
        return element;
    }

    private int maxOnes(int[] ar) {
        int len = 0; int i;
        for (i = 0; i < ar.length && ar[i] != 1; i++);
        int count = 0;
        for (;i < ar.length; i++) {
            if (ar[i] == 1) count++;
            else {
                len = Math.max(count, len);
                count = 0;
            }
        }
        return len;
    }

    private int findMissing(int[] ar) {
        int element = 0;
        for (int i = 0; i < ar.length; i++) {
            element ^= (i+1);
            element ^= ar[i];
        }
        return element;
    }

    private int[] unionOfArrays(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && a[i] < b[j]) answer.add(a[i++]);
        while (j < b.length && b[j] < a[i]) answer.add(b[j++]);
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                answer.add(a[i++]); j++;
            }
            else if (a[i] < b[j]) answer.add(a[i++]);
            else answer.add(b[j++]);
        }
        while (i < a.length) answer.add(a[i++]);
        while (j < b.length) answer.add(b[j++]);
        int[] ar = new int[answer.size()];
        for (int k = 0; k < answer.size(); k++) ar[k] = answer.get(k);
        return ar;
    }

    private int[] intersectionOfArrays(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length){
            if (a[i] == b[j]) {
                answer.add(a[i++]); j++;
            }
            else if (a[i] < b[j]) i++;
            else j++;
        }
        int[] ar = new int[answer.size()];
        for (int k = 0; k < answer.size(); k++) ar[k] = answer.get(k);
        return ar;
    }
}
