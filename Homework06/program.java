// 1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
// 2. Создать множество ноутбуков.
// 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package Homework06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class program {

    // Метод заполнения словаря критериев
    public static Map<Integer, String> setCriteriesMap() {
        Map<Integer, String> setMap = new TreeMap<>();

        setMap.put(1, "Модель");
        setMap.put(2, "Диагональ экрана");
        setMap.put(3, "Оперативная память");
        setMap.put(4, "Память SSD");
        setMap.put(5, "Операционная система");
        setMap.put(6, "Цвет");
        setMap.put(7, "Цена");
        setMap.put(8, "Переход к подбору ноутбуков");

        return setMap;
    }

    public static  Set<Notebook> fillNotebookSet() {

        // Создаем несколько переменных нашего нового класса
        Notebook nb01 = new Notebook("HIPER G16", 16, 16, 512, "OEM", "Black", 125_990);
        Notebook nb02 = new Notebook("Huawei MateBook D15", 15, 8, 256, "Windows 11", "Silver", 49_990);
        Notebook nb03 = new Notebook("MSI GP66 Leopard", 15, 16, 512, "OEM", "Red", 125_990);
        Notebook nb04 = new Notebook("Huawei MateBook D16", 16, 16, 512, "Windows 10", "Silver", 79_990);
        Notebook nb05 = new Notebook("ASUS A516JP", 15, 16, 512, "OEM", "Red", 50_590);
        Notebook nb06 = new Notebook("MSI GF63 Thin", 15, 8, 256, "OEM", "White", 57_990);
        Notebook nb07 = new Notebook("Huawei MateBook D15", 15, 16, 512, "Windows 11", "Black", 63_990);
        Notebook nb08 = new Notebook("MSI GF63 Thin", 15, 8, 512, "Windows 10", "Black", 71_990);

        // создаем множество значений наших переменных
        Set<Notebook> notebooksSet = new HashSet<>(Arrays.asList(nb01, nb02, nb03, nb04, nb05, nb06, nb07, nb08));
        
        return notebooksSet;
    }


    // Метод заполнения словаря параметров для поиска
    public static Map<String, Object> fillSearchParameters(Map<Integer, String> criteries) {
        System.out.println(" Программа осуществляет поиск ноутбуков по заданным параметрам ");
        
        for (Map.Entry<Integer, String> entry : criteries.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        System.out.print("\nВведите критерий поиска и нажмите Enter: ");
        // System.out.print(">");        
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        Map<String, Object> parameters = new HashMap<>();        
        
        // Делаем подбор критериев для поиска ,пока не нажмем 8
        while(num!=8) {
            Integer tempInt;
            String tempString;
            switch (num) {
                case 1:
                System.out.print("Введите модель ноутбука: ");
                tempString = scanner.nextLine();
                parameters.put(criteries.get(num), tempString);
                break;

                case 2:
                System.out.print("Введите минимальный размер диагонали экрана: ");
                tempInt = scanner.nextInt();
                scanner.nextLine();                
                parameters.put(criteries.get(num), tempInt);
                break;

                case 3:
                System.out.print("Введите минимальный разиер оперативной памяти: ");
                tempInt = scanner.nextInt();
                scanner.nextLine();                
                parameters.put(criteries.get(num), tempInt);
                break;

                case 4:
                System.out.print("Введите минимальный размер памяти SSD: ");
                tempInt = scanner.nextInt();
                scanner.nextLine();                
                parameters.put(criteries.get(num), tempInt);
                break;

                case 5:
                System.out.print("Введите операционную систему: ");
                tempString = scanner.nextLine();                
                parameters.put(criteries.get(num), tempString);
                break;

                case 6:
                System.out.print("Введите цвет: ");
                tempString = scanner.nextLine();                
                parameters.put(criteries.get(num), tempString);
                break;

                case 7:
                System.out.print("Введите минимальную стоимость: ");
                tempInt = scanner.nextInt();                
                parameters.put(criteries.get(num), tempInt);
                break;
            
                default:
                System.out.print("Введено неверное значение, повторите снова");
                break;                
            }

            System.out.println("\nТекущие парамеры поиска: ");
            for (Map.Entry<String, Object>  parameter: parameters.entrySet()) {
                System.out.println(parameter);
            } 
            System.out.println("\n");
            for (Map.Entry<Integer, String> entry : criteries.entrySet()) {
                System.out.println(entry.getKey()+" - "+entry.getValue());
            }
            System.out.print("\nВведите следующий критерий поиска и нажмите Enter: ");
            num = scanner.nextInt();
            scanner.nextLine();

        }

        scanner.close();
        return parameters;
    }

    // одноразовый подбор по критериям
    public static Set<Notebook> notebookSelection( Map<Integer, String> criteries,  String entryKey, Object entryValue, Set<Notebook> notebooks ) {
        Set<Notebook> result = new HashSet<>();

        int i = 1; // для перебора критериев

            // Подбор по названию модели
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getModel().equals(entryValue)){
                        result.add(tempNotebook);                        
                    }
                }
            }
            i++;

            // Подбор по диагонали 
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getDiag()>=(Integer)entryValue){
                        result.add(tempNotebook);                        
                    }
                }
            }
            i++;

            // Подбор по размеру Оп пам
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getRam()==(Integer)entryValue){
                        result.add(tempNotebook);                        
                    }
                }
            }
            i++;

            // Подбор по SSD
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getSsd()>=(Integer)entryValue){
                        result.add(tempNotebook);                        
                    }
                }
            }
            i++;

            // Подбор по ОС
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getOs().equals(entryValue)){
                        result.add(tempNotebook);                        
                    }
                }
            }
            i++;

            // Подбор по цвету
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getColor().equals(entryValue)){
                        result.add(tempNotebook);                        
                    }
                }
            }
            i++;

            // Подбор по цене
            if(entryKey.equals(criteries.get(i))){
                Iterator<Notebook> it = notebooks.iterator();
                while(it.hasNext()){
                    Notebook tempNotebook = (Notebook) it.next();
                    if(tempNotebook.getPrice()>=(Integer)entryValue){
                        result.add(tempNotebook);                        
                    }
                }
            }

        return result;
    }

    // Метод поиска в множестве по критериям
    public static Set<Notebook> notebookSearch(Set<Notebook> notebooks){
        
        Set<Notebook> searchResult = new HashSet<>();
        searchResult.addAll(notebooks);

        // Создаем словарь критериев поиска (заполняем все возможные критерии)
        Map<Integer, String> criteriesMap = setCriteriesMap();
       
        // Заполняем словарь параметров поиска (пользователь выбирает параметры поиска) 
        Map<String, Object> searchParameters = fillSearchParameters(criteriesMap);        
        
        // Записываем в searchresult все наше множество ноутбуков, и каждый проход по циклу оставляем только ноутбуки, удовлетворяющие условиям поиска
        for (Map.Entry<String, Object > entry : searchParameters.entrySet()) {
            searchResult = notebookSelection(criteriesMap, entry.getKey(), entry.getValue(), searchResult);
        }
        return searchResult;
    }

    public static void main(String[] args) {
               
        Set<Notebook> notebooks = fillNotebookSet();
        Set<Notebook> searchResult = new HashSet<>();

        // получаем результат поиска по критерия и выводим на экран
        searchResult = notebookSearch(notebooks);

        System.out.println("\nРезультат поиска:\n");
        if(searchResult.isEmpty()) {
            System.out.println("Нет подходящих вариантов");
        } else {
            int i = 1;
            for (Notebook notebook : searchResult) {
                System.out.println(i+".");
                System.out.println(notebook.toString());
                i++;
            }
        }        
    }

}
