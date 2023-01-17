package ru.pas.javalearn;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

// https://habr.com/ru/post/302628/
public class SportsCampMainStream {
    public static void main(String[] args) {

        Collection<SportsCamp> sport = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp("Ivan", 3),
                new SportsCamp(null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );

        /** ����� ����� ������ �������� �� ����������������� ���������� � ������ */
        Optional<SportsCamp> name = sport.
                stream().
                // ��������� (��������� ������ ���) null
                filter((p) -> p.getName() != null).
                max((p1, p2) -> p1.getDay().compareTo(p2.getDay()));

        // ��������� �� �������!
        name.ifPresentOrElse(
                string -> System.out.println("Name = " + string.getName()),
                () -> System.out.println("NO")
        );

        /** ������� ���������� � ����� ������������� ��������, ��������,
         * ������� ������ �� ������ � ������������� �Ivan�
         * � ���������� ������� ����� ��������� (�������� null ��������).*/
        long countName = sport.
                stream().
                filter(p -> p.getName() != null && p.getName().equals("Ivan")).
                count();
        System.out.println("countName Ivan = " + countName);

    }
}
