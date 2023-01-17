package ru.pas.javalearn;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamLambda2 {

    // заполнение данными
    private static List<String> getPlaces() {
        // объявление списка
        final List<String> places = new ArrayList<>();

        // добавление страны и города
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");

        return places;
    }

    public static void main(String[] args) {

        List<String> myPlaces = getPlaces();
        System.out.println("Places from Nepal:");

        // Фильтрация по Листу
        myPlaces.stream()
                .filter(p -> p.startsWith("Nepal"))
//                .map(p -> p.toUpperCase())
                .map(String::toUpperCase)
                .sorted()
//                .forEach(p -> System.out.println(p));
                .forEach(System.out::println);
    }

}
