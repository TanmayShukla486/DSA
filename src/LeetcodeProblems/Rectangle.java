package LeetcodeProblems;

public class Rectangle {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int len = 0;
        for (int i = 0; i < points.length; i++) {
            len = Math.max(points[i][0], len);
        }
        int[] hash = new int[len + 1];
        for (int i = 0; i < points.length; i++) {
            hash[points[i][0]]++;
        }
        int i = 0, count = 0;
        while (i <= len) {
            if (hash[i] != 0) {
                count++;
                if (w != 0)
                    i += w;
                else i++;
            } else i++;
        }
        return count;
    }

    public static void main(String[] args) {
        new Rectangle().minRectanglesToCoverPoints( new int[][]{{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}}, 2);
    }
}
