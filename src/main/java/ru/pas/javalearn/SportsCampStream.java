package ru.pas.javalearn;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// https://habr.com/ru/post/302628/
public class SportsCampStream {
    public static void main(String[] args) {

        Collection<SportsCamp> sport = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp("Ivan", 3),
                new SportsCamp(null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );

        /** Поиск имени самого большого по продолжительности нахождения в лагере */
        findLongTime(sport);

        /** добавим сортировку и вывод определенного элемента, например,
         * добавим фильтр по именам с встречающимся «Ivan»
         * и произведем подсчет таких элементов (исключим null значения).*/
        sortAndFind(sport);

        // Преобразовать одну коллекцию в другую, по именам начинающимся с «I» и запишем это в List.
        collectionToList(sport);

        /** Collectors обладает массой возможностей,
         * включая вывод среднего значения или информации со статистикой*/

        // Соединяем данные Коллекции
        joinDataCollection(sport);

        // Суммируем дни прибывания
        reduce(sport);

    }

    /** reduce принимает три значения, первый – идентификатора,
     * второй – аккумулятор, а третий это – фактически «объедение» */
    private static void reduce(Collection<SportsCamp> sport) {
        Integer daySum = sport.stream().
                reduce(0, (sum, p) -> sum += p.getDay(), (sum1, sum2) -> sum1 + sum2);
        System.out.println("DaySize = " + daySum);
    }

    private static void joinDataCollection(Collection<SportsCamp> sport) {
        String campPeople = sport.stream().
                filter(p -> p.getName() != null).
                map(SportsCamp::getName).
                collect(Collectors.joining(" and ", "In camp ", " rest all days."));
        System.out.println(campPeople);
    }

    private static void collectionToList(Collection<SportsCamp> sport) {
        List<SportsCamp> onlyI = sport.stream().
                filter(p -> p.getName() != null && p.getName().startsWith("I")).
                toList();
        System.out.println("SIZE = " + onlyI.size());
    }

    private static void sortAndFind(Collection<SportsCamp> sport) {
        long countName = sport.stream().
                filter(p -> p.getName() != null && p.getName().equals("Ivan")).
                count();
        System.out.println("countName Ivan = " + countName);
    }

    private static void findLongTime(Collection<SportsCamp> sport) {
        Optional<SportsCamp> name = sport.stream().
                // Исключаем (фильтруем записи без) null
                        filter((p) -> p.getName() != null).
                max((p1, p2) -> p1.getDay().compareTo(p2.getDay()));

        // Проверяем на пустоту!
        name.ifPresentOrElse(
                string -> System.out.println("Name = " + string.getName()),
                () -> System.out.println("NO")
        );
    }
}
