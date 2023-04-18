/* Задача 1.
 * 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
 * 2) n! (произведение чисел от 1 до n)
*/
package Homework01.Task01;
import java.util.Scanner;

public class program {
    // рекурсивная функция нахождения треугольного числа
    static long recursSum(int n){
        if (n == 1) return 1;
        return n + recursSum(n-1);
    }
    // рекурсивная функция нахождения факториала
    static long recursMultiple(int n){
        if (n == 1) return 1;
        return n * recursMultiple(n-1);
    }

    public static void main(String[] args) {
        // Вводим number
        Scanner imputNum = new Scanner(System.in);
        System.out.printf("Imput number: ");
        int num = imputNum.nextInt();
        imputNum.close();
        // Проверяем, что number больше 0
        if(num>0) {
            // Считаем сумму и произведение рекурсией
            System.out.printf("Sum from 1 to %d is %d\n", num, recursSum(num));
            System.out.printf("Multiple from 1 to %d is %d\n", num, recursMultiple(num));
        } else {
            System.out.println("Incorrect number");
        }      
    }
}
