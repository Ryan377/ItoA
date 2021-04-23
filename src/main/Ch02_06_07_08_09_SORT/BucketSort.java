package Ch02_06_07_08_09_SORT;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        double[] A = new double[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.random();
        }
        System.out.println(Arrays.toString(A));
        System.out.println(bucketsort(A));
    }

    public static ArrayList<Double> bucketsort(double[] A) {
        int n = A.length;
        List<Double>[] B = new List[n];
        for (int i = 0; i < n; i++) {
            B[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            B[ (int)(n * A[i]) ].add(A[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(B[i]);
        }
        ArrayList<Double> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (Double j : B[i]) {
                ret.add(j);
            }
        }
        return ret;
    }
}
