
package Lab2;
import java.util.Scanner;

public class No9 {

    public static boolean isPrime(int n) {

        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int max = -1;

        while (true) {

            int n = sc.nextInt();

            if (n == 0)
                break;

            if (isPrime(n) && n > max)
                max = n;
        }

        System.out.println(max);
    }
}