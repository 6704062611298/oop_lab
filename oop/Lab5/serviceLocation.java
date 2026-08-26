/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package K.I.B;

/**
 *
 * @author intel
 */
import java.util.Scanner;

class ServiceLocationFinder {
    private final int M, N, K;
    private final int[][] grid;

    public ServiceLocationFinder(int M, int N, int K, int[][] grid) {
        this.M = M;
        this.N = N;
        this.K = K;
        this.grid = grid;
    }

    // Find maximum total population in any K x K sub-grid
    public int findMaxPopulation() {
        // Construct 2D Prefix Sum Table for O(M*N) runtime efficiency
        int[][] pref = new int[M + 1][N + 1];

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                pref[r + 1][c + 1] = grid[r][c] + pref[r][c + 1] + pref[r + 1][c] - pref[r][c];
            }
        }

        int maxPop = 0;
        for (int r = K; r <= M; r++) {
            for (int c = K; c <= N; c++) {
                int total = pref[r][c] - pref[r - K][c] - pref[r][c - K] + pref[r - K][c - K];
                if (total > maxPop) {
                    maxPop = total;
                }
            }
        }
        return maxPop;
    }
}

public class serviceLocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        ServiceLocationFinder finder = new ServiceLocationFinder(M, N, K, grid);
        System.out.println(finder.findMaxPopulation());

        sc.close();
    }
}