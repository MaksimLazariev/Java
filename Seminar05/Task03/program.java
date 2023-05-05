package Seminar05.Task03;

/*
          * Нужно определить, являются ли слова изоморфными
          * Слова будем называть изоморфными, если каждую букву первого 
          * можно однозначно перевести в соответствующую (по индексу) букву во втором слове
          * 
          * Пример:
          * egg, add -> true [e -> a, g-> d]
          * paper, title -> true [p->t, a->i, e->l, r->e]
          * foo, bar -> false [f->b, o->a, XX]         * 
          */

import java.util.HashMap;
import java.util.Map;

public class program {
    public static void main(String[] args) {

        System.out.println(isIsomorph("egg", "add"));
        System.out.println(isIsomorph("paper", "title"));
        System.out.println(isIsomorph("foo", "bar"));

    }

    private static boolean isIsomorph(String first, String second) {

        // Проверка на совпадение длины слов
        if (first.length() != second.length()) {
            return false;
        }

        // Создаем словарь для записи букв (буква первого слова - ключ -> буква второго
        // слова - значение)
        Map<Character, Character> mapping = new HashMap<>();
        // Проходим по всей длине каждых слов
        for (int i = 0; i < first.length(); i++) {
            char firstSymbol = first.charAt(i);
            char secondSymbol = second.charAt(i);
            // проверяем, что буквы 1го слова нет в словаре, записываем пару (буква 1го
            // слова - буква 2го слова)
            if (!mapping.containsKey(firstSymbol)) {
                mapping.put(firstSymbol, secondSymbol);
                // Если буква 1го слова уже была, сверяем значение из словаря по ключу (букве
                // 1го слова) с буквой 2го слова
            } else {
                char anotherSecondSymbol = mapping.get(firstSymbol);
                // Если пара не совпадает, возвращаем false
                if (anotherSecondSymbol != secondSymbol) {
                    return false;
                }
            }
        }
        return true;
    }

}
