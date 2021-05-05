package Ch02_06to09_SORT;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int k = 20;
        int[] A = new int[30];
        for (int i = 0; i < 30; i++) {
            A[i] = (int)(Math.random()*k);
        }
        System.out.println(Arrays.toString(A));
        InsertionSort(A);
        System.out.println(Arrays.toString(A));

    }

    public static void InsertionSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }
}
