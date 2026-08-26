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
import java.util.Scanner;

class SortMergeList {

    // Return a new list containing elements found in both sorted lists
    public ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            int val1 = list1.get(i);
            int val2 = list2.get(j);

            if (val1 == val2) {
                result.add(val1);
                i++;
                j++;
            } else if (val1 < val2) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}

public class sortMergeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Read list1 (terminated by 0)
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == 0) break;
            list1.add(val);
        }

        // Read list2 (terminated by 0)
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == 0) break;
            list2.add(val);
        }

        SortMergeList merger = new SortMergeList();
        ArrayList<Integer> result = merger.intersect(list1, list2);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();
    }
}
