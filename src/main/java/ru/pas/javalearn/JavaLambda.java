package ru.pas.javalearn;

public class JavaLambda {

    @FunctionalInterface // ��������� ��� ��������� ��������������
    private interface MyInterface {

        String joinDots(String msg);

    }

    // ������������������� ���������
    @FunctionalInterface
    private interface GenericInterface<X, Y> {

        // ������������������� �����
        X func(Y value);
    }

    public static void main(String[] args) {

        MyInterface myInterface = msg -> msg + "...";
        System.out.println(myInterface.joinDots("����� �� ������"));

        MyInterface myInterface1 = String::toLowerCase;
        System.out.println(myInterface1.joinDots("����� �Ѩ ���"));


        // ���������� ������ �� ������������������� ���������
        // ������� ��������� String
        // � ���������� �� ������
        GenericInterface<String, String> reverse = (str) -> {

            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        System.out.println("Lambda reversed = " + reverse.func("javaLambda"));

        // ���������� ������ �� ������������������� ���������
        // ������� ��������� Integer
        // � ���������� �� ������
        GenericInterface<String, Integer> factorial = (n) -> {

            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return "��������� " + n + " �����: " + result;
        };

        System.out.println(factorial.func(5));

    }

}