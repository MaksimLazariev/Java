/* Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow"
 */
package Homework02.Task01;

import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;

public class program {
    private static String[] ReadFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int ch;
            while ((ch = br.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] tempArray = sb.toString().split("[\\s\\p{Punct}]+");
        String[] result = new String[tempArray.length - 1];
        System.arraycopy(tempArray, 1, result, 0, 8);
        return result;
    }

    private static String makingQuery(String[] array) {
        StringBuilder result = new StringBuilder("SELECT * FROM students WHERE ");
        for (int i =0; i < array.length; i+=2) {
            if(array[i+1].equals("null") == false) {
                if ((i != 0)&&((i>=4)||(array[i-1].equals("null") == false))) {
                    result.append(" and ");
                    result.append(array[i]);
                    result.append(" = ");
                    result.append(array[i+1]);
                } else {
                    result.append(array[i]);
                    result.append(" = ");
                    result.append(array[i+1]);
                }
            }
            
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] jsonArray = ReadFile("Homework02/Task01/test.txt");
        System.out.println(Arrays.toString(jsonArray));
        String request = makingQuery(jsonArray);
        System.out.println(request);
    }
}
