package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {

    /*TODO Revise the topic*/

    private int moveI(char direction) {
        return switch(direction) {
            case 'D' -> 1;
            case 'U' -> -1;
            default -> 0;
        };
    }
    private int moveJ(char direction) {
        return switch(direction) {
            case 'R' -> 1;
            case 'L' -> -1;
            default -> 0;
        };
    }

    private boolean outOfBounds(int i, int j, int n) {
        return (i < 0) || (j < 0) || (i == n) || (j == n);
    }

    private boolean isPossible(int i, int j, int[][] maze, int n) {
        if (outOfBounds(i, j, n)) return false;
        else return maze[i][j] != 0;
    }

    private void helper(int[][] maze, boolean[][] visited, int n, char[] directions, List<String> routes, StringBuilder path, int i, int j) {
        if (i == n - 1 && j == n - 1) {
            // Upon reaching the end of the grid we add the current path taken to the possible paths list
            routes.add(path.toString());
            return;
        }
        for (char direction : directions) {
            // checking movement in all four possible directions
            i += moveI(direction); j += moveJ(direction);
            // if is possible to move to a certain index we do so
            if (isPossible(i, j, maze, n) && !visited[i][j]) {
                path.append(direction);
                visited[i][j] = true;
                helper(maze, visited, n, directions, routes, path, i, j);
//                path.deleteCharAt(path.length() - 1);
            }
            else {
                i -= moveI(direction); j -= moveJ(direction);
            }
        }
    }

    private void changeDirections(char[] directions) {
        char c = directions[0];
        for (int i = 1; i < 4; i++) directions[i - 1] = directions[i];
        directions[3] = c;
    }

    public List<String> findRoutes(int[][] maze, char[] directions) {
        List<String> routes = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < 4; i++) {
            for (boolean[] row: visited) Arrays.fill(row, false);
            visited[0][0] = true;
            if (i != 0) changeDirections(directions);
            helper(maze, visited, n, directions, routes, new StringBuilder(), 0, 0);
        }
        return routes;
    }

    public static void main(String[] args) {
        int [][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        List<String> solutions = new RatInAMaze().findRoutes(maze, new char[]{'D','L','R','U'});
        System.out.println(solutions);
    }
}
