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
import java.util.ArrayList;
import java.util.List;

class CarSimulation {
    private final int m, n, t;
    private final int[][] road;
    private final List<Integer> moves = new ArrayList<>();

    public CarSimulation(int m, int n, int t, int[][] road) {
        this.m = m;
        this.n = n;
        this.t = t;
        this.road = road;
    }

    public boolean findPath(int time, int currentLane) {
        if (time == t) return true;

       
        int[] laneOffset = {-1, 1, 0};
        int[] moveChoice = {1, 2, 3};

        for (int i = 0; i < 3; i++) {
            int nextLane = currentLane + laneOffset[i];
            if (nextLane >= 1 && nextLane <= m && road[time][nextLane - 1] == 0) {
                moves.add(moveChoice[i]);
                if (findPath(time + 1, nextLane)) return true;
                moves.remove(moves.size() - 1);
            }
        }
        return false;
    }

    public void printMoves() {
        if (findPath(0, n)) {
            for (int move : moves) {
                System.out.println(move);
            }
        }
    }
}

public class CarObstacleAvoidance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[][] road = new int[t][m];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < m; j++) {
                road[i][j] = sc.nextInt();
            }
        }

        CarSimulation sim = new CarSimulation(m, n, t, road);
        sim.printMoves();
        sc.close();
    }
}