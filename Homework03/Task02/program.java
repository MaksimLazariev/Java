/* Задача 2.
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */

package Homework03.Task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class program {
    private static ArrayList<Integer> RandList(int n) {
        ArrayList<Integer> arr = new ArrayList<>(n);
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            arr.add(rand.nextInt(10));
        }
    return arr;
    }

    public static void main(String[] args) {
        int n = 10;
        ArrayList<Integer> list = RandList(n);
       
        System.out.println("List generated:");
        System.out.println(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            int even = list.get(i) % 2;
            if (even == 0) {
                list.remove(i);
            }
        }
        Collections.sort(list);
        System.out.println("List with deleted even numbers: \n " + list);

        
    }
    
}
