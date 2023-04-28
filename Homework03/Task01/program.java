/* Задача 1.
 * Реализовать алгоритм сортировки слиянием  
 */

package Homework03.Task01;
import java.util.Arrays;
import java.util.Random;

public class program {
    // Генерируем массив
    private static int[] RandArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);            
        }
        System.out.println("Random array generated: ");
        System.out.printf(Arrays.toString(arr));
        
        return arr;
    }

    // Сортировка слиянием 
    public static int[] MergeSort(int[] arr01, int[] arr02, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return arr01;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] leftArr = MergeSort(arr01, arr02, startIndex, middle);
        int[] rightArr = MergeSort(arr01, arr02, middle, endIndex);

        //слияние
        int leftIndex = startIndex;
        int rightIndex = middle;
        int destIndex = startIndex;
        int[] result = leftArr == arr01 ? arr02 : arr01;
        while (leftIndex < middle && rightIndex < endIndex) {
            result[destIndex++] = leftArr[leftIndex] < rightArr[rightIndex]
                    ? leftArr[leftIndex++] : rightArr[rightIndex++];
        }
        while (leftIndex < middle) {
            result[destIndex++] = leftArr[leftIndex++];
        }
        while (rightIndex < endIndex) {
            result[destIndex++] = rightArr[rightIndex++];
        }
        return result;
    }
    public static void main(String args[]) {

        int n = 10;
        int[] array = RandArray(n);
        
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];

        int[] result = MergeSort(buffer1, buffer2, 0, array.length);
        System.out.println("\nArray sorted: ");
        System.out.println(Arrays.toString(result));
    }
}