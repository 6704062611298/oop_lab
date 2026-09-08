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

class Star {

    // Insert "*" after each element
    public void addStars(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, "*");
        }
    }

    // Remove "*" after each element
    public void removeStars(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("*")) {
                list.remove(i);
            }
        }
    }
}

public class star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        // Read input words until an integer command is encountered
        while (sc.hasNext()) {
            if (sc.hasNextInt()) break;
            words.add(sc.next());
        }

        Star starObj = new Star();

        // Process commands (1: addStars, 2: removeStars)
        while (sc.hasNextInt()) {
            int cmd = sc.nextInt();
            if (cmd == 1) {
                starObj.addStars(words);
                System.out.println(words);
            } else if (cmd == 2) {
                starObj.removeStars(words);
                System.out.println(words);
            }
        }

        sc.close();
    }
}