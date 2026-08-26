/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab7;

/**
 *
 * @author intel
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class MazeSolver {
    private final int M, N;
    private final int startR, startC, endR, endC;
    private final int[][] grid;
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public MazeSolver(int M, int N, int startR, int startC, int endR, int endC, int[][] grid) {
        this.M = M;
        this.N = N;
        this.startR = startR - 1;
        this.startC = startC - 1;
        this.endR = endR - 1;
        this.endC = endC - 1;
        this.grid = grid;
    }

    public void solve() {
        int[][] distStart = bfs(startR, startC);
        int[][] distEnd = bfs(endR, endC);

        int validWallCount = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0) { // Wall cell
                    int bestFromStart = Integer.MAX_VALUE;
                    int bestFromEnd = Integer.MAX_VALUE;

                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                            if (distStart[nr][nc] != -1)
                                bestFromStart = Math.min(bestFromStart, distStart[nr][nc]);
                            if (distEnd[nr][nc] != -1)
                                bestFromEnd = Math.min(bestFromEnd, distEnd[nr][nc]);
                        }
                    }

                    if (bestFromStart != Integer.MAX_VALUE && bestFromEnd != Integer.MAX_VALUE) {
                        validWallCount++;
                        int pathLen = bestFromStart + 1 + bestFromEnd + 1;
                        minDistance = Math.min(minDistance, pathLen);
                    }
                }
            }
        }

        System.out.println(validWallCount);
        System.out.println(minDistance);
    }

    private int[][] bfs(int sr, int sc) {
        int[][] dist = new int[M][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        if (grid[sr][sc] == 1) {
            dist[sr][sc] = 0;
            queue.add(new int[]{sr, sc});
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && grid[nr][nc] == 1 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}

public class TheMazeBygpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int M = sc.nextInt();
        int N = sc.nextInt();
        int sr = sc.nextInt();
        int scCol = sc.nextInt();
        int er = sc.nextInt();
        int ec = sc.nextInt();

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        MazeSolver solver = new MazeSolver(M, N, sr, scCol, er, ec, grid);
        solver.solve();

        sc.close();
    }
}