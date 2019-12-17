package com.elvis.Sort;

import static com.elvis.Sort.Sort.swap;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1)/ 2;
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] < arr[largest]? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }
}
