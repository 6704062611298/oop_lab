/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author intel
 */
import java.util.Scanner;

class ConsecutiveChecker {
    private final int[][] grid;

    public ConsecutiveChecker(int[][] grid) {
        this.grid = grid;
    }

    // Check if 4 consecutive identical values exist horizontally, vertically, or diagonally
    public boolean isConsecutiveFour() {
        int R = grid.length;
        int C = grid[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int val = grid[r][c];

                // 1. Horizontal (Right)
                if (c + 3 < C && val == grid[r][c + 1] && val == grid[r][c + 2] && val == grid[r][c + 3])
                    return true;
                // 2. Vertical (Down)
                if (r + 3 < R && val == grid[r + 1][c] && val == grid[r + 2][c] && val == grid[r + 3][c])
                    return true;
                // 3. Diagonal (Down-Right)
                if (r + 3 < R && c + 3 < C && val == grid[r + 1][c + 1] && val == grid[r + 2][c + 2] && val == grid[r + 3][c + 3])
                    return true;
                // 4. Diagonal (Down-Left)
                if (r + 3 < R && c - 3 >= 0 && val == grid[r + 1][c - 1] && val == grid[r + 2][c - 2] && val == grid[r + 3][c - 3])
                    return true;
            }
        }
        return false;
    }
}

public class ConsecutiveFour2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        ConsecutiveChecker checker = new ConsecutiveChecker(grid);
        System.out.println(checker.isConsecutiveFour() ? 1 : 0);

        sc.close();
    }
}
