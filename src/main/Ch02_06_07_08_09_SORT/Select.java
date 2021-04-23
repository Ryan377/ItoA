package Ch02_06_07_08_09_SORT;

public class Select {
    public static void main(String[] args) {
        int[] A = new int[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        System.out.println(randomSelect(A, 0, A.length - 1, 4));
    }

    public static int randomSelect(int[] A, int p, int r, int i) {
        if (p == r)
            return A[p];
        int q = random_partition(A, p, r);
        int k = q - p + 1;
        if (i == k)
            return A[q];
        if (i < k)
            return randomSelect(A, p, q - 1, i);
        return randomSelect(A, q + 1, r, i - k);
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
