/* Задача 2. 
 * Реализуйте алгоритм сортировки пузырьком числового массива, 
 * результат после каждой итерации запишите в лог-файл.
 */

package Homework02.Task02;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.io.IOException;
import java.util.logging.Level;


public class program {

    // Метод сортировки пузырьком. 
    private static int[] BubbleSort(int[] arr) throws IOException {
        int temp=0;

        Logger log = Logger.getLogger(program.class.getName());
        FileHandler fh = new FileHandler("logger.log");
        log.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());

        for (int i = 0; i < arr.length; i++)
        {
            System.out.printf("\nStage %d: ", i+1);
            boolean checker = false;          // Переменная для проверки, был ли обмен значениями при проходе второго цикла
            for (int j = 0; j < arr.length-i-1; j++)
            {
                if(arr[j]>arr[j+1])         // Если элемент больше следующего, делаем обмен значениями  
                {
                    temp = arr[j];          // обмен
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    checker = true;         // ставим значение, что был обмен
                }
                            
            }

            log.setLevel(Level.INFO);
            log.log(Level.INFO, String.format("Поменяли местами значения"));
            String str = Arrays.toString(arr);
            log.log(Level.INFO, String.format(str));
            // System.out.printf(Arrays.toString(arr));
            
            // если не было обменов, то выходим из цикла For, сортировка окончена.
            if(!checker) {
                log.log(Level.INFO, String.format("Сортировка окончена"));   
                return arr;
            }         
        }
        return arr;
    }    
    
    public static void main(String[] args) throws IOException {
        int n = 10;
        int[] array = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);            
        }
        System.out.println("Random array generated: ");
        System.out.printf(Arrays.toString(array));


        int[] sortedArray = BubbleSort(array);
        System.out.println("\nArray sorted: ");
        System.out.printf(Arrays.toString(sortedArray));
    }


        
}
    

