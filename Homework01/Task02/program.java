/* Задача 2.
 * Вывести все простые числа от 1 до 1000
 */

package Homework01.Task02;

public class program {
    // функция проверки, простое число или нет
    static boolean isPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false; 
            }            
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 1000;
        System.out.printf("A number of primes up to %d\n", number);
        for (int i = 1; i <= number; i++) {
            // Проверяем, просто ли число, или нет
            if (isPrimeNumber(i)) {
                System.out.printf("%d ", i);
            } 
        }               
    }    
}
