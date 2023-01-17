package ru.pas.javalearn;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Stream {

    public static void main(String[] args) {
        /* stream https://habr.com/ru/post/302628/
        https://metanit.com/java/tutorial/10.12.php
        ���������� ������������� �������� �������� null �������� */
        ArrayList<Integer> testValuesNull = new ArrayList<>();
        testValuesNull.add(0, null);
        testValuesNull.add(1, 1);
        testValuesNull.add(2, 2);
        testValuesNull.add(3, 70);
        testValuesNull.add(4, 50);

        Optional<Integer> maxValueNotNull = testValuesNull.
                stream().
                // ��������� Null ������
                filter(Objects::nonNull).
                // ���� max
                max(Integer::compareTo);

        // ������� � ��������� ������� ������
        maxValueNotNull.ifPresentOrElse(
                integer -> System.out.println("maxValueNotNull = " + integer),
                () -> System.out.println("Value not found")
        );
    }

}