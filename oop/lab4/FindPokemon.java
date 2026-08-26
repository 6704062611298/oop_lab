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

class PokemonFinder {
    private final int[][] grid;
    private final int H, W;

    public PokemonFinder(int[][] grid) {
        this.grid = grid;
        this.H = grid.length;
        this.W = grid[0].length;
    }

    public String findPikachuLocation() {
        int maxSum = -1;
        int bestR = -1, bestC = -1;

        // 
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W - 1; c++) {
                int diff = Math.abs(grid[r][c] - grid[r][c + 1]);
                int sum = grid[r][c] + grid[r][c + 1];
                if (diff <= 10 && sum > maxSum) {
                    maxSum = sum;
                    bestR = r + 1; // 1-based index
                    bestC = c + 1;
                }
            }
        }

        // 
        for (int r = 0; r < H - 1; r++) {
            for (int c = 0; c < W; c++) {
                int diff = Math.abs(grid[r][c] - grid[r + 1][c]);
                int sum = grid[r][c] + grid[r + 1][c];
                if (diff <= 10 && sum > maxSum) {
                    maxSum = sum;
                    bestR = r + 1;
                    bestC = c + 1;
                }
            }
        }

        return bestR + " " + bestC;
    }
}

public class FindPokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int H = sc.nextInt(), W = sc.nextInt();
        int[][] grid = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        PokemonFinder finder = new PokemonFinder(grid);
        System.out.println(finder.findPikachuLocation());
        sc.close();
    }
}