/* Реализовать консольное приложение, которое:

Принимает от пользователя и “запоминает” строки.
Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
Если введено revert, удаляет предыдущую введенную строку из памяти.
Если введено exit, завершаем программу
Пример:
java
python
c#
print > [c#, python, java]
revert
print > [python, java]
kotlin
print > [kotlin, python, java]
revert
revert
revert
print > []
revert > Ошибка!
exit -> (Программа завершилась)

 */

package Homework04.Task01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class program {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);

        List<String> storage = new ArrayList<>();
        root : while(true) {
            String text = sc.nextLine();
            // отработка выхода
            if ("exit".equals(text)) {
                break;
            }

            // отработка print, печатаем в обратном порядке
            if ("print".equals(text)) {
                System.out.printf("[ ");
                for (int i = storage.size()-1; i >= 0; i--) {
                    if(i>0) {
                        System.out.printf(storage.get(i) + ", ");
                    } else {
                        System.out.printf(storage.get(i) + " ");
                    }
                }
                System.out.printf("]\n");
                continue root;
            }

            // отработка revert
            if ("revert".equals(text)) {
                // Обрабатываем что ненулевой размер списка
                if (storage.size()>0 ) {
                    storage.remove(storage.size() - 1);
                    continue root;
                // Ошибка, если нулевой размер списка 
                } else {
                    System.out.println("Ошибка");
                    continue root;
                }
            }
            // если не сработали сравнения, добавляем элемент
            storage.add(text);

        }        
        sc.close();
    }
    
}
