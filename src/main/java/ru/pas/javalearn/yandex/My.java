package ru.pas.javalearn.yandex;

import java.util.ArrayList;
import java.util.List;

public class My {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        int[] myArray1 = {1, 2, 3, 1, 2, 3, 2, 4, 0, 5, 3, 0};
        int[] myArray2 = {1, 3, 2, 5, 2, 6, 0, 0, 1, 3, 3};

        System.out.println(getControl(myArray1, myArray2));

        System.out.println((double) System.currentTimeMillis() - time);

    }

    private static List<Integer> getControl(int[] arr1, int[] arr2) {

        List<Integer> result = new ArrayList<>();
        int count = 0;

        // Бежим по первому массиву
        for (int i = 0; i < arr1.length; i++) {

            // Есть ли уже этот элемент в Результате
            if (!result.contains(arr1[i])) {

                // Сколько таких в первом массиве
                int count1 = linearSearch(arr1, arr1[i]);
                // Сколько таких во втором массиве
                int count2 = linearSearch(arr2, arr1[i]);
                // Берем больший
                if (count1 < count2) count = count1;
                else count = count2;

                // Добавляем
                if (count > 0 && count1 != 0 && count2 != 0)
                    for (int j = 0; j < count; j++)
                        result.add(arr1[i]);

            }
        }

        return result;

    }

    // Поиск в элемента в массиве и сколько раз
    private static int linearSearch(int[] array, int elementToSearch) {
        //{0, 6, 3, 6, 9, 7, 4, 7}
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToSearch) {
                count++;
//                System.out.print(array[i] + ": " + count + ", ");
                //0: 1, 3: 1, 4: 1, 6: 1, 6: 2, 7: 1, 7: 2
            }
        }

        return count;
    }

}
