package ru.pas.javalearn;

public class JavaLambda {

    @FunctionalInterface // Проверяет что Интерфейс Функциональный
    private interface MyInterface {

        String joinDots(String msg);

    }

    // Параметризированный интерфейс
    @FunctionalInterface
    private interface GenericInterface<X, Y> {

        // параметризированный метод
        X func(Y value);
    }

    public static void main(String[] args) {

        MyInterface myInterface = msg -> msg + "...";
        System.out.println(myInterface.joinDots("Нужны ли Лямбды"));

        MyInterface myInterface1 = String::toLowerCase;
        System.out.println(myInterface1.joinDots("ЗАЧЕМ ВСЁ ЭТО"));


        // Объявление ссылки на параметризированный интерфейс
        // который принимает String
        // и присвоение ей лямбды
        GenericInterface<String, String> reverse = (str) -> {

            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        System.out.println("Lambda reversed = " + reverse.func("javaLambda"));

        // Объявление ссылки на параметризированный интерфейс
        // который принимает Integer
        // и присвоение ей лямбды
        GenericInterface<String, Integer> factorial = (n) -> {

            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return "Факториал " + n + " будет: " + result;
        };

        System.out.println(factorial.func(5));

    }

}