package Ch02_06to09_SORT;

import java.util.Arrays;

public class HeapSort {
    private static int heap_size;

    public static void main(String[] args) {
        int[] A = new int[30];
        heap_size = A.length;
        for (int i = 0; i < 30; i++) {
            A[i] = (int)(Math.random()*20);
        }
        System.out.println(Arrays.toString(A));
        heap_sort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void max_heapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < heap_size && A[l] > A[i])
            largest = l;
        else
            largest = i;

        if (r < heap_size && A[r] > A[largest])
            largest = r;

        if (largest != i) {
            exchange(A, i, largest);
            max_heapify(A, largest);
        }
    }

    private static void build_max_heap(int[] A) {
        for (int i = (heap_size - 1) /2; i >= 0; i--) {
            max_heapify(A, i);
        }
    }

    private static void heap_sort(int[] A) {
        build_max_heap(A);
        for (int i = A.length - 1; i >= 1; i--) {
            exchange(A, 0, i);
            heap_size--;
            max_heapify(A, 0);
        }
    }

    private static void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return 2 * i;
    }

    private static int right(int i) {
        return 2 * i + 1;
    }
}
