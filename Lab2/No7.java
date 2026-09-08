package Lab2;
import java.util.Scanner;

class Rectangle2D {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(Rectangle2D r) {
        return Math.abs(r.x - x) + r.width / 2 <= width / 2 &&
               Math.abs(r.y - y) + r.height / 2 <= height / 2;
    }

    public boolean overlaps(Rectangle2D r) {
        return Math.abs(x - r.x) < (width + r.width) / 2 &&
               Math.abs(y - r.y) < (height + r.height) / 2;
    }
}

public class No7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double w1 = sc.nextDouble();
        double h1 = sc.nextDouble();

        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double w2 = sc.nextDouble();
        double h2 = sc.nextDouble();

        Rectangle2D r1 = new Rectangle2D(x1, y1, w1, h1);
        Rectangle2D r2 = new Rectangle2D(x2, y2, w2, h2);

        if (r1.contains(r2)) {
            System.out.println("r2 is inside r1");
        } else if (r1.overlaps(r2)) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 does not overlap r1");
        }
    }
}