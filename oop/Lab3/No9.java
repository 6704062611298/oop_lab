package Lab3;

import java.util.Scanner;

public class No9 {

    public static int check(double x0, double y0,
                            double x1, double y1,
                            double x2, double y2) {

        double result = (x1 - x0) * (y2 - y0)
                      - (x2 - x0) * (y1 - y0);

        if (result == 0)
            return 0;
        else if (result < 0)
            return 1;
        else
            return 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double x0 = sc.nextDouble();
        double y0 = sc.nextDouble();
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println(check(x0, y0, x1, y1, x2, y2));
    }
}