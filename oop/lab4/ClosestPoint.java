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

// 2 Point
class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // (Euclidean Distance)
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// 
class PointCalculator {
    private final Point[] points;

    public PointCalculator(Point[] points) {
        this.points = points;
    }

    // 
    public double findClosestDistance() {
        double minDistance = Double.MAX_VALUE;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
}

public class ClosestPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Point[] points = new Point[n];

        // ObjectPoint
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        // Object
        PointCalculator calculator = new PointCalculator(points);
        double minDistance = calculator.findClosestDistance();

        System.out.printf("%.2f\n", minDistance);

        scanner.close();
    }
}