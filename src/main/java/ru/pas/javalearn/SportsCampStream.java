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

        /** ����� ����� ������ �������� �� ����������������� ���������� � ������ */
        findLongTime(sport);

        /** ������� ���������� � ����� ������������� ��������, ��������,
         * ������� ������ �� ������ � ������������� �Ivan�
         * � ���������� ������� ����� ��������� (�������� null ��������).*/
        sortAndFind(sport);

        // ������������� ���� ��������� � ������, �� ������ ������������ � �I� � ������� ��� � List.
        collectionToList(sport);

        /** Collectors �������� ������ ������������,
         * ������� ����� �������� �������� ��� ���������� �� �����������*/

        // ��������� ������ ���������
        joinDataCollection(sport);

        // ��������� ��� ����������
        reduce(sport);

    }

    /** reduce ��������� ��� ��������, ������ � ��������������,
     * ������ � �����������, � ������ ��� � ���������� ���������� */
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
                // ��������� (��������� ������ ���) null
                        filter((p) -> p.getName() != null).
                max((p1, p2) -> p1.getDay().compareTo(p2.getDay()));

        // ��������� �� �������!
        name.ifPresentOrElse(
                string -> System.out.println("Name = " + string.getName()),
                () -> System.out.println("NO")
        );
    }
}
