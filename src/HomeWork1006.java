/*Сравнить все сортировки по быстродействию, результат предоставить
например в excel или google doc*/

public class HomeWork1006 {

    public static final int ITERATIONS = 100;
    public static final int LENTH_ARRAY = 1000;

    public static void main(String[] args) {

        int[] array = new int[LENTH_ARRAY];
        int totalTimeBubble = 0;
        int totalTimeInsert = 0;
        int totalTimeSelect = 0;
        int totalTimeQuick = 0;
        int totalTimeHeap = 0;
        int totalTimeMerge = 0;


        for (int i = 0; i < ITERATIONS; i++) {
            HomeWork1004.setArrayRandom(array);
            totalTimeMerge += HomeWork1005.runSortMerge(array);
            totalTimeHeap += HomeWork1005.runSortHeap(array);
            totalTimeQuick += HomeWork1005.runSortQuick(array);
            totalTimeSelect += HomeWork1004.sortSelect(array);
            totalTimeBubble += HomeWork1004.sortBubble(array);
            totalTimeInsert += HomeWork1004.sortInsert(array);
            System.out.println(i + 1 + " %");
        }
        System.out.println((double) totalTimeBubble / ITERATIONS + " ms");
        System.out.println((double) totalTimeInsert / ITERATIONS + " ms");
        System.out.println((double) totalTimeSelect / ITERATIONS + " ms");
        System.out.println((double) totalTimeQuick / ITERATIONS + " ms");
        System.out.println((double) totalTimeHeap / ITERATIONS + " ms");
        System.out.println((double) totalTimeMerge / ITERATIONS + " ms");
    }
}
