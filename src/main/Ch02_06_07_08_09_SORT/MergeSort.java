package Ch02_06_07_08_09_SORT;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int k = 20;
        int[] A = new int[30];
        for (int i = 0; i < 30; i++) {
            A[i] = (int)(Math.random()*k);
        }
        System.out.println(Arrays.toString(A));
        MergeSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));

    }

    public static void MergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            MergeSort(A, p, q);
            MergeSort(A, q + 1, r);
            Merge(A, p, q, r);
        }
    }

    public static void Merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}
