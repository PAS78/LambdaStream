package ru.pas.javalearn;

public class Main {

    // ������������������� ���������
    @FunctionalInterface
    private interface GenericInterface<X, Y> {

        // ������������������� �����
        X func(Y value);
    }

    public static void main(String[] args) {

    }

}