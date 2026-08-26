/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author intel
 */
import java.util.Scanner;

class OilDepositDetector {
    private final int m, n;
    private final char[][] grid;
    private final boolean[][] visited;

    public OilDepositDetector(int m, int n, char[][] grid) {
        this.m = m;
        this.n = n;
        this.grid = grid;
        this.visited = new boolean[m][n];
    }

    public int countDeposits() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@' && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '@' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;

        
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    dfs(r + dr, c + dc);
                }
            }
        }
    }
}

public class OilDeposits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m == 0 && n == 0) break;

            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                String line = sc.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            OilDepositDetector detector = new OilDepositDetector(m, n, grid);
            System.out.println(detector.countDeposits());
        }
        sc.close();
    }
}