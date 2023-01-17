package ru.pas.javalearn.yandex;

import java.util.ArrayList;

public class Dima {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        start();

        System.out.println((double) System.currentTimeMillis() - time);
    }

    private static void start() {

        //Car audi = new Car (100,5);
        //Car vw = new Car (100,5);

        //audi.speed_up(20);

        int a[] = {1, 2, 3, 1, 2, 3, 2, 4, 0, 5, 3, 0};
        int b[] = {1, 3, 2, 5, 2, 6, 0, 0, 1, 3, 3};
        ArrayList<Integer> array_wo_doble = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean trigger;

        for (int x : a) {
            trigger = true;
            if (array_wo_doble.isEmpty()) {
                array_wo_doble.add(x);
            } else {
                for (int z = 0; z < array_wo_doble.size(); z++) {
                    if (array_wo_doble.get(z) == x) trigger = false;
                }
                if (trigger) array_wo_doble.add(x);
            }
        }
        for (int c : array_wo_doble) for (int d : b) if (c == d) result.add(c);
        for (int res : result) System.out.println(res);

    }
}