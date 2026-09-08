package Lab7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * Solution for Maze Navigation with Bomb Placement Problem.
 * Finds valid bomb targets and the shortest path length to the exit.
 * 
 * @author intel
 */
public class TheMaze {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        // Read maze dimensions (rows M, columns N)
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        // Read 1-based start and end coordinates
        int rStart = sc.nextInt();
        int cStart = sc.nextInt();
        int rEnd = sc.nextInt();
        int cEnd = sc.nextInt();

        // Read grid values (1 = path, 0 = wall)
        int arr[][] = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // Convert 1-based indexing to 0-based indexing
        int sr = rStart - 1;
        int scCol = cStart - 1;
        int er = rEnd - 1;
        int ec = cEnd - 1;

        // Calculate shortest distances from Start and End using BFS
        int[][] distStart = bfs(sr, scCol, r, c, arr);
        int[][] distEnd = bfs(er, ec, r, c, arr);

        int validWallCount = 0;
        int minDistance = Integer.MAX_VALUE;

        // Direction vectors for moving Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Iterate through all cells to find valid wall targets to blast
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) { // Check only wall cells
                    int bestFromStart = Integer.MAX_VALUE;
                    int bestFromEnd = Integer.MAX_VALUE;

                    // Check all 4 adjacent cells around the wall
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                            if (distStart[nr][nc] != -1) {
                                bestFromStart = Math.min(bestFromStart, distStart[nr][nc]);
                            }
                            if (distEnd[nr][nc] != -1) {
                                bestFromEnd = Math.min(bestFromEnd, distEnd[nr][nc]);
                            }
                        }
                    }

                    // If blasting this wall connects the start path to the end path
                    if (bestFromStart != Integer.MAX_VALUE && bestFromEnd != Integer.MAX_VALUE) {
                        validWallCount++;
                        // Total path = (steps from start) + 1 (blasted wall) + (steps to end) + 1 (start cell offset)
                        int totalPath = bestFromStart + 1 + bestFromEnd + 1;
                        minDistance = Math.min(minDistance, totalPath);
                    }
                }
            }
        }

        // Output results according to problem specifications
        System.out.println(validWallCount);
        System.out.println(minDistance);

        sc.close();
    }

    /**
     * Helper method to perform Breadth-First Search (BFS) on walkable paths (1s).
     * 
     * @param startR Starting row coordinate
     * @param startC Starting column coordinate
     * @param M Total rows
     * @param N Total columns
     * @param grid 2D maze representation
     * @return 2D array containing shortest distance from start to each accessible cell (-1 if unreached)
     */
    private static int[][] bfs(int startR, int startC, int M, int N, int[][] grid) {
        int[][] dist = new int[M][N];
        // Initialize distance array with -1 (unvisited)
        for (int[] row : dist) Arrays.fill(row, -1);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        
        // Start BFS if the origin is a walkable path
        if (grid[startR][startC] == 1) {
            dist[startR][startC] = 0;
            queue.add(new int[]{startR, startC});
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];

            // Traverse 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                // Move to valid adjacent path cells that haven't been visited
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && grid[nr][nc] == 1 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[currR][currC] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}