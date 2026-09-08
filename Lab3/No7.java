package Lab3;

import java.util.Scanner;

class MyTriangle {

    public boolean isValid(double side1, double side2, double side3) {
        return (side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1);
    }

    public double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

public class No7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        MyTriangle t = new MyTriangle();

        if (t.isValid(a, b, c)) {
            System.out.println(1);
            System.out.printf("%.2f", t.area(a, b, c));
        } else {
            System.out.println(0);
        }
    }
}