package ru.pas.javalearn;

public class Main {

    // Параметризированный интерфейс
    @FunctionalInterface
    private interface GenericInterface<X, Y> {

        // параметризированный метод
        X func(Y value);
    }

    public static void main(String[] args) {

    }

}