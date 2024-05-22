package LeetcodeProblems;

public class MaxRainWater {
    public int maxArea(int[] height) {
        int n = height.length, maxArea = 0;
        for (int i = n/2, j = n/2 + 1;i >= 0 && j < n;i--, j++) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
        }
    return maxArea;
    }
}
