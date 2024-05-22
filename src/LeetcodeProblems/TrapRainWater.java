package LeetcodeProblems;

public class TrapRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n], maxRight = new int[n], minHeight = new int[n];
        int maxLeftHeight = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 < 0) maxLeft[i] = maxLeftHeight;
            else {
                maxLeft[i] = Math.max(maxLeftHeight, maxLeft[i - 1]);
            }
                maxLeftHeight = Math.max(maxLeftHeight, height[i]);
        }
        int maxRightHeight = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 == n) maxRight[i] = maxRightHeight;
            else {
                maxRight[i] = Math.max(maxRightHeight, maxRight[i + 1]);
            }
            maxRightHeight = Math.max(maxRightHeight, height[i]);
        }
        for (int i = 0; i < n; i++) {
            minHeight[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int trappedWater = minHeight[i] - height[i];
            answer += Math.max(trappedWater, 0);
        }
        return answer;
    }
    public static void main(String[] args) {
        new TrapRainWater().trap(new int [] {4,2,0,3,2,5});
    }
}
