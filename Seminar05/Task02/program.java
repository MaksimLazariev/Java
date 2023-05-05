/*
 *  Дан текст, который состоит из слов, разделенных пробелами.
 *  Нужно распечатать статистику длин слов, т.е. определить, какую длину имеет слово
 *  вывести по возрастанию длины слова
 * 
 *  2 -> js c# go
 *  3 -> php sql c++
 *  4 -> java
 *  5 -> react
 *  6 - > python kotlin
 */

package Seminar05.Task02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class program {
    public static void main(String[] args) {

        String text = "java java python c# c++ java python sql kotlin pascal go js react php ";
        printStringLengthStats(text);

    }

    private static void printStringLengthStats(String text) {

        // Заводим значения как Set, чтоб исключить повторы
        Map<Integer, Set<String>> stats = new TreeMap<>();
        // Создаем список из исходного текста, делим слова по пробелу
        List<String> words = Arrays.asList(text.split("\\s+")); // "\\s+" - несколько пробелов
        for (String word : words) {
            int length = word.length();
            // если нет ключа в словаре, то добавляем новую пару в словарь
            if (!stats.containsKey(length)) {
                Set<String> value = new HashSet<>(); // HashSet(HashMap), TreeSet(Treemap), LinkedHashSet
                value.add(word);
                stats.put(length, value);
                // иначе вытаскиваем значение по ключу, дописываем туда слово
            } else {
                Set<String> value = stats.get(length);
                value.add(word);
            }
        }

        for (Map.Entry<Integer, Set<String>> entry : stats.entrySet()) {
            Integer key = entry.getKey();
            Set<String> value = entry.getValue();
            System.out.println(key + "->" + value);
        }

    }

}
