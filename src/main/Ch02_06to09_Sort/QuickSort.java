package Ch02_06to09_Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = new int[30];
        for (int i = 0; i < 30; i++) {
            A[i] = (int)(Math.random()*20);
        }
        System.out.println(Arrays.toString(A));
        quicksort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));

    }

    public static void quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = random_partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                exchange(A, i, j);
            }
        }
        exchange(A, i + 1, r);
        return i + 1;
    }

    public static int random_partition(int[] A, int p, int r) {
        int i = (int)Math.random()*r + p;
        exchange(A, i, r);
        return partition(A, p, r);
    }

    private static void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
