/*Реализовать 3 сортировки массива. Сравнить их по быстродействию:
    Bubble
    Insert
    Select*/

import java.util.Arrays;
import java.util.Random;

public class HomeWork1004 {
    public static void main(String[] args) {

        int lenthArray = 10000;
        int[] array = new int[lenthArray];
        setArrayRandom(array);
        System.out.println(sortInsert(array) + " ms");
        System.out.println(sortBubble(array) + " ms");
        System.out.println(sortSelect(array) + " ms");

    }



    protected static int sortSelect(int[] array) {
        int[] sortArray = Arrays.copyOf(array,array.length);
        int temp;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < sortArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortArray.length; j++) {
                if (sortArray[j] < sortArray[minIndex]) {
                    minIndex = j;
                }
            }
            temp = sortArray[i];
            sortArray[i] = sortArray[minIndex];
            sortArray[minIndex] = temp;
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        return (int) timeSpent;
    }

    protected static int sortBubble(int[] array) {
        int[] sortArray = Arrays.copyOf(array,array.length);
        int temp;
        long startTime = System.currentTimeMillis();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < sortArray.length; i++) {
                if (sortArray[i] < sortArray[i - 1]) {
                    temp = sortArray[i];
                    sortArray[i] = sortArray[i - 1];
                    sortArray[i - 1] = temp;
                    needIteration = true;
                }
            }
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        return (int) timeSpent;
    }

    protected static int sortInsert(int[] array) {
        int[] sortArray = Arrays.copyOf(array,array.length);
        int temp;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < sortArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (sortArray[j] < sortArray[j - 1]) {
                    temp = sortArray[j];
                    sortArray[j] = sortArray[j - 1];
                    sortArray[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        return (int) timeSpent;
    }

    protected static void setArrayRandom(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }


    }
}
