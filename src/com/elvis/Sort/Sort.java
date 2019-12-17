package com.elvis.Sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 2, 6};
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
