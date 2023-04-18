/* Задача 3.
 * Реализовать простой калькулятор
 */
package Homework01.Task03;
import java.util.Scanner;

public class program {
    
    // Метод сложения
    static int Sum(int x, int y) {
        return x+y;
    }
    // Метод вычитания
    static int Difference(int x, int y) {
        return x-y;
    }
    // Метод умножения
    static int Multiplicate(int x, int y) {
        return x*y;
    }
    // Метод деления
    static double Division(int x, int y) {
        return x/y;
    }
    public static void main(String[] args) {
        // Вводим числа и оператор
        Scanner imputScan = new Scanner(System.in);
        System.out.printf("Imput first number: ");
        int num01 = imputScan.nextInt();
        System.out.printf("Imput operation (+,-,*,/): ");
        char operator =  imputScan.next().charAt(0);
        System.out.printf("Imput second number: ");
        int num02 = imputScan.nextInt();
        imputScan.close();

        double result = 0;
        boolean noErrors = true;

        // выбор действия по оператору
        switch (operator){
            case '+':
                result = Sum(num01, num02);
                break;
            case '-':
                result = Difference(num01, num02);
                break;
            case '*':
                result = Multiplicate(num01, num02);
                break;
            case '/':
                // Проверяем деление на 0
                if (num02 == 0) {
                    System.out.println("Zero Division Error");
                    noErrors = false;
                    break;
                }
                result = Division(num01, num02);
                break;
            // Вариант неверного оператора
            default:
                System.out.println("Incorrect operation");
                noErrors = false;
        }
        // Если нет ошибок, выводим результат
        if(noErrors) {
            // Проверяем, результат int или double
            if(result % 1 == 0) {
                System.out.printf("%d %s %d = %d", num01, operator, num02, (int)result);
            } else {
                System.out.printf("%d %s %d = %f", num01, operator, num02, result);
            }
        }
    }    
}
