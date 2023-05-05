/*
 *  Дан текст, который состоит из слов, разделенных пробелами.
 *  Нужно распечатать статистику слов, т.е. определить, какое слово сколько раз встречалось
 *  Частоту нужно вывести в порядке возрастания
 * 
 *  1 -> react php js
 *  2 -> python
 *  3 -> java
 */

package Seminar05.Task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class program {
    public static void main(String[] args) {
        

        String text = "java java python c# c++ java python sql kotlin pascal go js react php ";
        printStringCount(text);
        

    }

    private static void printStringCount(String text) {
        Map<Integer, List<String>> stats = new TreeMap<>();
        // Создаем список из исходного текста, делим слова по пробелу
        List<String> words = Arrays.asList(text.split("\\s+"));  // "\\s+" - несколько пробелов
        // перебираем все слова в списке
        for (String word: words) {
            // Находим частоту совпадения слова в списке, она будет ключом
            int freq = Collections.frequency(words, word);
            // если уже есть такой ключ в словаре, то берем список по ключу, добавляем туда элемент
            if (stats.containsKey(freq)) {
                List<String> tempList = stats.get(freq);
                tempList.add(word);
            // Иначе создаем новую пару ключ - значение в словаре
            } else {
                stats.put(freq, new ArrayList<>(List.of(word)));
            }

            // // 2й способ
            // // Находим частоту совпадения слова в списке, она будет ключом
            // int freq = Collections.frequency(words, word);
            // // создаем список для дальнейшего добавления в словарь 
            // List<String> toAdd = new ArrayList<>();
            // if(stats.containsKey(freq)) {
            //     // если уже есть такой ключ в словаре, то берем список по ключу из словаря 
            //     toAdd = stats.get(freq);
            // }
            // // добавляем слово в список
            // toAdd.add(word);
            // // добвляем (или перезаписываем) пару ключ-значение в словарь
            // stats.put(freq, toAdd);

            // 3й способ
            // List<String> toAdd = stats.getOrDefault(freq, new ArrayList<>());
            // // добавляем слово в список
            // toAdd.add(word);
            // // добвляем (или перезаписываем) пару ключ-значение в словарь
            // stats.put(freq, toAdd);

        }
        
        for(Map.Entry<Integer, List<String>> entry: stats.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(key + "->" + value);
        }
        
        // System.out.println(stats);
        
    }
}

 