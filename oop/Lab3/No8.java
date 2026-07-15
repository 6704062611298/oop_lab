package Lab3;

import java.util.Scanner;

public class No8 {

    public static double m(int i) {
        double sum = 0;

        for (int k = 1; k <= i; k++) {
            sum += (double) 1 / (2 * k - 1);
        }

        return 4 * sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        System.out.printf("%.4f", m(i));
    }
}