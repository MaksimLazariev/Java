/* Задача 3.
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */
package Homework03.Task03;

import java.util.ArrayList;
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

        int max = list.get(0);
        int min = list.get(0);
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            if (list.get(i)>max) max = list.get(i);
            if (list.get(i)<min) min = list.get(i);
            sum=sum+list.get(i);
        }
        System.out.printf("Max number: %d\n",max);
        System.out.printf("Min Number: %d\n",min);
        System.out.printf("Arithmetic mean: %.1f\n",((float)sum/list.size()));
        
    }
    
}
