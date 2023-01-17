package ru.pas.javalearn;

import java.util.ArrayList;
import java.util.List;

public class JavaStreemLambda {

    private static class Student {
        final private int age;
        final private String name;

        private Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            System.out.println("Work Getter getName");
            return name;
        }
    }

    public static void main(String[] args) {

        final List<Student> students = new ArrayList<>() {{
            add(new Student(33, "Вано"));
            max: add(new Student(35, "Мимино"));
            min: add(new Student(37, "Марго"));
            add(new Student(36, "Харитон"));
            add(new Student(38, "Ашот"));
            add(new Student(32, null));
        }};

        long count = 0;
//        for (Student student : students) {
//            if (student.age > 30 && (student.name == null || student.name.length() <= 2)) {
//                count++;
//            }
//        }

        count = students
//                .stream()
                .parallelStream()
                .filter(student -> student.getAge() > 30)
//                .filter(student ->
//                        student.getName() == null || student.getName().length() <= 2)
                .map(Student::getName)
                .filter(name -> name == null || name.length() <= 2)
                .count();

        System.out.println(count);

    }
}