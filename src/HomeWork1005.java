/*Реализовать 3 сложные сортировки массива
Quick, Heap, Merge*/

import java.util.Arrays;

public class HomeWork1005 {
    public static void main(String[] args) {
        int[] array = new int[100000];
        HomeWork1004.setArrayRandom(array);
        System.out.println(runSortMerge(array) + " ms");
        System.out.println(runSortHeap(array) + " ms");
        System.out.println(runSortHeap(array) + " ms");
    }


    protected static int runSortQuick(int[] array) {
        int[] sortArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        sortQuick(sortArray, 0, sortArray.length - 1);
        long timeSpent = System.currentTimeMillis() - startTime;
        return (int) timeSpent;
    }

    protected static int runSortHeap(int[] array) {
        int[] sortArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        buildheap(sortArray);
        int sizeOfHeap = sortArray.length - 1;
        for (int i = sizeOfHeap; i > 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;
            sizeOfHeap = sizeOfHeap - 1;
            heapify(sortArray, 0, sizeOfHeap);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        return (int) timeSpent;
    }

    protected static int runSortMerge(int[] array) {
        int[] sortArray = Arrays.copyOf(array,array.length);
        int temp;
        long startTime = System.currentTimeMillis();
        sortMerge(sortArray, 0, sortArray.length - 1);
        long timeSpent = System.currentTimeMillis() - startTime;
        return (int) timeSpent;
    }

    private static void sortQuick(int[] sortArray, int low, int high) {
        if (sortArray.length == 0)
            return;
        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int support = sortArray[middle];
        int i = low, j = high;
        while (i <= j) {
            while (sortArray[i] < support) {
                i++;
            }
            while (sortArray[j] > support) {
                j--;
            }
            if (i <= j) {
                int temp = sortArray[i];
                sortArray[i] = sortArray[j];
                sortArray[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            sortQuick(sortArray, low, j);

        if (high > i)
            sortQuick(sortArray, i, high);
    }

    private static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max;
        if (left <= size && arr[left] > arr[i]) {
            max = left;
        } else {
            max = i;
        }

        if (right <= size && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, max, size);
        }
    }

    private static void buildheap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }
    }

    private static void sortMerge(int array[], int beg, int end) {
        if (beg<end)
        {
            int mid = (beg+end)/2;
            sortMerge(array, beg, mid);
            sortMerge(array , mid+1, end);
            merge(array, beg, mid, end);
        }
    }

    private static void merge(int array[], int beg, int mid, int end){
        int l = mid - beg + 1;
        int r = end - mid;

        int[] leftArray = new int [l];
        int[] rightArray = new int [r];

        for (int i=0; i<l; ++i)
            leftArray[i] = array[beg + i];

        for (int j=0; j<r; ++j)
            rightArray[j] = array[mid + 1+ j];


        int i = 0, j = 0;
        int k = beg;
        while (i<l&&j<r)
        {
            if (leftArray[i] <= rightArray[j])
            {
                array[k] = leftArray[i];
                i++;
            }
            else
            {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j<r)
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


}