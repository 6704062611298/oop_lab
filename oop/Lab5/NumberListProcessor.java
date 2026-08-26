/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author intel
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class numberListProcessor {
    private final ArrayList<Integer> numbers;

    public numberListProcessor(ArrayList<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    // Calculate the average of all numbers
    public double getAverage() {
        if (numbers.isEmpty()) return 0;
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }

    // Find maximum value
    public int getMax() {
        return Collections.max(numbers);
    }

    // Find minimum value
    public int getMin() {
        return Collections.min(numbers);
    }

    // Remove all even numbers from the list
    public void removeEvens() {
        numbers.removeIf(n -> n % 2 == 0);
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}

public class NumberListProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        if (list.isEmpty()) return;

        numberListProcessor processor = new numberListProcessor(list);

        // 1. Print average
        System.out.printf("%.2f\n", processor.getAverage());

        // 2. Print max and min
        System.out.println(processor.getMax() + " " + processor.getMin());

        // 3. Remove even numbers and print the remaining list
        processor.removeEvens();
        for (int num : processor.getNumbers()) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}