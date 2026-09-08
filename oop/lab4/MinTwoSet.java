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

class minTwoSet {
    private final int[] weights;
    private int minDiff = Integer.MAX_VALUE;

    public minTwoSet(int[] weights) {
        this.weights = weights;
    }

    public int solve() {
        int totalSum = 0;
        for (int w : weights) totalSum += w;
        findMin(0, 0, totalSum);
        return minDiff;
    }

    private void findMin(int index, int currentSum, int totalSum) {
        if (index == weights.length) {
            int diff = Math.abs((totalSum - currentSum) - currentSum);
            if (diff < minDiff) minDiff = diff;
            return;
        }
        findMin(index + 1, currentSum + weights[index], totalSum);
        findMin(index + 1, currentSum, totalSum);
    }
}

public class MinTwoSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        minTwoSet solver = new minTwoSet(weights);
        System.out.println(solver.solve());
        sc.close();
    }
}