package Ch02_06to09_Sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int k = 20;
        int[] A = new int[30];
        int[] B = new int[30];
        for (int i = 0; i < 30; i++) {
            A[i] = (int)(Math.random()*k);
        }
        countingsort(A, B, k);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

    }

    public static void countingsort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        for (int i = 1; i < k; i++) {
            C[i] += C[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]] = C[A[i]] - 1;
        }
    }
}
