/*
 * Определить, является ли последовательность скобочек корректной
 * () -> true
 * [] -> true
 * [) -> false
 * ([)] -> false
 * ( - >  false
 * ([{}()<>}) -> true
 */

package Seminar05.Task04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class program {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()"));
        System.out.println(isCorrectParentheses("[]"));
        System.out.println(isCorrectParentheses("([)]"));
        System.out.println(isCorrectParentheses("[)"));
        System.out.println(isCorrectParentheses("("));
        System.out.println(isCorrectParentheses("([{}()<>])"));
        
    }

    private static boolean isCorrectParentheses(String input) {
        Map<Character, Character> brackets = Map.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>'

        );
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = input.toCharArray();
        for (char symbol: chars) {
            // symbol является откр скобкой -> добавляем скобку в стэк
            if(brackets.containsKey(symbol)) { 
                stack.addFirst(symbol);
            // symbol является закр скобкой
            } else {
                // встретили закр скобочку раньше открывающей - > ошибка
                if (stack.isEmpty()) {  
                    return false;
                }
                // берем последний добавленный элемент из стэка
                char lastSymbolOpenPair = stack.pollFirst();
                // берем скобку из словаря по последнему элементу стэка
                char lastSymbolClosedPair = brackets.get(lastSymbolOpenPair);
                // нужно проверить, что скобки одного типа
                if (lastSymbolClosedPair!= symbol) {
                    return false;
                }
            }

        }
        // проверяем, что стек с открывающими скобками пустой
        return stack.isEmpty();
    }
    
}
