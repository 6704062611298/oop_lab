package Lab3;

import java.util.Scanner;

public class No10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] start = new int[N];
        int[] end = new int[N];

        for (int i = 0; i < N; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < M; i++) {

            int light = sc.nextInt();

            for (int j = 0; j < N; j++) {

                if (light > start[j] && light < end[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}