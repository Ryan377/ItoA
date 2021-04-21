package DCC;

public class FindMaxSubarray {
    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] ret = FindMaxSubarray(A, 0, 15);
        System.out.println("原数组为：");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
        System.out.println("最大子数组(和为" + ret[2] + "): ");
        for (int i = ret[0]; i <= ret[1]; i++) {
            System.out.print(A[i]+" ");
        }
    }

    public static int[] FindMaxSubarray(int[] A, int low, int high) {
        if (high == low) {
            int[] ret = {low, high, A[low]};
            return ret;
        }
        int mid = (low + high) / 2;
        int[] ret1 = FindMaxSubarray(A, low, mid);
        int[] ret2 = FindMaxSubarray(A, mid + 1, high);
        int[] ret3 = FindMaxCrossSubarray(A, low, mid, high);
        if (ret1[2] >= ret2[2] && ret1[2] >= ret3[2])
            return ret1;
        if (ret2[2] >= ret3[2])
            return ret2;
        return ret3;
    }

    public static int[] FindMaxCrossSubarray(int[] A, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        int max_left = mid;
        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        int right_sum = Integer.MIN_VALUE;
        int max_right = mid + 1;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + A[i];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = i;
            }
        }
        sum = left_sum + right_sum;
        int[] ret = {max_left, max_right, sum};
        return ret;
    }
}
